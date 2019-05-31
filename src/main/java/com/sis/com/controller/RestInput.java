package com.sis.com.controller;

import java.io.Serializable;

public class RestInput<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private T entity;

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}
	
	
}
