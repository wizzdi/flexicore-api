package com.flexicore.request;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.licensing.LicensingProduct;

/**
 * Created by Asaf on 17/10/2016.
 */
public class LicensingFeatureCreate extends LicensingEntityCreate {

    @JsonIgnore
    private LicensingProduct licensingProduct;

    @JsonIgnore
    public LicensingProduct getLicensingProduct() {
        return licensingProduct;
    }

    public <T extends LicensingFeatureCreate> T setLicensingProduct(LicensingProduct licensingProduct) {
        this.licensingProduct = licensingProduct;
        return (T) this;
    }
}
