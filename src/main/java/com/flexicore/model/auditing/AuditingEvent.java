package com.flexicore.model.auditing;


import com.flexicore.model.Baseclass;
import org.bson.Document;
import org.bson.codecs.pojo.annotations.BsonId;

import java.util.Date;

public class AuditingEvent {
    @BsonId
    private String id;
    private OperationHolder operationHolder;
    private Date dateOccurred;
    private UserHolder userHolder;
    private long timeTaken;
    private Document request;
    private Document response;
    private String auditingType;
    private boolean failed;

    public AuditingEvent() {
        this.id=Baseclass.getBase64ID();
    }

    public String getId() {
        return id;
    }

    public AuditingEvent setId(String id) {
        this.id = id;
        return this;
    }

    public OperationHolder getOperationHolder() {
        return operationHolder;
    }

    public AuditingEvent setOperationHolder(OperationHolder operationHolder) {
        this.operationHolder = operationHolder;
        return this;
    }

    public Date getDateOccurred() {
        return dateOccurred;
    }

    public AuditingEvent setDateOccurred(Date dateOccurred) {
        this.dateOccurred = dateOccurred;
        return this;
    }

    public UserHolder getUserHolder() {
        return userHolder;
    }

    public AuditingEvent setUserHolder(UserHolder userHolder) {
        this.userHolder = userHolder;
        return this;
    }

    public long getTimeTaken() {
        return timeTaken;
    }

    public AuditingEvent setTimeTaken(long timeTaken) {
        this.timeTaken = timeTaken;
        return this;
    }

    public Document getRequest() {
        return request;
    }

    public AuditingEvent setRequest(Document request) {
        this.request = request;
        return this;
    }

    public Document getResponse() {
        return response;
    }

    public AuditingEvent setResponse(Document response) {
        this.response = response;
        return this;
    }

    public String getAuditingType() {
        return auditingType;
    }

    public AuditingEvent setAuditingType(String auditingType) {
        this.auditingType = auditingType;
        return this;
    }

    public boolean isFailed() {
        return failed;
    }

    public AuditingEvent setFailed(boolean failed) {
        this.failed = failed;
        return this;
    }
}
