package com.cscloud.common.config.configuration;

import java.lang.reflect.Method;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;




/**
 * redis对应的配置文件,springboot在2.0.3之后不用我们配置了直接使用
 * StringRedisTemplate就可以了，开启缓存
 * https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/reference/htmlsingle/
 * @author Administrator
 *
 */
@EnableCaching
@Configuration
public class RedisConfiguration {
	/**
	   *  注解@Cache key生成规则
	   */
	  @Bean
	  public KeyGenerator keyGenerator() {
	      return new KeyGenerator() {
	        @Override
	        public Object generate(Object target, Method method, Object... params) {
	             StringBuilder sb = new StringBuilder();
	             sb.append(target.getClass().getName());
	             sb.append(method.getName());
	             for (Object obj : params) {
	                 sb.append(obj.toString());
	             }
	             return sb.toString();
	        }
	      };
	  }
	 
	  /**
		 * Cache manager cache manager.
		 *
		 * @param redisTemplate the redis template
		 *
		 * @return the cache manager
		 */
		@Bean
		public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
			return RedisCacheManager.create(connectionFactory);
		}

}
