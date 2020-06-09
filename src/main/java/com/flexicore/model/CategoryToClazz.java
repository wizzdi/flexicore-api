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
@AnnotatedClazz(Category="CategoryToClazz", Name="CategoryToClazz", Description="CategoryToClazz")
@Entity

public class CategoryToClazz extends Baselink {
	private static CategoryToClazz s_Singleton=new CategoryToClazz();
	public  static CategoryToClazz s() {return s_Singleton;}

	@ManyToOne(targetEntity = Category.class)
	//@JoinColumn(name = "leftside", referencedColumnName = "id")

	@Override
	public Category getLeftside() {
		return (Category) super.getLeftside();
	}

	@ManyToOne(targetEntity = Clazz.class)
	//@JoinColumn(name = "rightside", referencedColumnName = "id")

	@Override
	public Clazz getRightside() {
		// TODO Auto-generated method stub
		return (Clazz) super.getRightside();
	}

	public CategoryToClazz() {
		// TODO Auto-generated constructor stub
	}

	public CategoryToClazz(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	public CategoryToClazz(Category left, Clazz right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

}
