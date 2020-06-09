/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.model.licensing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@Entity

public class LicensingProduct extends LicensingEntity {
	private static LicensingProduct s_Singleton=new LicensingProduct();
	public  static LicensingProduct s() {return s_Singleton;}


	@OneToMany(targetEntity = LicensingFeature.class,mappedBy = "product")
	@JsonIgnore
	private List<LicensingFeature> licensingFeatures= new ArrayList<>();

	public LicensingProduct() {
		// TODO Auto-generated constructor stub
	}

	public LicensingProduct(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	@OneToMany(targetEntity = LicensingFeature.class,mappedBy = "product")
	@JsonIgnore
	public List<LicensingFeature> getLicensingFeatures() {
		return licensingFeatures;
	}

	public void setLicensingFeatures(List<LicensingFeature> licensingFeatures) {
		this.licensingFeatures = licensingFeatures;
	}
}
