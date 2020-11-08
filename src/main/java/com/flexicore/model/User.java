/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.flexicore.annotations.AnnotatedClazz;
import com.flexicore.annotations.FullTextSearch;
import com.flexicore.annotations.FullTextSearchOptions;
import com.flexicore.data.jsoncontainers.Views;
import com.flexicore.security.SecurityContext;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

//the table name 'user' isn't allowed in Postgresql
@SuppressWarnings("serial")
@AnnotatedClazz(Category = "core", Name = "User", Description = "The basic class which uses the system")
@Table(name = "UserTable", indexes = {
        @Index(name = "user_email_ix", columnList = "email")
})
@Entity
@Schema( description = "The basic entity for controlling access to system functions and objects")
@FullTextSearch(supported = true)
public class User extends SecurityEntity {

    private String email;
    private String homeDir;
    private String surName;

    private boolean disabled;
    @Column(columnDefinition = "timestamp with time zone")
    private OffsetDateTime dateApproved;
    @ManyToOne(targetEntity = User.class)
    private User approvingUser;

    @Lob
    private String uiConfiguration;

    @JsonIgnore
    private String forgotPasswordToken;
    @JsonIgnore
    @Column(columnDefinition = "timestamp with time zone")
    private OffsetDateTime forgotPasswordTokenValid;

    @JsonIgnore
    private String emailVerificationToken;
    @JsonIgnore
    @Column(columnDefinition = "timestamp with time zone")
    private OffsetDateTime emailVerificationTokenValid;
    @Column(columnDefinition = "timestamp with time zone")
    private OffsetDateTime lastVerificationDate;


    @JsonIgnore

    @OneToMany(targetEntity = RoleToUser.class,mappedBy = "rightside", fetch = FetchType.LAZY) //users are subscribed to very few roles.
    private List<RoleToUser> roles = new ArrayList<>();


    @OneToMany(targetEntity = TenantToUser.class,mappedBy = "rightside")
    @JsonIgnore
    //users are subscribed to very few roles.
    private List<TenantToUser> tenantToUsers = new ArrayList<>();


    @JsonIgnore

    @OneToMany(targetEntity = UserToBaseClass.class,mappedBy = "leftside", fetch = FetchType.LAZY)
    private List<UserToBaseClass> userToBaseClasses = new ArrayList<>();


    //	@JsonIgnore
    @JsonIgnore
    @OneToMany(targetEntity = RoleToUser.class,mappedBy = "rightside", fetch = FetchType.LAZY) //users are subscribed to very few roles.
    public List<RoleToUser> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleToUser> roleToUser) {
        this.roles = roleToUser;
    }

    @Column(name = "phone_number")
    private String phoneNumber;
    @JsonView(Views.Full.class)
    private String password;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public User() {
        super();
    }

    public User(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + "Name " + this.name + " Email: " + this.email + "Phone number: " + this.phoneNumber;
    }

    @JsonView(Views.Full.class)

    @FullTextSearchOptions(include = false)

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @FullTextSearchOptions(include = false)
    public String getHomeDir() {
        return homeDir;
    }

    public void setHomeDir(String homeDir) {
        this.homeDir = homeDir;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }



    @OneToMany(targetEntity = TenantToUser.class,mappedBy = "rightside", fetch = FetchType.EAGER)
    @JsonIgnore
    public List<TenantToUser> getTenantToUsers() {
        return tenantToUsers;
    }

    public void setTenantToUsers(List<TenantToUser> tenantToUsers) {
        this.tenantToUsers = tenantToUsers;
    }


    @JsonIgnore

    @OneToMany(targetEntity = UserToBaseClass.class,mappedBy = "securityEntity", fetch = FetchType.LAZY)
    public List<UserToBaseClass> getUserToBaseClasses() {
        return userToBaseClasses;
    }

    public void setUserToBaseClasses(List<UserToBaseClass> userToBaseClasses) {
        this.userToBaseClasses = userToBaseClasses;
    }
    @JsonIgnore
    @FullTextSearchOptions(include = false)
    public String getForgotPasswordToken() {
        return forgotPasswordToken;
    }

    public User setForgotPasswordToken(String verificationToken) {
        this.forgotPasswordToken = verificationToken;
        return this;
    }
    @JsonIgnore
    @FullTextSearchOptions(include = false)
    public OffsetDateTime getForgotPasswordTokenValid() {
        return forgotPasswordTokenValid;
    }

    public User setForgotPasswordTokenValid(OffsetDateTime verificationTokenValid) {
        this.forgotPasswordTokenValid = verificationTokenValid;
        return this;
    }

    @JsonIgnore
    @FullTextSearchOptions(include = false)
    public String getEmailVerificationToken() {
        return emailVerificationToken;
    }

    public User setEmailVerificationToken(String emailVerificationToken) {
        this.emailVerificationToken = emailVerificationToken;
        return this;
    }

    @JsonIgnore
    public OffsetDateTime getEmailVerificationTokenValid() {
        return emailVerificationTokenValid;
    }

    public User setEmailVerificationTokenValid(OffsetDateTime emailVerificationTokenValid) {
        this.emailVerificationTokenValid = emailVerificationTokenValid;
        return this;
    }

    public OffsetDateTime getLastVerificationDate() {
        return lastVerificationDate;
    }

    public User setLastVerificationDate(OffsetDateTime lastVerificationDate) {
        this.lastVerificationDate = lastVerificationDate;
        return this;
    }

    @Lob
    @FullTextSearchOptions(include = false)
    public String getUiConfiguration() {
        return uiConfiguration;
    }

    public User setUiConfiguration(String uiConfiguration) {
        this.uiConfiguration = uiConfiguration;
        return this;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public <T extends User> T setDisabled(boolean unSecureRegistration) {
        this.disabled = unSecureRegistration;
        return (T) this;
    }

    public OffsetDateTime getDateApproved() {
        return dateApproved;
    }

    public <T extends User> T setDateApproved(OffsetDateTime dateApproved) {
        this.dateApproved = dateApproved;
        return (T) this;
    }

    @JsonIgnore
    @ManyToOne(targetEntity = User.class)
    public User getApprovingUser() {
        return approvingUser;
    }

    public <T extends User> T setApprovingUser(User approvingUser) {
        this.approvingUser = approvingUser;
        return (T) this;
    }
}