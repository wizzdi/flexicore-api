package com.flexicore.request;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.licensing.LicensingFeature;

/**
 * Created by Asaf on 17/10/2016.
 */
public class LicensingFeatureUpdate extends LicensingFeatureCreate {

    private String id;
    @JsonIgnore
    private LicensingFeature licensingFeature;

    public String getId() {
        return id;
    }

    public <T extends LicensingFeatureUpdate> T setId(String id) {
        this.id = id;
        return (T) this;
    }

    @JsonIgnore
    public LicensingFeature getLicensingFeature() {
        return licensingFeature;
    }

    public <T extends LicensingFeatureUpdate> T setLicensingFeature(LicensingFeature licensingFeature) {
        this.licensingFeature = licensingFeature;
        return (T) this;
    }
}
