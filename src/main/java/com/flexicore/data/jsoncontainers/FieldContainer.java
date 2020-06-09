package com.flexicore.data.jsoncontainers;

public class FieldContainer {
	private String name;
	private String type;
	private String validation;
	private String propertyGroup;
	private boolean required;
	
	public FieldContainer() {
		super();
	}
	
	public FieldContainer(String name, String type, String validation, String propertyGroup, boolean required) {
		super();
		this.name = name;
		this.type = type;
		this.validation = validation;
		this.propertyGroup=propertyGroup;
		this.required=required;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValidation() {
		return validation;
	}
	public void setValidation(String validation) {
		this.validation = validation;
	}
	public String getPropertyGroup() {
		return propertyGroup;
	}
	public void setPropertyGroup(String propertyGroup) {
		this.propertyGroup = propertyGroup;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}
	
	
	
	

}
