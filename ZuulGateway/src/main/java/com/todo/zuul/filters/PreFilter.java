package com.todo.zuul.filters;

import javax.servlet.http.HttpServletRequest;
import com.netflix.zuul.context.RequestContext;
import com.todo.zuul.redis.RedisRepository;
import com.todo.zuul.security.JwtTokens;
import com.todo.zuul.utility.PreConditions;
import com.netflix.zuul.ZuulFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/*************************************************************************************************************
 *
 * purpose:zuul filter
 * 
 * @author sowjanya467
 * @version 1.0
 * @since 12-08-18
 *
 **************************************************************************************************/
public class PreFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(PreFilter.class);

	@Autowired
	JwtTokens jwtToken;
	@Autowired
	RedisRepository redisRepo;

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.netflix.zuul.ZuulFilter#filterType()
	 **/
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.netflix.zuul.ZuulFilter#filterOrder()
	 **/
	@Override
	public int filterOrder() {
		return 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netflix.zuul.IZuulFilter#shouldFilter()
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.netflix.zuul.IZuulFilter#run()
	 **/
	@Override
	public Object run() {
		// try {
		System.out.println("filter");
		log.info("filter");
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		System.out.println("run method executing");
		if (request.getRequestURI().matches("(.*)/n/(.*)")) {
			log.info("entering to note api");
			String token = request.getHeader("token");
			System.out.println(token);

			PreConditions.checkNotNull(request, "header should not be empty");
			System.out.println(token);
			String userId = jwtToken.parseJwt(token).getSubject();
			log.info("userid  ", userId);
			// String user = redisRepo.getUserId(userId);
			// if (userId.equals(user)) {
			System.out.println(userId);
			ctx.addZuulRequestHeader("userId", userId);
			// }

			/*
			 * } } catch (Exception e) { throw new ToDoException("could not verify token");
			 * }
			 */

		}
		return null;
	}

}
