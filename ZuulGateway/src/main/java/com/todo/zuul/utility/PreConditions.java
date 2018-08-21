package com.todo.zuul.utility;

import org.springframework.lang.Nullable;

/*************************************************************************************************************
*
* purpose:PreConditions
* 
* @author sowjanya467
* @version 1.0
* @since 10-07-18
*
**************************************************************************************************/
public class PreConditions {



	    public static boolean isPresentInDb(boolean reference,@Nullable Object errorMessage) {
	        if (!reference) {
	            throw new ToDoException(String.valueOf(errorMessage));
	        }
	        return reference;
	    }

	    
	    public static  String checkNotNull(  Object  reference,@Nullable Object errorMessage) {
	        if (reference==null) {
	            throw new ToDoException(String.valueOf(errorMessage));
	        }
	        return reference.toString();
	    }
	}

