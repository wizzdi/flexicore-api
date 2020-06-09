/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.model.ui.plugins;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.flexicore.data.jsoncontainers.Views;
import com.flexicore.model.Baseclass;
import com.flexicore.security.SecurityContext;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
@Entity

public class UIInterface extends Baseclass {

	static UIInterface s_Singleton=new UIInterface();
	public  static UIInterface s() {return s_Singleton;}
	static{
		Baseclass.registerSingletone(s_Singleton);
	}

	public UIInterface() {
	}

	public UIInterface(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	@OneToMany(targetEntity = UIPluginToUIInterface.class,mappedBy = "uiInterface",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JsonIgnore
	private List<UIPluginToUIInterface> uiPluginToUIInterfaces= new ArrayList<>();

	@OneToMany(targetEntity = UIPluginToUIInterface.class,mappedBy = "uiInterface",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JsonIgnore

	public List<UIPluginToUIInterface> getUiPluginToUIInterfaces() {
		return uiPluginToUIInterfaces;
	}

	public void setUiPluginToUIInterfaces(List<UIPluginToUIInterface> uiPluginToUIInterfaces) {
		this.uiPluginToUIInterfaces = uiPluginToUIInterfaces;
	}
}
