package com.flexicore.request;

import com.flexicore.model.FilteringInformationHolder;

import javax.persistence.Entity;
import java.util.Set;

@Entity
public class CategoryFilter extends FilteringInformationHolder {

    private Set<String> names;

    public Set<String> getNames() {
        return names;
    }

    public <T extends CategoryFilter> T setNames(Set<String> names) {
        this.names = names;
        return (T) this;
    }
}
