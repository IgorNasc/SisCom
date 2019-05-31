package com.sis.com.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RestOutput<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private List<T> listEntity;
	private List<String> listError;
	private List<String> listWarn;
	private int status;

	public List<String> getListError() {
		return listError;
	}

	public void setListError(List<String> listError) {
		this.listError = listError;
	}

	public List<String> getListWarn() {
		return listWarn;
	}

	public void setListWarn(List<String> listWarn) {
		this.listWarn = listWarn;
	}

	public List<T> getListEntity() {
		return listEntity;
	}

	public void setListEntity(List<T> listEntity) {
		this.listEntity = listEntity;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void addError(String error) {
		if(listError == null) listError = new ArrayList<String>();
		
		listError.add(error);
	}
	
	public void addWarn(String warn) {
		if(listWarn == null) listWarn = new ArrayList<String>();
			
		listWarn.add(warn);
	}
	
}
