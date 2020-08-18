package com.cg.demo.exception;

/******************************************
- File Name        : ProductNotFound.java
- Author           : Capgemini
- Creation Date    : 13-08-2020
- Description      : This Exception class is used for exception handling
 ******************************************/


@SuppressWarnings("serial")
public class ProductNotFound extends RuntimeException{

	public ProductNotFound(String msg) {
		super(msg);
	}
}
