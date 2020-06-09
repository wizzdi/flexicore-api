package com.flexicore.request;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.licensing.LicensingProduct;

/**
 * Created by Asaf on 17/10/2016.
 */
public class LicenseRequestToProductCreate extends LicenseRequestToEntityCreate {

    private String licensingProductId;
    @JsonIgnore
    private LicensingProduct licensingProduct;

    public String getLicensingProductId() {
        return licensingProductId;
    }

    public <T extends LicenseRequestToProductCreate> T setLicensingProductId(String licensingProductId) {
        this.licensingProductId = licensingProductId;
        return (T) this;
    }

    @JsonIgnore
    public LicensingProduct getLicensingProduct() {
        return licensingProduct;
    }

    public <T extends LicenseRequestToProductCreate> T setLicensingProduct(LicensingProduct licensingProduct) {
        this.licensingProduct = licensingProduct;
        return (T) this;
    }
}
