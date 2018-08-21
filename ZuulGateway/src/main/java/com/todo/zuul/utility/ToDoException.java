package com.todo.zuul.utility;

/*************************************************************************************************************
 *
 * purpose:ExceptionHandling
 * 
 * @author sowjanya467
 * @version 1.0
 * @since 10-07-18
 *
 **************************************************************************************************/

public class ToDoException extends RuntimeException 
{

	private static final long serialVersionUID = 1L;

	public ToDoException(String message) {

		super(message);
	}

}
