/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.flexicore.annotations.AnnotatedClazz;
import com.flexicore.annotations.FieldForView;
import com.flexicore.annotations.FullTextSearch;
import com.flexicore.data.jsoncontainers.Views;
import com.flexicore.security.SecurityContext;

/**
 * Entity implementation class for Entity: Role
 * Note that the default roles are defines through annotation and all operations are linked to these roles while operations are created.
 *
 */
//@JsonIgnoreProperties({"users","operations"})
@SuppressWarnings("serial")
@AnnotatedClazz(Category="access control", Name="Role", Description="Groups users by Operations they are allowed to perform")
//@Cache(type=CacheType.FULL)
@Entity

@FullTextSearch(supported = true)

public class Role extends SecurityEntity implements Serializable {
	static Role s_Singleton=new Role();
	public  static Role s() {return s_Singleton;}
	@FieldForView
	@JsonIgnore
	@OneToMany(mappedBy="leftside", fetch=FetchType.LAZY,targetEntity=RoleToUser.class) //users are subscribed to very few roles.
	private List<RoleToUser> roleToUser =new ArrayList<>();
	
	

	
	@FieldForView
	@OneToMany(targetEntity = RoleToBaseclass.class,mappedBy="leftside", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<RoleToBaseclass> roleToBaseclass =new ArrayList<>();
	
	public Role() {
		super();
	}

	public Role(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	@FieldForView
	@JsonIgnore
	@OneToMany(mappedBy="leftside", fetch=FetchType.LAZY,targetEntity=RoleToUser.class) //users are subscribed to very few roles.
	public List<RoleToUser> getRoleToUser() {
		return roleToUser;
	}

	public void setRoleToUser(List<RoleToUser> users) {
		this.roleToUser = users;
	}


	@FieldForView
	@OneToMany(targetEntity = RoleToBaseclass.class,mappedBy="leftside", fetch=FetchType.LAZY)
	@JsonIgnore
	public List<RoleToBaseclass> getRoleToBaseclass() {
		return roleToBaseclass;
	}

	public void setRoleToBaseclass(List<RoleToBaseclass> baseclasses) {
		this.roleToBaseclass = baseclasses;
	}

	@Override
	public void setParameter1(Object parameter1) {
		if(parameter1 instanceof Tenant){
			setTenant((Tenant) parameter1);

		}
	}
}
