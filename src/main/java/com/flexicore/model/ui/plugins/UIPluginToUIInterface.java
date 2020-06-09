/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.model.ui.plugins;


import com.flexicore.model.Baselink;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@SuppressWarnings("serial")

@Entity

public class UIPluginToUIInterface extends Baselink {

    @ManyToOne(targetEntity = UIPlugin.class)
    private UIPlugin uiPlugin;
    @ManyToOne(targetEntity = UIInterface.class)
    private UIInterface uiInterface;

    public UIPluginToUIInterface() {
    }

    public UIPluginToUIInterface(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }


    @ManyToOne(targetEntity = UIPlugin.class)

    public UIPlugin getUiPlugin() {
        return uiPlugin;
    }

    public <T extends UIPluginToUIInterface> T setUiPlugin(UIPlugin uiPlugin) {
        this.uiPlugin = uiPlugin;
        return (T) this;
    }

    @ManyToOne(targetEntity = UIInterface.class)
    public UIInterface getUiInterface() {
        return uiInterface;
    }

    public <T extends UIPluginToUIInterface> T setUiInterface(UIInterface uiInterface) {
        this.uiInterface = uiInterface;
        return (T) this;
    }

    @Override
    public UIPlugin getLeftside() {
        return uiPlugin;
    }

    @Override
    public UIInterface getRightside() {
        return uiInterface;
    }
}
