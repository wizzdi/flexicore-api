/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.model;

import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;

@Entity
public class SecurityWildcard extends Baseclass {
	private static SecurityWildcard s_Singleton=new SecurityWildcard();
	public  static SecurityWildcard s() {return s_Singleton;}

	public SecurityWildcard() {
	}

	public SecurityWildcard(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}
}
