package com.flexicore.request;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.licensing.LicensingFeature;

/**
 * Created by Asaf on 17/10/2016.
 */
public class LicenseRequestToFeatureCreate extends LicenseRequestToEntityCreate {

    private String licensingFeatureId;
    @JsonIgnore
    private LicensingFeature licensingFeature;

    public String getLicensingFeatureId() {
        return licensingFeatureId;
    }

    public <T extends LicenseRequestToFeatureCreate> T setLicensingFeatureId(String licensingFeatureId) {
        this.licensingFeatureId = licensingFeatureId;
        return (T) this;
    }

    @JsonIgnore
    public LicensingFeature getLicensingFeature() {
        return licensingFeature;
    }

    public <T extends LicenseRequestToFeatureCreate> T setLicensingFeature(LicensingFeature licensingFeature) {
        this.licensingFeature = licensingFeature;
        return (T) this;
    }
}
