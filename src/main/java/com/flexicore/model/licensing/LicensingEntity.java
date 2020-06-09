/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.model.licensing;

import com.flexicore.model.Baseclass;
import com.flexicore.security.SecurityContext;

import javax.persistence.*;


@SuppressWarnings("serial")

@Entity
public class  LicensingEntity extends Baseclass {


	private String canonicalName;

	public LicensingEntity(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	public LicensingEntity() {
		// TODO Auto-generated constructor stub
	}


	public String getCanonicalName() {
		return canonicalName;
	}

	public void setCanonicalName(String canonicalName) {
		this.canonicalName = canonicalName;
	}



}
