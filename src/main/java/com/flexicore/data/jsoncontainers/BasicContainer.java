package com.flexicore.data.jsoncontainers;

import com.flexicore.model.Baseclass;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class BasicContainer implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 180596583247883253L;
	
	public BasicContainer() {
		// TODO Auto-generated constructor stub
	}

	public BasicContainer(Baseclass base) {
		super();
		this.id = base.getId();
		this.name = base.getName();
		this.creationDate=base.getCreationDate();
		this.description=base.getDescription();
		this.updateDate=base.getUpdateDate();
	}

	protected String id;
	protected String name;
	protected OffsetDateTime creationDate;
	protected OffsetDateTime updateDate;
	protected String description;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OffsetDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(OffsetDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
	}
}
