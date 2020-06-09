package com.flexicore.response;

import java.time.OffsetDateTime;

public class AuthenticationResponse {
    private String authenticationKey;
    private OffsetDateTime tokenExpirationDate;
    private String userId;


    public String getAuthenticationKey() {
        return authenticationKey;
    }

    public AuthenticationResponse setAuthenticationKey(String authenticationKey) {
        this.authenticationKey = authenticationKey;
        return this;
    }

    public OffsetDateTime getTokenExpirationDate() {
        return tokenExpirationDate;
    }

    public AuthenticationResponse setTokenExpirationDate(OffsetDateTime tokenExpirationDate) {
        this.tokenExpirationDate = tokenExpirationDate;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public AuthenticationResponse setUserId(String userId) {
        this.userId = userId;
        return this;
    }
}
