/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.model.licensing;

import com.flexicore.model.Baseclass;
import com.flexicore.security.SecurityContext;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.OffsetDateTime;

@SuppressWarnings("serial")


@Entity

public class LicenseRequestToEntity extends Baseclass {


	public LicenseRequestToEntity() {
	}

	public LicenseRequestToEntity(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	@Column(columnDefinition = "timestamp with time zone")
	private OffsetDateTime granted;
	@Column(columnDefinition = "timestamp with time zone")
	private OffsetDateTime expiration;

	private boolean perpetual;
	private boolean demo;

	@ManyToOne(targetEntity = LicenseRequest.class)
	private LicenseRequest licenseRequest;

	@ManyToOne(targetEntity = LicensingEntity.class)
	private LicensingEntity licensingEntity;

	public OffsetDateTime getGranted() {
		return granted;
	}

	public <T extends LicenseRequestToEntity> T setGranted(OffsetDateTime granted) {
		this.granted = granted;
		return (T) this;
	}

	public OffsetDateTime getExpiration() {
		return expiration;
	}

	public <T extends LicenseRequestToEntity> T setExpiration(OffsetDateTime expiration) {
		this.expiration = expiration;
		return (T) this;
	}

	public boolean isPerpetual() {
		return perpetual;
	}

	public <T extends LicenseRequestToEntity> T setPerpetual(boolean perpetual) {
		this.perpetual = perpetual;
		return (T) this;
	}

	public boolean isDemo() {
		return demo;
	}

	public <T extends LicenseRequestToEntity> T setDemo(boolean demo) {
		this.demo = demo;
		return (T) this;
	}

	@ManyToOne(targetEntity = LicenseRequest.class)
	public LicenseRequest getLicenseRequest() {
		return licenseRequest;
	}

	public <T extends LicenseRequestToEntity> T setLicenseRequest(LicenseRequest licenseRequest) {
		this.licenseRequest = licenseRequest;
		return (T) this;
	}

	@ManyToOne(targetEntity = LicensingEntity.class)
	public LicensingEntity getLicensingEntity() {
		return licensingEntity;
	}

	public <T extends LicenseRequestToEntity> T setLicensingEntity(LicensingEntity licensingEntity) {
		this.licensingEntity = licensingEntity;
		return (T) this;
	}
}
