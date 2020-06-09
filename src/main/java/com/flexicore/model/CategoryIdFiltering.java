package com.flexicore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.FieldInfo;
//import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class CategoryIdFiltering {

    @Id
    private String filterId;

    @FieldInfo(displayName = "string",description = "string filter",mandatory = true)
    private String id;
    @ManyToOne(targetEntity = FilteringInformationHolder.class)
    @JsonIgnore
    private FilteringInformationHolder filteringInformationHolder;

    public CategoryIdFiltering() {
    }

    ////@ApiModelProperty("Id of the Baseclass")
    public String getId() {
        return id;
    }


    public CategoryIdFiltering setId(String id) {
        this.id = id;
        return this;
    }

    public CategoryIdFiltering(String id) {
        this.id = id;
    }

    @Id
    public String getFilterId() {
        return filterId;
    }

    public CategoryIdFiltering setFilterId(String filterId) {
        this.filterId = filterId;
        return this;
    }

    @ManyToOne(targetEntity = FilteringInformationHolder.class)
    @JsonIgnore
    public FilteringInformationHolder getFilteringInformationHolder() {
        return filteringInformationHolder;
    }

    public CategoryIdFiltering setFilteringInformationHolder(FilteringInformationHolder filteringInformationHolder) {
        this.filteringInformationHolder = filteringInformationHolder;
        return this;
    }

    public void prepareForSave(FilteringInformationHolder filteringInformationHolder) {
        filterId = Baseclass.getBase64ID();
        this.filteringInformationHolder = filteringInformationHolder;

    }
}
