/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.model;

import java.util.HashMap;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.flexicore.annotations.AnnotatedClazz;
import com.flexicore.annotations.FieldForView;
import com.flexicore.data.jsoncontainers.Views;
import com.flexicore.security.SecurityContext;


/**
 * this class is used for linking other Baseclass extenders in m2m fashion.
 *
 * @author Avishay Ben Natan
 */
@SuppressWarnings("serial")
@AnnotatedClazz(Category = "core", Name = "Baselink", Description = "Links two instances of Baseclass")
@Table(name = "baselink", indexes = {@Index(name = "baselink_right_ix", columnList = "rightside_id"),
        @Index(name = "baselink_left_ix", columnList = "leftside_id"),
        @Index(name = "baselink_combined", columnList = "leftside_id,rightside_id"),
        @Index(name = "baselink_value_idx", columnList = "value_id"),
        @Index(name = "baselink_simplevalue_idx", columnList = "simplevalue"),
        @Index(name = "baselink_cvalue_idx", columnList = "leftside_id,rightside_id,value_id"),
        @Index(name = "baselink_cvaluef_idx", columnList = "leftside_id,rightside_id,value_id,simplevalue")})
@Entity


public class Baselink extends Baseclass {

    @FieldForView
    protected Baseclass rightside;
    @FieldForView
    protected Baseclass leftside;

    @FieldForView
    private String simplevalue;
    @FieldForView
    protected Baseclass value;

    public Baselink() {
        super();
    }

    public Baselink(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }

    @Deprecated
    public Baselink(Baseclass left, Baseclass right) {
        super();
        this.Init();
        this.setLeftside(left);
        this.setRightside(right);
    }

    @ManyToOne(targetEntity = Baseclass.class)
    public Baseclass getRightside() {
        return this.rightside;
    }

    public void setRightside(Baseclass rightside) {
        this.rightside = rightside;
    }

    @ManyToOne(targetEntity = Baseclass.class)
    public Baseclass getLeftside() {
        return this.leftside;
    }

    public void setLeftside(Baseclass leftside) {
        this.leftside = leftside;
    }


    public String getSimplevalue() {
        return simplevalue;
    }

    public void setSimplevalue(String simplevalue) {
        this.simplevalue = simplevalue;
    }

    @ManyToOne(targetEntity = Baseclass.class)
    public Baseclass getValue() {
        return value;
    }

    public void setValue(Baseclass value) {
        this.value = value;
    }

    @Deprecated
    public void Init(Baseclass left, Baseclass right) {
        super.Init();
        this.setLeftside(left);
        this.setRightside(right);
    }


}
