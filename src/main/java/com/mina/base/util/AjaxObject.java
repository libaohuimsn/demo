package com.mina.base.util;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

/**
 * 返回数据
 */
public class AjaxObject extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public AjaxObject() {
		put("code", 0);
	}
	
	public static AjaxObject error() {
		return error(500, "未知异常，请联系管理员");
	}
	
	public static AjaxObject error(String msg) {
		return error(500, msg);
	}
	
	public static AjaxObject error(int code, String msg) {
		AjaxObject r = new AjaxObject();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static AjaxObject ok(String msg) {
		AjaxObject r = new AjaxObject();
		r.put("msg", msg);
		return r;
	}
	
	public static AjaxObject ok(Map<String, Object> map) {
		AjaxObject r = new AjaxObject();
		r.putAll(map);
		return r;
	}
	
	public static AjaxObject ok() {
		return new AjaxObject();
	}

	public AjaxObject put(String key, Object value) {
		super.put(key, value);
		return this;
	}
	
	public AjaxObject data(Object value) {
		super.put("data", value);
		return this;
	}

	public static AjaxObject apiError(String msg) {
		return error(1, msg);
	}
}