package com.flexicore.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.model.Baselink;
import com.flexicore.model.FilteringInformationHolder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaselinkFilter extends FilteringInformationHolder {

    private Set<String> leftsideIds=new HashSet<>();
    @JsonIgnore
    private List<Baseclass> leftside;
    private Set<String> rightsideIds=new HashSet<>();
    @JsonIgnore
    private List<Baseclass> rightside;
    private String valueId;
    @JsonIgnore
    private Baseclass value;
    private String simpleValue;
    private String linkClassName;
    @JsonIgnore
    private Class<? extends Baselink> linkClass;

    public BaselinkFilter() {
    }

    public BaselinkFilter(FilteringInformationHolder other) {
        super(other);
    }

    public BaselinkFilter(BaselinkFilter other) {
        super(other);
        this.leftsideIds = other.leftsideIds;
        this.leftside = other.leftside;
        this.rightsideIds = other.rightsideIds;
        this.rightside = other.rightside;
        this.valueId = other.valueId;
        this.value = other.value;
        this.simpleValue = other.simpleValue;
        this.linkClassName = other.linkClassName;
        this.linkClass = other.linkClass;
    }

    public Set<String> getLeftsideIds() {
        return leftsideIds;
    }

    public <T extends BaselinkFilter> T setLeftsideIds(Set<String> leftsideIds) {
        this.leftsideIds = leftsideIds;
        return (T) this;
    }

    public List<Baseclass> getLeftside() {
        return leftside;
    }

    public <T extends BaselinkFilter> T setLeftside(List<Baseclass> leftside) {
        this.leftside = leftside;
        return (T) this;
    }

    public Set<String> getRightsideIds() {
        return rightsideIds;
    }

    public <T extends BaselinkFilter> T setRightsideIds(Set<String> rightsideIds) {
        this.rightsideIds = rightsideIds;
        return (T) this;
    }

    public List<Baseclass> getRightside() {
        return rightside;
    }

    public <T extends BaselinkFilter> T setRightside(List<Baseclass> rightside) {
        this.rightside = rightside;
        return (T) this;
    }

    public String getValueId() {
        return valueId;
    }

    public <T extends BaselinkFilter> T setValueId(String valueId) {
        this.valueId = valueId;
        return (T) this;
    }

    public Baseclass getValue() {
        return value;
    }

    public <T extends BaselinkFilter> T setValue(Baseclass value) {
        this.value = value;
        return (T) this;
    }

    public String getSimpleValue() {
        return simpleValue;
    }

    public <T extends BaselinkFilter> T setSimpleValue(String simpleValue) {
        this.simpleValue = simpleValue;
        return (T) this;
    }

    public String getLinkClassName() {
        return linkClassName;
    }

    public <T extends BaselinkFilter> T setLinkClassName(String linkClassName) {
        this.linkClassName = linkClassName;
        return (T) this;
    }

    @JsonIgnore
    public Class<? extends Baselink> getLinkClass() {
        return linkClass;
    }

    public <T extends BaselinkFilter> T setLinkClass(Class<? extends Baselink> linkClass) {
        this.linkClass = linkClass;
        return (T) this;
    }
}
