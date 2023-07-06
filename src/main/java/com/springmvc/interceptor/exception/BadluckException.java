package com.springmvc.interceptor.exception;

public class BadluckException extends Exception {

	public static double luckScore=0;
	public BadluckException() {

	}

	public BadluckException(double luck) {
		
		luckScore=luck;
	}
}
