package com.flexicore.request;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.licensing.LicenseRequestToQuantityFeature;

/**
 * Created by Asaf on 17/10/2016.
 */
public class LicenseRequestToQuantityFeatureUpdate extends LicenseRequestToQuantityFeatureCreate {

    private String id;
    @JsonIgnore
    private LicenseRequestToQuantityFeature licenseRequestToQuantityFeature;

    public String getId() {
        return id;
    }

    public <T extends LicenseRequestToQuantityFeatureUpdate> T setId(String id) {
        this.id = id;
        return (T) this;
    }

    @JsonIgnore
    public LicenseRequestToQuantityFeature getLicenseRequestToQuantityFeature() {
        return licenseRequestToQuantityFeature;
    }

    public <T extends LicenseRequestToQuantityFeatureUpdate> T setLicenseRequestToQuantityFeature(LicenseRequestToQuantityFeature licenseRequestToQuantityFeature) {
        this.licenseRequestToQuantityFeature = licenseRequestToQuantityFeature;
        return (T) this;
    }
}
