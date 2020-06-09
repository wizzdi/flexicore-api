package com.flexicore.data.jsoncontainers;

import java.util.List;

public class BaseclassUpdateContainer {
	private List<FieldSetContainer> fields;
	
	public BaseclassUpdateContainer() {
		// TODO Auto-generated constructor stub
	}
	
	public BaseclassUpdateContainer( List<FieldSetContainer> fields) {
		super();
		
		this.fields = fields;
	}

	

	public List<FieldSetContainer> getFields() {
		return fields;
	}

	public void setFields(List<FieldSetContainer> fields) {
		this.fields = fields;
	}

	
	
	
	

}
