/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.model.ui;


import com.flexicore.model.Baseclass;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;




@SuppressWarnings("serial")
@Entity

public class UIComponent extends Baseclass {

	static UIComponent s_Singleton=new UIComponent();
	public  static UIComponent s() {return s_Singleton;}
	static{
		Baseclass.registerSingletone(s_Singleton);
	}

	public UIComponent() {
	}

	public UIComponent(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	private String externalId;


	@ManyToOne(targetEntity = UIContainer.class)
	private UIContainer uiContainer;

	@ManyToOne(targetEntity = UIContainer.class)
	public UIContainer getUiContainer() {
		return uiContainer;
	}

	public void setUiContainer(UIContainer uiContainer) {
		this.uiContainer = uiContainer;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
}
