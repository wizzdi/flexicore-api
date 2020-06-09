/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.model.licensing;

import com.flexicore.security.SecurityContext;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity

public class LicensingFeature extends LicensingEntity {
	private static LicensingFeature s_Singleton=new LicensingFeature();
	public  static LicensingFeature s() {return s_Singleton;}




	@ManyToOne(targetEntity = LicensingProduct.class)
	private LicensingProduct product;

	public LicensingFeature(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	public LicensingFeature() {
		// TODO Auto-generated constructor stub
	}



	@ManyToOne(targetEntity = LicensingProduct.class)
	public LicensingProduct getProduct() {
		return product;
	}

	public void setProduct(LicensingProduct product) {
		this.product = product;
	}


}
