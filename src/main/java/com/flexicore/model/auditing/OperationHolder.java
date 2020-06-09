package com.flexicore.model.auditing;

import com.flexicore.model.Baseclass;
import com.flexicore.model.Operation;
import org.bson.codecs.pojo.annotations.BsonId;

public class OperationHolder {
    @BsonId
    private String id;
    private String operationId;
    private String name;
    private String description;

    public OperationHolder() {
        this.id=Baseclass.getBase64ID();
    }

    public OperationHolder(Operation operation) {
        this();
        this.operationId=operation.getId();
        this.name=operation.getName();
        this.description=operation.getDescription();
    }

    public String getId() {
        return id;
    }

    public OperationHolder setId(String id) {
        this.id = id;
        return this;
    }

    public String getOperationId() {
        return operationId;
    }

    public OperationHolder setOperationId(String operationId) {
        this.operationId = operationId;
        return this;
    }

    public String getName() {
        return name;
    }

    public OperationHolder setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OperationHolder setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "OperationHolder{" +
                "id='" + id + '\'' +
                ", operationId='" + operationId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
