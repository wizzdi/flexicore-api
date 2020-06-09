package com.flexicore.request;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.licensing.LicensingEntity;

/**
 * Created by Asaf on 17/10/2016.
 */
public class LicensingEntityUpdate extends LicensingEntityCreate {

    private String id;
    @JsonIgnore
    private LicensingEntity licensingEntity;

    public String getId() {
        return id;
    }

    public <T extends LicensingEntityUpdate> T setId(String id) {
        this.id = id;
        return (T) this;
    }

    @JsonIgnore
    public LicensingEntity getLicensingEntity() {
        return licensingEntity;
    }

    public <T extends LicensingEntityUpdate> T setLicensingEntity(LicensingEntity licensingEntity) {
        this.licensingEntity = licensingEntity;
        return (T) this;
    }
}
