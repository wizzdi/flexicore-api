/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.model;

import com.flexicore.enums.Restriction;
/**
 * defines the requirements for a requested plug-in.
 * @author Avishay Ben Natan
 *
 */
public class PluginRequirement {
	private String pluginCanonicalName;
	private Integer version;
	private Restriction restriction; 

	public PluginRequirement() {
		// TODO Auto-generated constructor stub
	}

	public String getPluginCanonicalName() {
		return pluginCanonicalName;
	}


	public Integer getVersion() {
		return version;
	}


	public Restriction getRestriction() {
		return restriction;
	}


	public PluginRequirement(String pluginCanonicalName, Integer version, Restriction restriction) {
		super();
		this.pluginCanonicalName = pluginCanonicalName;
		this.version = version;
		this.restriction = restriction;
	}

	public PluginRequirement setPluginCanonicalName(String pluginCanonicalName) {
		this.pluginCanonicalName = pluginCanonicalName;
		return this;
	}

	public PluginRequirement setVersion(Integer version) {
		this.version = version;
		return this;
	}

	public PluginRequirement setRestriction(Restriction restriction) {
		this.restriction = restriction;
		return this;
	}

	@Override
	public String toString() {
		return "PluginRequirment ["
				+ (pluginCanonicalName != null ? "pluginCanonicalName=" + pluginCanonicalName + ", " : "")
				+ (version != null ? "version=" + version + ", " : "")
				+ (restriction != null ? "restriction=" + restriction : "") + "]";
	}
	
	
	
	
	

}
