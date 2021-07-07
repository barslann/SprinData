package com.coderman.PureJDBCExample.exception;

public class NoSuchPersonException extends Exception{
	private static String message = "No such person found! Id: ";
	
	public NoSuchPersonException(int id) {
		super(message + id);
	}
}
