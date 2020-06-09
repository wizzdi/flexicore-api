/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


import com.flexicore.annotations.AnnotatedClazz;
import com.flexicore.security.SecurityContext;

@SuppressWarnings("serial")
@AnnotatedClazz(Category="CategoryToBaseClass", Name="CategoryToBaseClass", Description="CategoryToBaseClass")
@Entity

public class CategoryToBaseClass extends Baselink {
	private static CategoryToBaseClass s_Singleton=new CategoryToBaseClass();
	public  static CategoryToBaseClass s() {return s_Singleton;}


	@ManyToOne(targetEntity = Category.class)
	//@JoinColumn(name = "leftside", referencedColumnName = "id")

	@Override
	public Category getLeftside() {
		return (Category) super.getLeftside();
	}



	@ManyToOne(targetEntity = Baseclass.class)
	//@JoinColumn(name = "rightside", referencedColumnName = "id")

	@Override
	public Baseclass getRightside() {
		return super.getRightside();
	}

	public CategoryToBaseClass() {
		// TODO Auto-generated constructor stub
	}

	public CategoryToBaseClass(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	public CategoryToBaseClass(Category left, Baseclass right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}



}
