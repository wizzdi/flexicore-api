package com.flexicore.response;

public enum LoginErrors {
    IDENTIFIER_NOT_PROVIDED(1), PASSWORD_NOT_PROVIDED(2);

    private int code;
    LoginErrors(int code) {
        this.code=code;
    }

    public int getCode() {
        return code;
    }
}
