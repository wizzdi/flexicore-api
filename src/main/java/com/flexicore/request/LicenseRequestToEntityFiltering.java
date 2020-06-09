package com.flexicore.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.FilteringInformationHolder;
import com.flexicore.model.licensing.LicenseRequest;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LicenseRequestToEntityFiltering extends FilteringInformationHolder {

    private Set<String> licenseRequestIds=new HashSet<>();
    @JsonIgnore
    private List<LicenseRequest> licenseRequests;
    private OffsetDateTime expirationDateAfter;

    public Set<String> getLicenseRequestIds() {
        return licenseRequestIds;
    }

    public <T extends LicenseRequestToEntityFiltering> T setLicenseRequestIds(Set<String> licenseRequestIds) {
        this.licenseRequestIds = licenseRequestIds;
        return (T) this;
    }

    @JsonIgnore
    public List<LicenseRequest> getLicenseRequests() {
        return licenseRequests;
    }

    public <T extends LicenseRequestToEntityFiltering> T setLicenseRequests(List<LicenseRequest> licenseRequests) {
        this.licenseRequests = licenseRequests;
        return (T) this;
    }

    public OffsetDateTime getExpirationDateAfter() {
        return expirationDateAfter;
    }

    public <T extends LicenseRequestToEntityFiltering> T setExpirationDateAfter(OffsetDateTime expirationDateAfter) {
        this.expirationDateAfter = expirationDateAfter;
        return (T) this;
    }
}
