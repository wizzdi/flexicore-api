package com.flexicore.model.auditing;

import com.flexicore.model.Baseclass;
import com.flexicore.model.User;
import org.bson.codecs.pojo.annotations.BsonId;

public class UserHolder {
    @BsonId
    private String id;
    private String userId;
    private String name;

    public UserHolder() {
        this.id=Baseclass.getBase64ID();
    }

    public UserHolder(User user) {
        this();
        this.userId=user.getId();
        this.name=user.getName();
    }

    public String getId() {
        return id;
    }

    public UserHolder setId(String id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public UserHolder setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserHolder setName(String name) {
        this.name = name;
        return this;
    }
}
