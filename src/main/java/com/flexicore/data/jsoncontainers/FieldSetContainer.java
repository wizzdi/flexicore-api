package com.flexicore.data.jsoncontainers;

import java.io.Serializable;

public class FieldSetContainer<T extends Serializable> {
	private String name;
	private Class<T> clazz;
	private T value;
	private boolean byId;
	
	public FieldSetContainer() {
		// TODO Auto-generated constructor stub
	}
	
	public FieldSetContainer(String name, Class<T> clazz, T value) {
		super();
		this.name = name;
		this.value = value;
		this.clazz=clazz;
	}

	public FieldSetContainer(String name, Class<T> clazz, T value, boolean byId) {
	this(name,clazz,value);
		this.byId = byId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Class<T> getClazz() {
		return clazz;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	public boolean isById() {
		return byId;
	}

	public void setById(boolean byId) {
		this.byId = byId;
	}
}
