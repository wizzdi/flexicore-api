package com.flexicore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.FieldInfo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//import io.swagger.annotations.ApiModelProperty;


@Entity
public class OperatingIdRef {

    @Id
    private String filterId;

    @FieldInfo(displayName = "string",description = "string filter",mandatory = true)
    private String id;
    @ManyToOne(targetEntity = FilteringInformationHolder.class)
    @JsonIgnore
    private FilteringInformationHolder filteringInformationHolder;

    public OperatingIdRef() {
    }

    ////@ApiModelProperty("Id of the Baseclass")
    public String getId() {
        return id;
    }


    public OperatingIdRef setId(String id) {
        this.id = id;
        return this;
    }

    public OperatingIdRef(String id) {
        this.id = id;
    }

    @Id
    public String getFilterId() {
        return filterId;
    }

    public OperatingIdRef setFilterId(String filterId) {
        this.filterId = filterId;
        return this;
    }

    @ManyToOne(targetEntity = FilteringInformationHolder.class)
    @JsonIgnore
    public FilteringInformationHolder getFilteringInformationHolder() {
        return filteringInformationHolder;
    }

    public OperatingIdRef setFilteringInformationHolder(FilteringInformationHolder filteringInformationHolder) {
        this.filteringInformationHolder = filteringInformationHolder;
        return this;
    }

    public void prepareForSave(FilteringInformationHolder filteringInformationHolder) {
        filterId = Baseclass.getBase64ID();
        this.filteringInformationHolder = filteringInformationHolder;

    }
}
