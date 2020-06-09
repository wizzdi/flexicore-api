/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.model.licensing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.model.FileResource;
import com.flexicore.model.Tenant;
import com.flexicore.security.SecurityContext;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
@Entity

public class LicenseRequest extends Baseclass {
	private static LicenseRequest s_Singleton=new LicenseRequest();
	public  static LicenseRequest s() {return s_Singleton;}

	@Lob
	private String macAddress;
	private String diskSerialNumber;
	@Lob
	private String externalHWSerialNumber;
	private boolean signed;
	@ManyToOne(targetEntity = FileResource.class)
	private FileResource license;


	@OneToOne(targetEntity = FileResource.class)
	private FileResource requestFile;

	@OneToMany(targetEntity = LicenseRequestToEntity.class,mappedBy="licenseRequest", fetch= FetchType.LAZY)
	@JsonIgnore
	private List<LicenseRequestToEntity> requestToEntity =new ArrayList<>();


	@ManyToOne(targetEntity = Tenant.class)
	private Tenant licensedTenant;


	public LicenseRequest() {
		// TODO Auto-generated constructor stub
	}

	public LicenseRequest(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	@Lob
	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getDiskSerialNumber() {
		return diskSerialNumber;
	}

	public void setDiskSerialNumber(String diskSerialNumber) {
		this.diskSerialNumber = diskSerialNumber;
	}

	@Lob
	public String getExternalHWSerialNumber() {
		return externalHWSerialNumber;
	}

	public void setExternalHWSerialNumber(String externalHWSerialNumber) {
		this.externalHWSerialNumber = externalHWSerialNumber;
	}

	public boolean isSigned() {
		return signed;
	}

	public void setSigned(boolean signed) {
		this.signed = signed;
	}

	@ManyToOne(targetEntity = FileResource.class)
	public FileResource getLicense() {
		return license;
	}

	public void setLicense(FileResource license) {
		this.license = license;
	}

	@OneToMany(targetEntity = LicenseRequestToEntity.class,mappedBy="licenseRequest", fetch= FetchType.LAZY)
	@JsonIgnore
	public List<LicenseRequestToEntity> getRequestToEntity() {
		return requestToEntity;
	}

	public <T extends LicenseRequest> T setRequestToEntity(List<LicenseRequestToEntity> requestToEntity) {
		this.requestToEntity = requestToEntity;
		return (T) this;
	}

	@ManyToOne(targetEntity = Tenant.class)
	public Tenant getLicensedTenant() {
		return licensedTenant;
	}

	public void setLicensedTenant(Tenant licensedTenant) {
		this.licensedTenant = licensedTenant;
	}

	@OneToOne(targetEntity = FileResource.class)
	public FileResource getRequestFile() {
		return requestFile;
	}

	public void setRequestFile(FileResource requestFile) {
		this.requestFile = requestFile;
	}
}
