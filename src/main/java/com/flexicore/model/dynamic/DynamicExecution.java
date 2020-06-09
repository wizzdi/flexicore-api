package com.flexicore.model.dynamic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.Baseclass;
import com.flexicore.security.SecurityContext;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DynamicExecution extends Baseclass {
    private static DynamicExecution s_Singleton=new DynamicExecution();
    public  static DynamicExecution s() {return s_Singleton;}

    public DynamicExecution() {
    }

    public DynamicExecution(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }

    @OneToMany(targetEntity = ServiceCanonicalName.class,mappedBy = "dynamicExecution",fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)

    private List<ServiceCanonicalName> serviceCanonicalNames=new ArrayList<>();
    private String methodName;

    @OneToOne(targetEntity = ExecutionParametersHolder.class)
    private ExecutionParametersHolder executionParametersHolder;


    @OneToMany(targetEntity = ServiceCanonicalName.class,mappedBy = "dynamicExecution",fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    public List<ServiceCanonicalName> getServiceCanonicalNames() {
        return serviceCanonicalNames;
    }

    public DynamicExecution setServiceCanonicalNames(List<ServiceCanonicalName> serviceCanonicalNames) {
        this.serviceCanonicalNames = serviceCanonicalNames;
        return this;
    }

    public String getMethodName() {
        return methodName;
    }

    public DynamicExecution setMethodName(String methodName) {
        this.methodName = methodName;
        return this;
    }


    @OneToOne(targetEntity = ExecutionParametersHolder.class)
    public ExecutionParametersHolder getExecutionParametersHolder() {
        return executionParametersHolder;
    }

    public DynamicExecution setExecutionParametersHolder(ExecutionParametersHolder executionParametersHolder) {
        this.executionParametersHolder = executionParametersHolder;
        return this;
    }
}
