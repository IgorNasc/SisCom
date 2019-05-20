package com.sis.com.controller;

import java.util.List;

public class RestOutput<T> {
	private List<T> listEntity;

	public List<T> getListEntity() {
		return listEntity;
	}

	public void setListEntity(List<T> listEntity) {
		this.listEntity = listEntity;
	}
}
