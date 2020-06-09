package com.flexicore.model;

import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;

@Entity
public class Presenter extends Baseclass {

    public Presenter() {
    }

    public Presenter(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }
}
