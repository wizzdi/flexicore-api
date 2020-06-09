package com.flexicore.data.jsoncontainers;

import java.util.List;

/**Helper class for Generic creation of instances by a client.
 * 
 * @author Asaf Ben Natan
 *
 */
public class BaseclassCreationContainer {

	private String clazzName;
	private String nameOfInstance;
	private List<FieldSetContainer<?>> fields;
	
	public BaseclassCreationContainer() {
		// TODO Auto-generated constructor stub
	}
	
	public BaseclassCreationContainer(String clazzName, List<FieldSetContainer<?>> fields, String nameOfInstance) {
		super();
		this.clazzName = clazzName;
		this.fields = fields;
		this.nameOfInstance=nameOfInstance;
	}

	public String getClazzName() {
		return clazzName;
	}

	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}

	public List<FieldSetContainer<?>> getFields() {
		return fields;
	}

	public void setFields(List<FieldSetContainer<?>> fields) {
		this.fields = fields;
	}

	public String getNameOfInstance() {
		return nameOfInstance;
	}

	public void setNameOfInstance(String nameOfInstance) {
		this.nameOfInstance = nameOfInstance;
	}
	
	
	

}
