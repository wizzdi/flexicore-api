package com.flexicore.model.auditing;


public class ResponseHolder {

    private Object response;

    public ResponseHolder(Object response) {
        this.response = response;
    }

    public Object getResponse() {
        return response;
    }

    public ResponseHolder setResponse(Object response) {
        this.response = response;
        return this;
    }
}
