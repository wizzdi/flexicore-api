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

public class LicenseRequestToFeature extends LicenseRequestToEntity {
	private static LicenseRequestToFeature s_Singleton=new LicenseRequestToFeature();
	public  static LicenseRequestToFeature s() {return s_Singleton;}

	public LicenseRequestToFeature() {
	}

	public LicenseRequestToFeature(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}


	@Override
	@ManyToOne(targetEntity = LicensingFeature.class)
	public LicensingFeature getLicensingEntity() {
		return (LicensingFeature) super.getLicensingEntity();
	}

	@Override
	public <T extends LicenseRequestToEntity> T setLicensingEntity(LicensingEntity licensingEntity) {
		return super.setLicensingEntity(licensingEntity);
	}
}
