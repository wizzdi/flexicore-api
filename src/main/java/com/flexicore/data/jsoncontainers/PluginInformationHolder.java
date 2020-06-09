package com.flexicore.data.jsoncontainers;

import com.flexicore.model.ModuleManifest;

public class PluginInformationHolder {
	private String name;
	private String type;
	private int version;
	private ModuleManifest moduleManifest;

	public PluginInformationHolder(String name, String type, int version, ModuleManifest moduleManifest) {
		this.name = name;
		this.type = type;
		this.version = version;
		this.moduleManifest = moduleManifest;
	}

	public PluginInformationHolder() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}


	public ModuleManifest getModuleManifest() {
		return moduleManifest;
	}

	public void setModuleManifest(ModuleManifest moduleManifest) {
		this.moduleManifest = moduleManifest;
	}
}
