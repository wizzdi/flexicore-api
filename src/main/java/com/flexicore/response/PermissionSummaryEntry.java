package com.flexicore.response;

import com.flexicore.annotations.IOperation;
import com.flexicore.model.*;

import java.util.*;
import java.util.stream.Collectors;

public class PermissionSummaryEntry {
    private User user;
    private Map<String, String> explanation=new HashMap<>();
    private List<RoleToUser> roles;
    private List<TenantToUser> tenants;
    private Map<String, Baseclass> creator;
    private Map<String, Boolean> allowed = new HashMap<>();
    private Map<String, List<UserToBaseClass>> userToBaseClasses = new HashMap<>();
    private Map<String, List<RoleToBaseclass>> roleToBaseclasses = new HashMap<>();
    private Map<String, List<TenantToBaseClassPremission>> tenantToBaseClassPremissions = new HashMap<>();

    private Map<String, List<UserToBaseClass>> userToClazz = new HashMap<>();
    private Map<String, List<RoleToBaseclass>> roleToClazz = new HashMap<>();
    private Map<String, List<TenantToBaseClassPremission>> tenantToClazz = new HashMap<>();

    private Map<String, List<UserToBaseClass>> userToPermissionGroup = new HashMap<>();
    private Map<String, List<RoleToBaseclass>> roleToPermissionGroup = new HashMap<>();
    private Map<String, List<TenantToBaseClassPremission>> tenantToPermissionGroup = new HashMap<>();


    public User getUser() {
        return user;
    }

    public <T extends PermissionSummaryEntry> T setUser(User user) {
        this.user = user;
        return (T) this;
    }


    public List<RoleToUser> getRoles() {
        return roles;
    }

    public <T extends PermissionSummaryEntry> T setRoles(List<RoleToUser> roles) {
        this.roles = roles;
        return (T) this;
    }

    public List<TenantToUser> getTenants() {
        return tenants;
    }

    public <T extends PermissionSummaryEntry> T setTenants(List<TenantToUser> tenants) {
        this.tenants = tenants;
        return (T) this;
    }

    public Map<String, List<UserToBaseClass>> getUserToBaseClasses() {
        return userToBaseClasses;
    }

    public <T extends PermissionSummaryEntry> T setUserToBaseClasses(Map<String, List<UserToBaseClass>> userToBaseClasses) {
        this.userToBaseClasses = userToBaseClasses;
        return (T) this;
    }

    public Map<String, List<RoleToBaseclass>> getRoleToBaseclasses() {
        return roleToBaseclasses;
    }

    public <T extends PermissionSummaryEntry> T setRoleToBaseclasses(Map<String, List<RoleToBaseclass>> roleToBaseclasses) {
        this.roleToBaseclasses = roleToBaseclasses;
        return (T) this;
    }

    public Map<String, List<TenantToBaseClassPremission>> getTenantToBaseClassPremissions() {
        return tenantToBaseClassPremissions;
    }

    public <T extends PermissionSummaryEntry> T setTenantToBaseClassPremissions(Map<String, List<TenantToBaseClassPremission>> tenantToBaseClassPremissions) {
        this.tenantToBaseClassPremissions = tenantToBaseClassPremissions;
        return (T) this;
    }

    public Map<String, List<UserToBaseClass>> getUserToClazz() {
        return userToClazz;
    }

    public <T extends PermissionSummaryEntry> T setUserToClazz(Map<String, List<UserToBaseClass>> userToClazz) {
        this.userToClazz = userToClazz;
        return (T) this;
    }

    public Map<String, List<RoleToBaseclass>> getRoleToClazz() {
        return roleToClazz;
    }

    public <T extends PermissionSummaryEntry> T setRoleToClazz(Map<String, List<RoleToBaseclass>> roleToClazz) {
        this.roleToClazz = roleToClazz;
        return (T) this;
    }

    public Map<String, List<TenantToBaseClassPremission>> getTenantToClazz() {
        return tenantToClazz;
    }

    public <T extends PermissionSummaryEntry> T setTenantToClazz(Map<String, List<TenantToBaseClassPremission>> tenantToClazz) {
        this.tenantToClazz = tenantToClazz;
        return (T) this;
    }

    public Map<String, List<UserToBaseClass>> getUserToPermissionGroup() {
        return userToPermissionGroup;
    }

    public <T extends PermissionSummaryEntry> T setUserToPermissionGroup(Map<String, List<UserToBaseClass>> userToPermissionGroup) {
        this.userToPermissionGroup = userToPermissionGroup;
        return (T) this;
    }

    public Map<String, List<RoleToBaseclass>> getRoleToPermissionGroup() {
        return roleToPermissionGroup;
    }

    public <T extends PermissionSummaryEntry> T setRoleToPermissionGroup(Map<String, List<RoleToBaseclass>> roleToPermissionGroup) {
        this.roleToPermissionGroup = roleToPermissionGroup;
        return (T) this;
    }

    public Map<String, List<TenantToBaseClassPremission>> getTenantToPermissionGroup() {
        return tenantToPermissionGroup;
    }

    public <T extends PermissionSummaryEntry> T setTenantToPermissionGroup(Map<String, List<TenantToBaseClassPremission>> tenantToPermissionGroup) {
        this.tenantToPermissionGroup = tenantToPermissionGroup;
        return (T) this;
    }

    public Map<String, Baseclass> getCreator() {
        return creator;
    }

    public <T extends PermissionSummaryEntry> T setCreator(Map<String, Baseclass> creator) {
        this.creator = creator;
        return (T) this;
    }

    public Map<String, String> getExplanation() {
        return explanation;
    }

    public <T extends PermissionSummaryEntry> T setExplanation(Map<String, String> explanation) {
        this.explanation = explanation;
        return (T) this;
    }

    public Map<String, Boolean> getAllowed() {
        return allowed;
    }

    public <T extends PermissionSummaryEntry> T setAllowed(Map<String, Boolean> allowed) {
        this.allowed = allowed;
        return (T) this;
    }

    public void updateExplanation(String baseclassId) {
        boolean allowed=this.allowed.get(baseclassId);
       String explanation="User "+user.getId()+" is "+(!allowed?"NOT":"")+" allowed to Baseclass "+baseclassId +" because:";
        Set<String> reasons=new HashSet<>();
        if(creator.get(baseclassId)!=null){
            reasons.add("it is it creator");
        }
        List<UserToBaseClass> userToBaseClasses = this.userToBaseClasses.get(baseclassId);
        if(userToBaseClasses !=null ){
            for (UserToBaseClass userToBaseClass : userToBaseClasses) {
                reasons.add("it has a direct link "+userToBaseClass.getId()+"to it");
            }
        }
        List<RoleToBaseclass> roleToBaseclasses = this.roleToBaseclasses.get(baseclassId);
        if(roleToBaseclasses !=null){
            for (RoleToBaseclass roleToBaseclass : roleToBaseclasses) {
                reasons.add("its role "+roleToBaseclass.getLeftside().getId()+" has a direct link "+roleToBaseclass.getId()+"to it");

            }
        }

        List<TenantToBaseClassPremission> tenantToBaseClassPremissions = this.tenantToBaseClassPremissions.get(baseclassId);
        if(tenantToBaseClassPremissions !=null){
            for (TenantToBaseClassPremission tenantToBaseClassPremission : tenantToBaseClassPremissions) {
                reasons.add("its Tenant "+tenantToBaseClassPremission.getLeftside().getId()+" has a direct link "+tenantToBaseClassPremission.getId()+"to it");

            }
        }

        List<UserToBaseClass> userToClazz = this.userToClazz.get(baseclassId);
        if(userToClazz !=null ){
            for (UserToBaseClass userToBaseClass : userToClazz) {
                reasons.add("its clazz "+userToBaseClass.getRightside().getId()+" has a link "+userToBaseClass.getId()+"to it");
            }
        }
        List<RoleToBaseclass> roleToClazzes = this.roleToClazz.get(baseclassId);
        if(roleToClazzes !=null){
            for (RoleToBaseclass roleToClazz : roleToClazzes) {
                reasons.add("its clazz "+roleToClazz.getRightside().getId()+" has a link "+roleToClazz.getId()+"with a role "+roleToClazz.getLeftside().getId()+" it has");

            }
        }

        List<TenantToBaseClassPremission> tenantToClazzes = this.tenantToClazz.get(baseclassId);
        if(tenantToClazzes !=null){
            for (TenantToBaseClassPremission tenantToClazz : tenantToClazzes) {
                reasons.add("its clazz "+tenantToClazz.getRightside().getId()+" has a link "+tenantToClazz.getId()+"with a tenant "+tenantToClazz.getLeftside().getId()+" it is in");

            }
        }

        List<UserToBaseClass> userToPermissionGroups = this.userToPermissionGroup.get(baseclassId);
        if(userToPermissionGroups !=null ){
            for (UserToBaseClass userToPermissionGroup : userToPermissionGroups) {
                reasons.add("it is connected via link "+userToPermissionGroup.getId()+"to a permission group "+userToPermissionGroup.getRightside().getId()+"in which it is in");
            }
        }
        List<RoleToBaseclass> roleToPermissionGroups = this.roleToPermissionGroup.get(baseclassId);
        if(roleToPermissionGroups !=null){
            for (RoleToBaseclass roleToPermissionGroup : roleToPermissionGroups) {
                reasons.add("its role "+roleToPermissionGroup.getLeftside().getId()+"is connected via link "+roleToPermissionGroup.getId()+"to a permission group "+roleToPermissionGroup.getRightside().getId()+"in which it is in");

            }
        }

        List<TenantToBaseClassPremission> tenantToPermissionGroups = this.tenantToBaseClassPremissions.get(baseclassId);
        if(tenantToPermissionGroups !=null){
            for (TenantToBaseClassPremission tenantToPermissionGroup : tenantToPermissionGroups) {
                reasons.add("its Tenant "+tenantToPermissionGroup.getLeftside().getId()+"is connected via link "+tenantToPermissionGroup.getId()+"to a permission group "+tenantToPermissionGroup.getRightside().getId()+"in which it is in");

            }
        }
        if(reasons.isEmpty()){
            reasons.add("He is not this baseclass creator nor does he , his roles or his tenants have any special permission to access it");
        }
        explanation+= System.lineSeparator()+ reasons.parallelStream().collect(Collectors.joining(System.lineSeparator()));
        this.explanation.put(baseclassId,explanation);
    }

    public void updateAllowed(String baseclassId) {
        boolean allowed = userToBaseClasses.getOrDefault(baseclassId, new ArrayList<>()).parallelStream().anyMatch(f -> f.getSimplevalue() != null && IOperation.Access.allow.name().toLowerCase().equals(f.getSimplevalue().toLowerCase()))
                || userToClazz.getOrDefault(baseclassId, new ArrayList<>()).parallelStream().anyMatch(f -> f.getSimplevalue() != null && IOperation.Access.allow.name().toLowerCase().equals(f.getSimplevalue().toLowerCase()))
                || userToPermissionGroup.getOrDefault(baseclassId, new ArrayList<>()).parallelStream().anyMatch(f -> f.getSimplevalue() != null && IOperation.Access.allow.name().toLowerCase().equals(f.getSimplevalue().toLowerCase()))
                || roleToBaseclasses.getOrDefault(baseclassId, new ArrayList<>()).parallelStream().anyMatch(f -> f.getSimplevalue() != null && IOperation.Access.allow.name().toLowerCase().equals(f.getSimplevalue().toLowerCase()))
                || roleToClazz.getOrDefault(baseclassId, new ArrayList<>()).parallelStream().anyMatch(f -> f.getSimplevalue() != null && IOperation.Access.allow.name().toLowerCase().equals(f.getSimplevalue().toLowerCase()))
                || roleToPermissionGroup.getOrDefault(baseclassId, new ArrayList<>()).parallelStream().anyMatch(f -> f.getSimplevalue() != null && IOperation.Access.allow.name().toLowerCase().equals(f.getSimplevalue().toLowerCase()))
                || tenantToBaseClassPremissions.getOrDefault(baseclassId, new ArrayList<>()).parallelStream().anyMatch(f -> f.getSimplevalue() != null && IOperation.Access.allow.name().toLowerCase().equals(f.getSimplevalue().toLowerCase()))
                || tenantToClazz.getOrDefault(baseclassId, new ArrayList<>()).parallelStream().anyMatch(f -> f.getSimplevalue() != null && IOperation.Access.allow.name().toLowerCase().equals(f.getSimplevalue().toLowerCase()))
                || tenantToPermissionGroup.getOrDefault(baseclassId, new ArrayList<>()).parallelStream().anyMatch(f -> f.getSimplevalue() != null && IOperation.Access.allow.name().toLowerCase().equals(f.getSimplevalue().toLowerCase()))
                || creator.get(baseclassId)!=null;
        this.allowed.put(baseclassId, allowed);

    }
}
