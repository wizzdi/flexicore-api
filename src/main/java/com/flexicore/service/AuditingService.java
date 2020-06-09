package com.flexicore.service;

import com.flexicore.data.jsoncontainers.PaginationResponse;
import com.flexicore.interfaces.AuditingContainerFactory;
import com.flexicore.interfaces.FlexiCoreService;
import com.flexicore.model.auditing.AuditingEvent;
import com.flexicore.model.auditing.AuditingJob;
import com.flexicore.request.AuditingFilter;
import com.flexicore.security.SecurityContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface AuditingService extends FlexiCoreService {
    Map<String, AuditingContainerFactory> containerMap = new ConcurrentHashMap<>();

    /**
     * registers #AuditingContainerFactory to be called if a parameter/return type of an audited operation is encountered
     * the #AuditingContainerFactory will transform the object before saved to auditing
     * @param canonicalClassName canonical class name of the object class
     * @param auditingContainerFactory function to be called when encountering canonicalClassName
     */
    static void registerAuditingContainer(String canonicalClassName, AuditingContainerFactory auditingContainerFactory) {
        containerMap.put(canonicalClassName, auditingContainerFactory);
    }

    /**
     * returns container factory for given class , this returns the last container factory registered for the given class
     * @param toContainClass class
     * @return container factory
     */
    static AuditingContainerFactory getAuditingContainerFactory(Class<?> toContainClass) {
        AuditingContainerFactory auditingContainerFactory = null;
        while (toContainClass != null && (auditingContainerFactory = containerMap.get(toContainClass.getCanonicalName())) == null) {
            toContainClass = toContainClass.getSuperclass();
        }
        return auditingContainerFactory;
    }

    /**
     * transform object using optionally registered #AuditingContainerFactory
     * @param o object to contain
     * @return null for null , contained object if there was a registered #AuditingContainerFactory , otherwise null
     */
    static Object contain(Object o) {
        if (o == null) {
            return null;
        }
        AuditingContainerFactory auditingContainerFactory = getAuditingContainerFactory(o.getClass());
        if (auditingContainerFactory != null) {
            return auditingContainerFactory.contain(o);
        }
        return null;
    }

    void merge(AuditingEvent o);

    /**
     * adds auditing job which will be saved in the auditing collection
     * @param auditingJob auditing job to be saved
     */
    void addAuditingJob(AuditingJob auditingJob);

    /**
     * returns all auditing events
     * @param auditingFilter object used to filter the result set
     * @param securityContext security context of the user to execute the action
     * @return list of auditing events
     */
    PaginationResponse<AuditingEvent> getAllAuditingEvents(AuditingFilter auditingFilter, SecurityContext securityContext);
}
