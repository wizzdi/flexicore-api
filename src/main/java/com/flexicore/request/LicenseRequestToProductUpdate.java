package com.flexicore.request;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.licensing.LicenseRequestToProduct;

/**
 * Created by Asaf on 17/10/2016.
 */
public class LicenseRequestToProductUpdate extends LicenseRequestToProductCreate {

    private String id;
    @JsonIgnore
    private LicenseRequestToProduct licenseRequestToProduct;

    public String getId() {
        return id;
    }

    public <T extends LicenseRequestToProductUpdate> T setId(String id) {
        this.id = id;
        return (T) this;
    }

    @JsonIgnore
    public LicenseRequestToProduct getLicenseRequestToProduct() {
        return licenseRequestToProduct;
    }

    public <T extends LicenseRequestToProductUpdate> T setLicenseRequestToProduct(LicenseRequestToProduct licenseRequestToProduct) {
        this.licenseRequestToProduct = licenseRequestToProduct;
        return (T) this;
    }
}
