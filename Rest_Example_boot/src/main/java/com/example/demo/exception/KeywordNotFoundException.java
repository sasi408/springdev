package com.example.demo.exception;

public class KeywordNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public KeywordNotFoundException(String key) {
		super(key + " not available");
	}
}
