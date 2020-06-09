/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.annotations.AnnotatedClazz;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
@AnnotatedClazz(Category="Category", Name="Category", Description="Category")
@Entity

//@ApiModel(value="Category",discriminator="dtype",description="Used to classify all types extending Baseclass")
public class Category extends Baseclass {
	private static Category s_Singleton=new Category();
	public  static Category s() {return s_Singleton;}
	@OneToMany(targetEntity = CategoryToBaseClass.class,mappedBy="leftside")
	@JsonIgnore
	////@ApiModelProperty(name="List of instances",position=1, value="list of instances",notes="List of CategoryToBaseclass instances, an Instance can be associated with multiple Categories")
	private List<CategoryToBaseClass> categoryToBaseclass =new ArrayList<>();

	@JsonIgnore
	@OneToMany(targetEntity = CategoryToClazz.class,mappedBy="leftside")
	private List<CategoryToClazz> clazzes=new ArrayList<>();
	

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	@JsonIgnore
	public List<CategoryToBaseClass> getCategoryToBaseclass() {
		return categoryToBaseclass;
	}


	public void setCategoryToBaseclass(List<CategoryToBaseClass> baseclasses) {
		this.categoryToBaseclass = baseclasses;
	}


	@JsonIgnore
	public List<CategoryToClazz> getClazzes() {
		return clazzes;
	}


	public void setClazzes(List<CategoryToClazz> clazzes) {
		this.clazzes = clazzes;
	}
	
	

}
