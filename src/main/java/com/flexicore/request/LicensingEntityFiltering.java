package com.flexicore.request;


import com.flexicore.model.FilteringInformationHolder;

import java.util.Set;

/**
 * Created by Asaf on 17/10/2016.
 */
public class LicensingEntityFiltering extends FilteringInformationHolder {

    private Set<String> canonicalNames;

    public Set<String> getCanonicalNames() {
        return canonicalNames;
    }

    public <T extends LicensingEntityFiltering> T setCanonicalNames(Set<String> canonicalNames) {
        this.canonicalNames = canonicalNames;
        return (T) this;
    }
}
