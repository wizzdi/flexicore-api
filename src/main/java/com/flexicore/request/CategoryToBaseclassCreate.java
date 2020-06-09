package com.flexicore.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.model.Category;

public class CategoryToBaseclassCreate extends BaseclassCreate{

    private String categoryId;
    @JsonIgnore
    private Category category;
    private String baseclassId;
    @JsonIgnore
    private Baseclass baseclass;
    private Boolean enabled;

    public String getCategoryId() {
        return categoryId;
    }

    public <T extends CategoryToBaseclassCreate> T setCategoryId(String categoryId) {
        this.categoryId = categoryId;
        return (T) this;
    }

    @JsonIgnore
    public Category getCategory() {
        return category;
    }

    public <T extends CategoryToBaseclassCreate> T setCategory(Category category) {
        this.category = category;
        return (T) this;
    }

    public String getBaseclassId() {
        return baseclassId;
    }

    public <T extends CategoryToBaseclassCreate> T setBaseclassId(String baseclassId) {
        this.baseclassId = baseclassId;
        return (T) this;
    }

    @JsonIgnore
    public Baseclass getBaseclass() {
        return baseclass;
    }

    public <T extends CategoryToBaseclassCreate> T setBaseclass(Baseclass baseclass) {
        this.baseclass = baseclass;
        return (T) this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public <T extends CategoryToBaseclassCreate> T setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return (T) this;
    }
}
