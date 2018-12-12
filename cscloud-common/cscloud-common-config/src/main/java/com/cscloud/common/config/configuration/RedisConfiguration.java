package com.cscloud.common.config.configuration;

import java.lang.reflect.Method;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;




/**
 * 
 * 2.0 之后的redis的配置
 * @author Administrator
 *
 */
@EnableCaching
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
		public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
			return RedisCacheManager.create(connectionFactory);
		}

		@Bean
		public StringRedisSerializer stringRedisSerializer() {
			return new StringRedisSerializer();
		}

		@Bean("redisTemplate")
		public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
			RedisTemplate<String, Object> template = new RedisTemplate<>();
			template.setConnectionFactory(factory);
			Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
			ObjectMapper om = new ObjectMapper();
			om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
			om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
			jackson2JsonRedisSerializer.setObjectMapper(om);
			template.setValueSerializer(jackson2JsonRedisSerializer);
			template.setKeySerializer(stringRedisSerializer());
			template.afterPropertiesSet();
			return template;
		}
}
