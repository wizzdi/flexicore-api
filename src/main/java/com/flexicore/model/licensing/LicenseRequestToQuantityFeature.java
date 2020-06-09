/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.model.licensing;

import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@SuppressWarnings("serial")

@Entity

public class LicenseRequestToQuantityFeature extends LicenseRequestToFeature {
	private static LicenseRequestToQuantityFeature s_Singleton=new LicenseRequestToQuantityFeature();
	public  static LicenseRequestToQuantityFeature s() {return s_Singleton;}

	private int quantityLimit;

	public LicenseRequestToQuantityFeature() {
	}

	public LicenseRequestToQuantityFeature(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	public int getQuantityLimit() {
		return quantityLimit;
	}

	public <T extends LicenseRequestToQuantityFeature> T setQuantityLimit(int quantityLimit) {
		this.quantityLimit = quantityLimit;
		return (T) this;
	}
}
