package com.flexicore.request;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.licensing.LicenseRequest;

/**
 * Created by Asaf on 17/10/2016.
 */
public class LicenseRequestUpdate extends LicenseRequestCreate {

    private String id;
    @JsonIgnore
    private LicenseRequest licenseRequest;

    public String getId() {
        return id;
    }

    public <T extends LicenseRequestUpdate> T setId(String id) {
        this.id = id;
        return (T) this;
    }

    @JsonIgnore
    public LicenseRequest getLicenseRequest() {
        return licenseRequest;
    }

    public <T extends LicenseRequestUpdate> T setLicenseRequest(LicenseRequest licenseRequest) {
        this.licenseRequest = licenseRequest;
        return (T) this;
    }
}
