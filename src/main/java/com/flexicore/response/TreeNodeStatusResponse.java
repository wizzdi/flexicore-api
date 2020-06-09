package com.flexicore.response;

import java.util.Map;

public class TreeNodeStatusResponse {

    private Map<String, Boolean> status;

    public TreeNodeStatusResponse(Map<String, Boolean> status) {
        this.status = status;
    }

    public TreeNodeStatusResponse() {
    }

    public Map<String, Boolean> getStatus() {
        return status;
    }

    public TreeNodeStatusResponse setStatus(Map<String, Boolean> status) {
        this.status = status;
        return this;
    }
}
