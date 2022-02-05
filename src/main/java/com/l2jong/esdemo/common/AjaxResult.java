package com.l2jong.esdemo.common;

import lombok.Data;

@Data
public class AjaxResult<T> {

	private boolean result;
	private int code;
	private String message;
	private T data;

	public AjaxResult(boolean result, int code, String message) {
		this.result = result;
		this.code = code;
		this.message = message;
	}
}
