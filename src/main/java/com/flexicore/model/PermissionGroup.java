/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@Entity
public class PermissionGroup extends Baseclass {
	static PermissionGroup s_Singleton=new PermissionGroup();
	public  static PermissionGroup s() {return s_Singleton;}

	public PermissionGroup() {
	}

	public PermissionGroup(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	@OneToMany(targetEntity = PermissionGroupToBaseclass.class,mappedBy="leftside",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<PermissionGroupToBaseclass> links =new ArrayList<>();

	@OneToMany(targetEntity = PermissionGroupToBaseclass.class,mappedBy="leftside",fetch=FetchType.LAZY)
	@JsonIgnore
	public List<PermissionGroupToBaseclass> getLinks() {
		return links;
	}

	public PermissionGroup setLinks(List<PermissionGroupToBaseclass> permissionGroupToBaseclasses) {
		this.links = permissionGroupToBaseclasses;
		return this;
	}
}
