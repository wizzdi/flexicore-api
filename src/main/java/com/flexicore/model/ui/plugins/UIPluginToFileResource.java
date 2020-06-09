/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.model.ui.plugins;


import com.flexicore.model.Baseclass;
import com.flexicore.model.Baselink;
import com.flexicore.model.FileResource;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@SuppressWarnings("serial")

@Entity

public class UIPluginToFileResource extends Baselink {

    @ManyToOne(targetEntity = UIPlugin.class)
    private UIPlugin uiPlugin;
    @ManyToOne(targetEntity = FileResource.class)
    private FileResource fileResource;

    public UIPluginToFileResource() {
    }

    public UIPluginToFileResource(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }


    @ManyToOne(targetEntity = UIPlugin.class)

    public UIPlugin getUiPlugin() {
        return uiPlugin;
    }

    public <T extends UIPluginToFileResource> T setUiPlugin(UIPlugin uiPlugin) {
        this.uiPlugin = uiPlugin;
        return (T) this;
    }

    @ManyToOne(targetEntity = FileResource.class)

    public FileResource getFileResource() {
        return fileResource;
    }

    public <T extends UIPluginToFileResource> T setFileResource(FileResource fileResource) {
        this.fileResource = fileResource;
        return (T) this;
    }

    @Override
    public UIPlugin getLeftside() {
        return uiPlugin;
    }

    @Override
    public FileResource getRightside() {
        return fileResource;
    }
}
