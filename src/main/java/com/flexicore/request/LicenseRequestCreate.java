package com.flexicore.request;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.FileResource;
import com.flexicore.model.Tenant;
import com.flexicore.model.licensing.LicenseRequest;

/**
 * Created by Asaf on 17/10/2016.
 */
public class LicenseRequestCreate extends BaseclassCreate {
    private String macAddress;
    private String diskSerialNumber;
    private String externalHWSerialNumber;
    private String licenseId;
    @JsonIgnore
    private FileResource license;
    @JsonIgnore
    private FileResource requestFile;
    @JsonIgnore
    private Tenant licensedTenant;
    private String licensedTenantId;


    public LicenseRequestCreate(LicenseRequest other) {
        super(other);
        this.macAddress = other.getMacAddress();
        this.diskSerialNumber = other.getDiskSerialNumber();
        this.externalHWSerialNumber = other.getExternalHWSerialNumber();
        this.licenseId = other.getLicense()!=null?other.getLicense().getId():null;
        this.license = other.getLicense();
        this.requestFile = other.getRequestFile();
        this.licensedTenant = other.getLicensedTenant();
        this.licensedTenantId=other.getLicensedTenant()!=null?other.getLicensedTenant().getId():null;
    }

    public LicenseRequestCreate() {
    }

    public String getMacAddress() {
        return macAddress;
    }

    public <T extends LicenseRequestCreate> T setMacAddress(String macAddress) {
        this.macAddress = macAddress;
        return (T) this;
    }

    public String getDiskSerialNumber() {
        return diskSerialNumber;
    }

    public <T extends LicenseRequestCreate> T setDiskSerialNumber(String diskSerialNumber) {
        this.diskSerialNumber = diskSerialNumber;
        return (T) this;
    }

    public String getExternalHWSerialNumber() {
        return externalHWSerialNumber;
    }

    public <T extends LicenseRequestCreate> T setExternalHWSerialNumber(String externalHWSerialNumber) {
        this.externalHWSerialNumber = externalHWSerialNumber;
        return (T) this;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public <T extends LicenseRequestCreate> T setLicenseId(String licenseId) {
        this.licenseId = licenseId;
        return (T) this;
    }

    @JsonIgnore
    public FileResource getLicense() {
        return license;
    }

    public <T extends LicenseRequestCreate> T setLicense(FileResource license) {
        this.license = license;
        return (T) this;
    }

    @JsonIgnore
    public FileResource getRequestFile() {
        return requestFile;
    }

    public <T extends LicenseRequestCreate> T setRequestFile(FileResource requestFile) {
        this.requestFile = requestFile;
        return (T) this;
    }

    @JsonIgnore
    public Tenant getLicensedTenant() {
        return licensedTenant;
    }

    public <T extends LicenseRequestCreate> T setLicensedTenant(Tenant licensedTenant) {
        this.licensedTenant = licensedTenant;
        return (T) this;
    }

    public String getLicensedTenantId() {
        return licensedTenantId;
    }

    public <T extends LicenseRequestCreate> T setLicensedTenantId(String licensedTenantId) {
        this.licensedTenantId = licensedTenantId;
        return (T) this;
    }
}
