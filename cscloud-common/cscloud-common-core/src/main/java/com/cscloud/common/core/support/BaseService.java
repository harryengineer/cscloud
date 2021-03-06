package com.cscloud.common.core.support;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.cscloud.common.core.bean.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cscloud.common.base.exception.BaseException;
import com.cscloud.common.core.mybatis.MyMapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

/**
 * 在原有的基础上进行进一层的封装，避免service层写对应的实现类
 * @author Administrator
 *
 * @param <T>
 */
public abstract class BaseService<M extends MyMapper<T>,T> implements IService<T> {

	/**
	 * The Logger.
	 */
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * The Mapper.
	 */
	@Autowired
	protected M mapper;

	/**
	 * Gets mapper.
	 *
	 * @return the mapper
	 */
	public Mapper<T> getMapper() {
		return mapper;
	}

	/**
	 * Select list.
	 *
	 * @param record the record
	 *
	 * @return the list
	 */
	@Override
	public List<T> select(T record) {
		return mapper.select(record);
	}

	/**
	 * Select by key t.
	 *
	 * @param key the key
	 *
	 * @return the t
	 */
	@Override
	public T selectByKey(Object key) {
		return mapper.selectByPrimaryKey(key);
	}

	/**
	 * Select all list.
	 *
	 * @return the list
	 */
	@Override
	public List<T> selectAll() {
		return mapper.selectAll();
	}

	/**
	 * Select one t.
	 *
	 * @param record the record
	 *
	 * @return the t
	 */
	@Override
	public T selectOne(T record) {
		return mapper.selectOne(record);
	}

	/**
	 * Select count int.
	 *
	 * @param record the record
	 *
	 * @return the int
	 */
	@Override
	public int selectCount(T record) {
		return mapper.selectCount(record);
	}

	/**
	 * Select by example list.
	 *
	 * @param example the example
	 *
	 * @return the list
	 */
	@Override
	public List<T> selectByExample(Object example) {
		return mapper.selectByExample(example);
	}

	/**
	 * Save int.
	 *
	 * @param record the record
	 *
	 * @return the int
	 */
	@Override
	public int save(T record) {
		return mapper.insertSelective(record);
	}

	/**
	 * Batch save int.
	 *
	 * @param list the list
	 *
	 * @return the int
	 */
	@Override
	public int batchSave(List<T> list) {
		int result = 0;
		for (T record : list) {
			int count = mapper.insertSelective(record);
			result += count;
		}
		return result;
	}

	/**
	 * Update int.
	 *
	 * @param entity the entity
	 *
	 * @return the int
	 */
	@Override
	public int update(T entity) {
		return mapper.updateByPrimaryKeySelective(entity);
	}

	/**
	 * Delete int.
	 *
	 * @param record the record
	 *
	 * @return the int
	 */
	@Override
	public int delete(T record) {
		return mapper.delete(record);
	}

	/**
	 * Delete by key int.
	 *
	 * @param key the key
	 *
	 * @return the int
	 */
	@Override
	public int deleteByKey(Object key) {
		return mapper.deleteByPrimaryKey(key);
	}

	/**
	 * Batch delete int.
	 *
	 * @param list the list
	 *
	 * @return the int
	 */
	@Override
	public int batchDelete(List<T> list) {
		int result = 0;
		for (T record : list) {
			int count = mapper.delete(record);
			if (count < 1) {
				logger.error("删除数据失败");
				throw new BaseException("删除数据失败!");
			}
			result += count;
		}
		return result;
	}

	/**
	 * Select count by example int.
	 *
	 * @param example the example
	 *
	 * @return the int
	 */
	@Override
	public int selectCountByExample(Object example) {
		return mapper.selectCountByExample(example);
	}

	/**
	 * Update by example int.
	 *
	 * @param record  the record
	 * @param example the example
	 *
	 * @return the int
	 */
	@Override
	public int updateByExample(T record, Object example) {
		return mapper.updateByExampleSelective(record, example);
	}

	/**
	 * Delete by example int.
	 *
	 * @param example the example
	 *
	 * @return the int
	 */
	@Override
	public int deleteByExample(Object example) {
		return mapper.deleteByPrimaryKey(example);
	}

	/**
	 * Select by row bounds list.
	 *
	 * @param record    the record
	 * @param rowBounds the row bounds
	 *
	 * @return the list
	 */
	@Override
	public List<T> selectByRowBounds(T record, RowBounds rowBounds) {
		return mapper.selectByRowBounds(record, rowBounds);
	}

	/**
	 * Select by example and row bounds list.
	 *
	 * @param example   the example
	 * @param rowBounds the row bounds
	 *
	 * @return the list
	 */
	@Override
	public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
		return mapper.selectByExampleAndRowBounds(example, rowBounds);
	}

	@Override
	public PageInfo<T> getPage(PageBean pageBean){
		PageHelper.startPage(pageBean.getPage(),pageBean.getLimit());
		List<T> list = mapper.selectAll();
		return new PageInfo<T>(list);
	}

//	 public String selectByQuery(LinkedHashMap<K, V> query) {
//	        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
//	        Example example = new Example(clazz);
//	        if(query.entrySet().size()>0) {
//	            Example.Criteria criteria = example.createCriteria();
//	            for (Map.Entry<String, Object> entry : query.entrySet()) {
//	                criteria.andLike(entry.getKey(), "%" + entry.getValue().toString() + "%");
//	            }
//	        }
//	        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
//	        return ResUtils.okRes(result);
//	    }


	
	
	/**
	 * 获取唯一的generate的id
	 * @return
	 */
//	protected long generateId() {
////		return UniqueIdGenerator.getInstance(IncrementIdGenerator.getServiceId()).nextId();
//	}
}
