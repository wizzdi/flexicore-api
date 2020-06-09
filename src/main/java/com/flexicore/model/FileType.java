/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.flexicore.annotations.AnnotatedClazz;
import com.flexicore.data.jsoncontainers.Views;
import com.flexicore.security.SecurityContext;

@SuppressWarnings("serial")
@AnnotatedClazz(Category = "fileResource", Name = "FileType", Description = "representing file resource file type")
@Entity

public class FileType extends Baseclass {
	private static FileType s_Singleton = new FileType();
	public static FileType s() {return s_Singleton;}
	
	@JsonIgnore
	@OneToMany(targetEntity=FileResource.class,mappedBy="type")
	private List<FileResource> fileResources= new ArrayList<>();
	
	
	

	
	public FileType() {
		// TODO Auto-generated constructor stub
	}

	public FileType(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	public FileType(String name) {
		this.name =name.toLowerCase();
		this.id=name.toLowerCase();
	}
	
	/**
	 * Necessary to set id as name
	 */
	@Override
	@Deprecated
	public void Init() {
		super.Init();
		this.id= name;
	}
	
	@Override
	public void setName(String name) {
		super.setName(name.toLowerCase());
	}
	
	@Override
	public void setId(String id) {
		super.setId(id.toLowerCase());
	}
	
	
	@Override
	public boolean equals(Object another) {
		if(another instanceof FileType){
			FileType t= (FileType) another;
			return id.equalsIgnoreCase(t.getId());
		}
		return false;
	}
	
	public boolean idEquals(String otherId) {
			return id.equalsIgnoreCase(otherId);
		
	}
	
	@OneToMany(targetEntity=FileResource.class,mappedBy="type")
	@JsonIgnore
	public List<FileResource> getFileResources() {
		return fileResources;
	}

	public void setFileResources(List<FileResource> fileResources) {
		this.fileResources = fileResources;
	}
	
	
	
	
	

}
