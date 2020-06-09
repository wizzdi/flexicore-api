
package com.flexicore.data.jsoncontainers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "app_id",
    "type",
    "application",
    "expires_at",
    "is_valid",
    "issued_at",
    "scopes",
    "user_id"
})
public class Data {

    @JsonProperty("app_id")
    private String appId;
    @JsonProperty("type")
    private String type;
    @JsonProperty("application")
    private String application;
    @JsonProperty("expires_at")
    private int expiresAt;
    @JsonProperty("is_valid")
    private boolean isValid;
    @JsonProperty("issued_at")
    private int issuedAt;
    @JsonProperty("scopes")
    private List<String> scopes = null;
    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("app_id")
    public String getAppId() {
        return appId;
    }

    @JsonProperty("app_id")
    public void setAppId(String appId) {
        this.appId = appId;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("application")
    public String getApplication() {
        return application;
    }

    @JsonProperty("application")
    public void setApplication(String application) {
        this.application = application;
    }

    @JsonProperty("expires_at")
    public int getExpiresAt() {
        return expiresAt;
    }

    @JsonProperty("expires_at")
    public void setExpiresAt(int expiresAt) {
        this.expiresAt = expiresAt;
    }

    @JsonProperty("is_valid")
    public boolean isIsValid() {
        return isValid;
    }

    @JsonProperty("is_valid")
    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    @JsonProperty("issued_at")
    public int getIssuedAt() {
        return issuedAt;
    }

    @JsonProperty("issued_at")
    public void setIssuedAt(int issuedAt) {
        this.issuedAt = issuedAt;
    }

    @JsonProperty("scopes")
    public List<String> getScopes() {
        return scopes;
    }

    @JsonProperty("scopes")
    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }

    @JsonProperty("user_id")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("user_id")
    public void setUserId(String userId) {
        this.userId = userId;
    }

}
