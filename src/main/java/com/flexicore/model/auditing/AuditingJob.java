package com.flexicore.model.auditing;

import com.flexicore.security.SecurityContext;

import javax.interceptor.InvocationContext;
import java.util.Date;

public class AuditingJob {
    private SecurityContext securityContext;
    private InvocationContext invocationContext;
    private Object response;
    private long timeTaken;
    private Date dateOccured;
    private String auditingType;
    private boolean failed;

    public AuditingJob(SecurityContext securityContext, InvocationContext invocationContext,
                       Object response, long timeTaken,Date dateOccured,String auditingType) {
        this.securityContext = securityContext;
        this.invocationContext = invocationContext;
        this.response = response;
        this.timeTaken = timeTaken;
        this.dateOccured=dateOccured;
        this.auditingType=auditingType;
    }

    public AuditingJob() {
    }

    public SecurityContext getSecurityContext() {
        return securityContext;
    }

    public AuditingJob setSecurityContext(SecurityContext securityContext) {
        this.securityContext = securityContext;
        return this;
    }

    public InvocationContext getInvocationContext() {
        return invocationContext;
    }

    public AuditingJob setInvocationContext(InvocationContext invocationContext) {
        this.invocationContext = invocationContext;
        return this;
    }

    public Object getResponse() {
        return response;
    }

    public AuditingJob setResponse(Object response) {
        this.response = response;
        return this;
    }

    public long getTimeTaken() {
        return timeTaken;
    }

    public AuditingJob setTimeTaken(long timeTaken) {
        this.timeTaken = timeTaken;
        return this;
    }

    public Date getDateOccured() {
        return dateOccured;
    }

    public AuditingJob setDateOccured(Date dateOccured) {
        this.dateOccured = dateOccured;
        return this;
    }

    public String getAuditingType() {
        return auditingType;
    }

    public AuditingJob setAuditingType(String auditingType) {
        this.auditingType = auditingType;
        return this;
    }

    public boolean isFailed() {
        return failed;
    }

    public AuditingJob setFailed(boolean failed) {
        this.failed = failed;
        return this;
    }
}
