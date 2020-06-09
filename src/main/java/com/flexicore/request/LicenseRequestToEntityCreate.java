package com.flexicore.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.licensing.LicenseRequest;

import java.time.ZonedDateTime;

public class LicenseRequestToEntityCreate extends BaseclassCreate{
    @JsonIgnore
    private ZonedDateTime granted;
    private ZonedDateTime expiration;
    private Boolean perpetual;
    private Boolean demo;
    private String licenseRequestId;
    @JsonIgnore
    private LicenseRequest licenseRequest;

    @JsonIgnore
    public ZonedDateTime getGranted() {
        return granted;
    }

    public <T extends LicenseRequestToEntityCreate> T setGranted(ZonedDateTime granted) {
        this.granted = granted;
        return (T) this;
    }

    public ZonedDateTime getExpiration() {
        return expiration;
    }

    public <T extends LicenseRequestToEntityCreate> T setExpiration(ZonedDateTime expiration) {
        this.expiration = expiration;
        return (T) this;
    }

    public Boolean getPerpetual() {
        return perpetual;
    }

    public <T extends LicenseRequestToEntityCreate> T setPerpetual(Boolean perpetual) {
        this.perpetual = perpetual;
        return (T) this;
    }

    public Boolean getDemo() {
        return demo;
    }

    public <T extends LicenseRequestToEntityCreate> T setDemo(Boolean demo) {
        this.demo = demo;
        return (T) this;
    }

    public String getLicenseRequestId() {
        return licenseRequestId;
    }

    public <T extends LicenseRequestToEntityCreate> T setLicenseRequestId(String licenseRequestId) {
        this.licenseRequestId = licenseRequestId;
        return (T) this;
    }

    @JsonIgnore
    public LicenseRequest getLicenseRequest() {
        return licenseRequest;
    }

    public <T extends LicenseRequestToEntityCreate> T setLicenseRequest(LicenseRequest licenseRequest) {
        this.licenseRequest = licenseRequest;
        return (T) this;
    }
}
