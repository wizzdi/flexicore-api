/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.model;

import java.io.Serializable;

import javax.persistence.Entity;


import com.flexicore.annotations.AnnotatedClazz;
import com.flexicore.security.SecurityContext;

/**
 * 
 * @author avishayb
 *
 */
@AnnotatedClazz(Category="access control", Name="Operation Category", Description="Clasifies operations")
@Entity



public class OperationCategory extends Baseclass implements Serializable {

	static OperationCategory s_Singleton = new OperationCategory();

	public static OperationCategory s() {
		return s_Singleton;
	}

	private static final long serialVersionUID = 1L;

	public OperationCategory() {
		super();
	}

	public OperationCategory(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

}
