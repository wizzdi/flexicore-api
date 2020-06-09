package com.flexicore.model.auditing;


public class RequestHolder {

    private Object request;

    public RequestHolder(Object request) {
        this.request = request;
    }

    public Object getRequest() {
        return request;
    }

    public RequestHolder setRequest(Object request) {
        this.request = request;
        return this;
    }
}
