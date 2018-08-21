package com.todo.zuul.redis;
/*************************************************************************************************************
*
* purpose:To store data in redis database
* 
* @author sowjanya467
* @version 1.0
* @since 12-08-18
*
**************************************************************************************************/
@SuppressWarnings("hiding")
public interface RedisRepository {
	
	public void setToken(String jwtToken);

	public String getToken(String userId);
	public String setUserId(String userId);

	String getUserId(String userId);




}
