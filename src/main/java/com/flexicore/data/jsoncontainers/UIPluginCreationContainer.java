package com.flexicore.data.jsoncontainers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.FileResource;
import com.flexicore.model.ui.plugins.UIInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asaf on 12/07/2017.
 */
public class UIPluginCreationContainer extends BasicContainer {

    private List<String> interfacesIds= new ArrayList<>();
    @JsonIgnore
    private List<UIInterface> uiInterfaces= new ArrayList<>();
    private List<String> fileResourceIds= new ArrayList<>();
    @JsonIgnore
    private List<FileResource> fileResources= new ArrayList<>();


    public UIPluginCreationContainer() {
    }

    public List<String> getInterfacesIds() {
        return interfacesIds;
    }

    public void setInterfacesIds(List<String> interfacesIds) {
        this.interfacesIds = interfacesIds;
    }


    @JsonIgnore
    public List<UIInterface> getUiInterfaces() {
        return uiInterfaces;
    }

    public void setUiInterfaces(List<UIInterface> uiInterfaces) {
        this.uiInterfaces = uiInterfaces;
    }

    public List<String> getFileResourceIds() {
        return fileResourceIds;
    }

    public void setFileResourceIds(List<String> fileResourceIds) {
        this.fileResourceIds = fileResourceIds;
    }

    @JsonIgnore
    public List<FileResource> getFileResources() {
        return fileResources;
    }

    public void setFileResources(List<FileResource> fileResources) {
        this.fileResources = fileResources;
    }
}
