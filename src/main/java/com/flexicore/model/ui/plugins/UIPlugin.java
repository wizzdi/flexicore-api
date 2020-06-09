/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.model.ui.plugins;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.model.Presenter;
import com.flexicore.security.SecurityContext;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
@Entity

public class UIPlugin extends Presenter {

	public UIPlugin() {
	}

	public UIPlugin(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	@OneToMany(targetEntity = UIPluginToFileResource.class,mappedBy = "uiPlugin",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JsonIgnore
	private List<UIPluginToFileResource> uiPluginToFileResources= new ArrayList<>();



	@OneToMany(targetEntity = UIPluginToUIInterface.class,mappedBy = "uiPlugin",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JsonIgnore
	private List<UIPluginToUIInterface> uiPluginToUIInterfaces= new ArrayList<>();



	@JsonIgnore
	@OneToMany(targetEntity = UIPluginToUIInterface.class,mappedBy = "uiPlugin",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	public List<UIPluginToUIInterface> getUiPluginToUIInterfaces() {
		return uiPluginToUIInterfaces;
	}

	public void setUiPluginToUIInterfaces(List<UIPluginToUIInterface> uiPluginToUIInterfaces) {
		this.uiPluginToUIInterfaces = uiPluginToUIInterfaces;
	}

	@JsonIgnore
	@OneToMany(targetEntity = UIPluginToFileResource.class,mappedBy = "uiPlugin",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	public List<UIPluginToFileResource> getUiPluginToFileResources() {
		return uiPluginToFileResources;
	}

	public void setUiPluginToFileResources(List<UIPluginToFileResource> uiPluginToFileResources) {
		this.uiPluginToFileResources = uiPluginToFileResources;
	}
}
