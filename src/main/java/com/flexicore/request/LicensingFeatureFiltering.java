package com.flexicore.request;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.licensing.LicensingProduct;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Asaf on 17/10/2016.
 */
public class LicensingFeatureFiltering extends LicensingEntityFiltering {

    @JsonIgnore
    private List<LicensingProduct> licensingProducts;
    private Set<String> licensingProductsIds=new HashSet<>();

    @JsonIgnore
    public List<LicensingProduct> getLicensingProducts() {
        return licensingProducts;
    }

    public <T extends LicensingFeatureFiltering> T setLicensingProducts(List<LicensingProduct> licensingProducts) {
        this.licensingProducts = licensingProducts;
        return (T) this;
    }

    public Set<String> getLicensingProductsIds() {
        return licensingProductsIds;
    }

    public <T extends LicensingFeatureFiltering> T setLicensingProductsIds(Set<String> licensingProductsIds) {
        this.licensingProductsIds = licensingProductsIds;
        return (T) this;
    }
}
