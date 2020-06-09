package com.flexicore.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.CategoryToBaseClass;

public class CategoryToBaseclassUpdate extends CategoryToBaseclassCreate{

    private String id;
    @JsonIgnore
    private CategoryToBaseClass categoryToBaseClass;

    public String getId() {
        return id;
    }

    public <T extends CategoryToBaseclassUpdate> T setId(String id) {
        this.id = id;
        return (T) this;
    }

    @JsonIgnore
    public CategoryToBaseClass getCategoryToBaseClass() {
        return categoryToBaseClass;
    }

    public <T extends CategoryToBaseclassUpdate> T setCategoryToBaseClass(CategoryToBaseClass categoryToBaseClass) {
        this.categoryToBaseClass = categoryToBaseClass;
        return (T) this;
    }
}
