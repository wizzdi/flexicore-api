package com.flexicore.data.jsoncontainers;

import com.flexicore.model.ui.plugins.UIPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Asaf on 13/07/2017.
 */
public class UIPluginContainer extends BasicContainer {

    private List<BasicContainer> interfaces= new ArrayList<>();
    private List<BasicContainer> fileResources= new ArrayList<>();

    public UIPluginContainer(UIPlugin base) {
        super(base);
        interfaces.addAll(base.getUiPluginToUIInterfaces().parallelStream().map(f->new BasicContainer(f.getRightside())).collect(Collectors.toList()));
        fileResources.addAll(base.getUiPluginToFileResources().parallelStream().map(f->new BasicContainer(f.getRightside())).collect(Collectors.toList()));

    }

    public UIPluginContainer() {
    }

    public List<BasicContainer> getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(List<BasicContainer> interfaces) {
        this.interfaces = interfaces;
    }

    public List<BasicContainer> getFileResources() {
        return fileResources;
    }

    public void setFileResources(List<BasicContainer> fileResources) {
        this.fileResources = fileResources;
    }
}
