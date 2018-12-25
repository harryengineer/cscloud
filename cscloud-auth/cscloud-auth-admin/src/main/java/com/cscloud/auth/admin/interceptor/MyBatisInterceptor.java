package com.cscloud.auth.admin.interceptor;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.stat.TableStat;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.druid.util.JdbcConstants;
import com.cscloud.auth.admin.domain.AuthOperateLogPo;
import com.cscloud.auth.admin.service.AuthOperateLogPoService;
import com.cscloud.auth.common.util.BaseContextMap;
import com.cscloud.common.base.util.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.*;

/**
 *  mybatis拦截器，将来将用户的操作放到对应的数据库中去
 * @Auther: Administrator
 * @Date: 2018/12/20 19:31
 * @Description:
 */
@Slf4j
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})}
)
@Component
public class MyBatisInterceptor implements Interceptor {


    @Autowired
    private AuthOperateLogPoService authOperateLogPoService;

    private List CREATE_FIELD =  new ArrayList<String>(){{
        add("crtUser");
        add("crtName");
        add("crtHost");
    }};

    private  List UPDATE_FIELD =  new ArrayList<String>(){{
        add("updUser");
        add("updName");
        add("updHost");
    }};


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        if (ms.getSqlCommandType() != SqlCommandType.INSERT && ms.getSqlCommandType() != SqlCommandType.UPDATE) {
            return invocation.proceed();
        }

       if(log.isInfoEnabled()){
            log.info("进入 PrepareInterceptor 拦截器...");
        }

       //如果是执行器的话
       if (invocation.getTarget() instanceof Executor && args.length == 2 && args[1] != null) {
            return invokeUpdate(ms,args[1],invocation);
        }

        return invocation.proceed();
    }

    //对插入和更新进行参数获取
    private Object invokeUpdate(MappedStatement ms,Object paramObj,Invocation invocation) throws Exception {
        Executor executor = (Executor) invocation.getTarget();
        // 插入语句只传一个基本类型参数, 不做处理
        if (ClassUtils.isPrimitiveOrWrapper(paramObj.getClass())
                || String.class.isAssignableFrom(paramObj.getClass())
                || Number.class.isAssignableFrom(paramObj.getClass())) {
            return invocation.proceed();
        }

        BoundSql boundSql = ms.getBoundSql(paramObj);

        // 解析mysql数据库地址,保存更新数据
        if (boundSql != null && !StringUtils.isEmpty(boundSql.getSql())){
            String sql = boundSql.getSql();
            String dbType = JdbcConstants.MYSQL;
            //格式化输出
            String result = SQLUtils.format(sql, dbType);
            List<SQLStatement> stmtList = SQLUtils.parseStatements(sql, dbType);
            for (int i = 0; i < stmtList.size(); i++) {
                SQLStatement stmt = stmtList.get(i);
                MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
                stmt.accept(visitor);
                Map<TableStat.Name, TableStat> tables = visitor.getTables();
                Set<Map.Entry<TableStat.Name, TableStat>> entries = tables.entrySet();
                for (Map.Entry<TableStat.Name, TableStat> entry : entries) {
                    //操作之后的值
                    if (!"auth_operate_log".equals(entry.getKey().getName())){
                        AuthOperateLogPo po = new AuthOperateLogPo();
                        po.setSqlContext(paramObj.toString());
                        po.setCrtTime(new Date());
                        po.setOpType(entry.getValue().toString());
                        po.setTableName(entry.getKey().getName());
                        po.setCrtHost(BaseContextMap.getHost());
                        po.setCrtUser(BaseContextMap.getUserID());
                        po.setCrtName(BaseContextMap.getName());
                        authOperateLogPoService.save(po);
                    }
                }
            }

        }

        if (ms.getSqlCommandType() == SqlCommandType.UPDATE){
            processParam(paramObj,UPDATE_FIELD);

        }else{
            processParam(paramObj,CREATE_FIELD);
        }

        return executor.update(ms, paramObj);
    }


    /**
     *  添加的时候自动加上对应的值
     * @param parameterObject
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    private void processParam(Object parameterObject, List<String> list) throws IllegalAccessException, InvocationTargetException {
        for (String PARAM_KEY : list) {
            // 如果参数是bean，反射设置值
            PropertyDescriptor ps = BeanUtils.getPropertyDescriptor(parameterObject.getClass(), PARAM_KEY);
            if (ps != null && ps.getReadMethod() != null && ps.getWriteMethod() != null) {
                  switch (PARAM_KEY){
                      case "crtUser":
                          ps.getWriteMethod().invoke(parameterObject, BaseContextMap.getUserID());
                          break;
                      case "crtHost":
                          ps.getWriteMethod().invoke(parameterObject, BaseContextMap.getHost());
                          break;
                      case "crtName":
                          ps.getWriteMethod().invoke(parameterObject, BaseContextMap.getName());
                          break;
                      case "updUser":
                          ps.getWriteMethod().invoke(parameterObject, BaseContextMap.getUserID());
                          break;
                      case "updHost":
                          ps.getWriteMethod().invoke(parameterObject, BaseContextMap.getHost());
                          break;
                      case "updName":
                          ps.getWriteMethod().invoke(parameterObject, BaseContextMap.getName());
                          break;
                      default:
                          break;
                  }
            }
        }
    }


    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }
}
