package com.flexicore.response;

public class SaveTreeNodeStatusResponse {

  private int created;
  private int updated;

    public SaveTreeNodeStatusResponse(int created, int updated) {
        this.created = created;
        this.updated = updated;
    }

    public SaveTreeNodeStatusResponse() {
    }

    public int getCreated() {
        return created;
    }

    public SaveTreeNodeStatusResponse setCreated(int created) {
        this.created = created;
        return this;
    }

    public int getUpdated() {
        return updated;
    }

    public SaveTreeNodeStatusResponse setUpdated(int updated) {
        this.updated = updated;
        return this;
    }
}
