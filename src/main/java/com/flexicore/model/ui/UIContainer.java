/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.model.ui;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.security.SecurityContext;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
@Entity

public class UIContainer extends UIComponent {
	static UIContainer s_Singleton=new UIContainer();
	public  static UIContainer s() {return s_Singleton;}
	static{
		Baseclass.registerSingletone(s_Singleton);
	}

	public UIContainer() {
	}

	public UIContainer(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	@OneToMany(targetEntity = UIComponent.class,mappedBy = "uiContainer")
	@JsonIgnore
	private List<UIComponent> uiComponents= new ArrayList<>();

	@OneToMany(targetEntity = UIComponent.class,mappedBy = "uiContainer")
	@JsonIgnore
	public List<UIComponent> getUiComponents() {
		return uiComponents;
	}

	public void setUiComponents(List<UIComponent> uiComponents) {
		this.uiComponents = uiComponents;
	}


}
