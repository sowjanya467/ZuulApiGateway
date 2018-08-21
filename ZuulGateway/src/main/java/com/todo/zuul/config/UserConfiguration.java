package com.todo.zuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
/*************************************************************************************************************
*
* purpose:configurations of redis
* 
* @author sowjanya467
* @version 1.0
* @since 12-08-18
*
**************************************************************************************************/

public class UserConfiguration {

	@SuppressWarnings("deprecation")
	@Bean
	public JedisConnectionFactory connectionFactory() {
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
		connectionFactory.setHostName("localhost");
		connectionFactory.setPort(6379);
		return connectionFactory;
	}

	@Bean
	public RedisTemplate redisTemplate() {
		RedisTemplate redisTemplate = new RedisTemplate();
		redisTemplate.setConnectionFactory(connectionFactory());
		return redisTemplate;
	}
}
