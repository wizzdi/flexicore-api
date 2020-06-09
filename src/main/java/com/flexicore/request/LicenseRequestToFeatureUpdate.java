package com.flexicore.request;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.licensing.LicenseRequestToFeature;

/**
 * Created by Asaf on 17/10/2016.
 */
public class LicenseRequestToFeatureUpdate extends LicenseRequestToFeatureCreate {

    private String id;
    @JsonIgnore
    private LicenseRequestToFeature licenseRequestToFeature;

    public String getId() {
        return id;
    }

    public <T extends LicenseRequestToFeatureUpdate> T setId(String id) {
        this.id = id;
        return (T) this;
    }

    @JsonIgnore
    public LicenseRequestToFeature getLicenseRequestToFeature() {
        return licenseRequestToFeature;
    }

    public <T extends LicenseRequestToFeatureUpdate> T setLicenseRequestToFeature(LicenseRequestToFeature licenseRequestToFeature) {
        this.licenseRequestToFeature = licenseRequestToFeature;
        return (T) this;
    }
}
