/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import com.flexicore.annotations.AnnotatedClazz;
import com.flexicore.annotations.FieldForView;
import com.flexicore.annotations.FullTextSearchOptions;
import com.flexicore.converters.JsonConverter;
import com.flexicore.data.jsoncontainers.FCTypeResolver;
import com.flexicore.data.jsoncontainers.Views;
import com.flexicore.data.jsoncontainers.Views.Full;
import com.flexicore.interfaces.EntityListener;
import com.flexicore.interfaces.Syncable;
import com.flexicore.listeners.EntityListeners.BaseclassListener;
import com.flexicore.security.SecurityContext;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;
import java.util.stream.Collectors;


@AnnotatedClazz(Category = "core", Name = "Baseclass", Description = "The root of all entities")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity

@XmlAccessorType(XmlAccessType.PROPERTY)
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "json-id")
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "json-type", visible = true)
@JsonTypeResolver(FCTypeResolver.class)
@Table(name = "baseclass", indexes = {@Index(name = "baseclass_id", columnList = "id", unique = true),
        @Index(name = "clazz_idx", columnList = "clazz_id"),
        @Index(name = "creator_idx", columnList = "creator_id"),
        @Index(name = "name_idx", columnList = "name"),
        @Index(name = "sort_idx", columnList = "name,id"),
        @Index(name = "search_idx", columnList = "searchKey,dtype")
})
@EntityListeners(BaseclassListener.class)

public class Baseclass implements Serializable, Syncable {
    private static Baseclass s_Singleton = new Baseclass();
    private static Map<String, Set<String>> permissionContextMap = new ConcurrentHashMap<>();

    public static Baseclass s() {
        return s_Singleton;
    }


    private static Map<Class<?>, Queue<EntityListener>> registeredEntityListener = new ConcurrentHashMap<>();
    private static Map<Class<?>, List<EntityListener>> entityListenerCache = new ConcurrentHashMap<>();
    private static Consumer<Baseclass> onBaseclassCreated;

    private static ConcurrentHashMap<String, Clazz> allclazzes = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, String> generatedIds = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Class<? extends Baseclass>> simpleNameToClass = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Class<? extends Baseclass>, Baseclass> singletoneInstances = new ConcurrentHashMap<>();
    private static final long serialVersionUID = 1L;


    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonConverter.class)
    private Map<String,Object> jsonNode;

    @Lob
    @JsonIgnore
    private String searchKey;

    @Lob
    private String permissionContext;


    @Column(name = "dtype", insertable = false, updatable = false)
    private String dtype;

    @Id
    @Column(name = "id", nullable = false, length = 22)
    protected String id;
    @Size(max = 255)
    @FieldForView(group = "General", validation = "^.{0,255}$")
    protected String name;
    @FieldForView(group = "General", validation = "^.{0,255}$")
    protected String description;
    //@JsonIdentityReference(alwaysAsId = true)
    @FieldForView(group = "General")
    @ManyToOne(targetEntity = User.class)

    @JsonView(Views.ForSwaggerOnly.class)
    protected User creator;
    //
    //protected String  dummy;

    @ManyToOne(targetEntity = Tenant.class)
    @FieldForView

    private Tenant tenant;

    @ManyToOne(targetEntity = Tenant.class)

    @FieldForView
    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    @ManyToOne(targetEntity = Clazz.class)


    @JsonView(Full.class)
    protected Clazz clazz;
    // this field is added to to trigger metadatamodel generation , sometimes _.clazz field isn't created.

    @Transient
    private String creationError = null;


    private boolean dontUpdateUpdateDate;

    private boolean systemObject;

    @Column(columnDefinition = "timestamp with time zone")
    private OffsetDateTime creationDate;
    @Column(columnDefinition = "timestamp with time zone")
    private OffsetDateTime updateDate;

    private boolean softDelete;

    public boolean isSoftDelete() {
        return softDelete;
    }

    public void setSoftDelete(boolean softDelete) {
        this.softDelete = softDelete;
    }

    @JsonIgnore
    @OneToMany(targetEntity = PermissionGroupToBaseclass.class, mappedBy = "rightside")
    private List<PermissionGroupToBaseclass> permissionGroupToBaseclasses = new ArrayList<>();


    @JsonIgnore
    //@JsonIdentityReference(alwaysAsId = true)
    @OneToMany(targetEntity = CategoryToBaseClass.class, mappedBy = "rightside")

    private List<CategoryToBaseClass> categories = new ArrayList<>();



    public OffsetDateTime getCreationDate() {
        return creationDate;
    }


    public void setCreationDate(OffsetDateTime timestampField) {
        this.creationDate = timestampField;
    }

    @Deprecated
    public void Init() {
        init();
    }


    public void init() {
        if (id == null) {
            id = getBase64ID();
        }

        String type = this.getClass().getCanonicalName();
        if (creationDate == null) {
            creationDate = OffsetDateTime.now();
        }
        if (this.name == null || !this.name.equals("com.flexicore.model.Clazz")) {
            Clazz clazz = allclazzes.get(type);
            if (clazz != null) {
                this.setClazz(clazz);

            } else {
                this.setCreationError("Cannot find a clazz for: " + type);
            }
        } else {
            //the type for Clazz it itself.
            this.setClazz((Clazz) this);

        }
        if (onBaseclassCreated != null) {
            onBaseclassCreated.accept(this);
        }


    }


    public Baseclass() {
        super();

    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        if (another instanceof Baseclass) {
            Baseclass base = (Baseclass) another;
            if (base.getId() == null || base.getId().isEmpty()) return false;
            return (base.getId().equals(this.getId()));
        }
        return false;

    }

    public static String getBase64ID() {
        String result;
        try {
            result = new String(Base64.encodeBase64(Hex.decodeHex(UUID.randomUUID().toString().replaceAll("-", "")
                    .toCharArray())));
            result = result.replace("/", "-"); // we cannot afford a slash
            result = result.substring(0, 22); //we don't need the trailing ==

        } catch (DecoderException e) {
            result = "errorinid";
        }

        return result;
    }


    @FullTextSearchOptions(include = false)
    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonView(Views.Full.class)
    @XmlTransient
    @ManyToOne(targetEntity = Clazz.class)


    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }


    @JsonView(Views.ForSwaggerOnly.class)
    @ManyToOne(targetEntity = User.class)


    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    @JsonIgnore
    public String getCreationError() {
        return creationError;
    }


    @JsonIgnore
    @OneToMany(targetEntity = SecurityLink.class, mappedBy = "rightside")
    public List<SecurityLink> securityLinks = new ArrayList<>();

    public void setCreationError(String creationError) {
        this.creationError = creationError;
    }

    /**
     * 1
     *
     * @param name
     * @param securityContext
     */
    @Deprecated
    public <T extends Baseclass> T Create(String name, SecurityContext securityContext) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException {
        return create(name, securityContext);

    }


    private <T extends Baseclass> T create(String name, SecurityContext securityContext) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException {
        String p_ClassName = this.getClass().getCanonicalName();
        return (T) newInstanceInternal(p_ClassName, name, securityContext);

    }

    public <T extends Baseclass> T createUnchecked(String name, SecurityContext securityContext) {
        try {
            T t = create(name, securityContext);
            t.init();
            return t;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Deprecated
    public <T extends Baseclass> T CreateUnchecked(String name, SecurityContext securityContext) {
        try {
            return create(name, securityContext);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Baseclass(String name, SecurityContext securityContext) {
        this.name = name;
        if (securityContext != null) {
            this.creator = securityContext.getUser();
            this.tenant = securityContext.getTenantToCreateIn();
        }
        Set<String> contextSet = permissionContextMap.get(getClass().getCanonicalName());
        if (contextSet != null && !contextSet.isEmpty()) {
            this.permissionContext = contextSet.parallelStream().collect(Collectors.joining("|"));

        }

        init();

    }

    @Deprecated
    public static <T extends Baseclass> T newInstance(String className, String name, SecurityContext securityContext) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException {
        return newInstanceInternal(className, name, securityContext);
    }


    /**
     * @param className
     * @param name
     * @param securityContext
     */
    private static <T extends Baseclass> T newInstanceInternal(String className, String name, SecurityContext securityContext) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException {
        Tenant tenantToCreateIn = null;
        if (securityContext != null) {
            tenantToCreateIn = securityContext.getTenantToCreateIn();
            if (tenantToCreateIn == null) {
                // should not happen as we allways set tenantToCreateIn on SecurityImposer
                for (TenantToUser tenantToUser : securityContext.getUser().getTenantToUsers()) {
                    if (tenantToUser.isDefualtTennant()) {
                        tenantToCreateIn = tenantToUser.getLeftside();
                        break;
                    }

                }
            }

        }

        return newInstance(className, name, securityContext, tenantToCreateIn);

    }

    @Deprecated
    public static <T extends Baseclass> T newInstance(String className, String name, SecurityContext securityContext, Tenant tenant) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException {
        T newInstance;
        Class<T> newClass = (Class<T>) Class.forName(className);
        newInstance = newClass.newInstance();
        newInstance.setName(name);
        newInstance.setCreator(securityContext != null ? securityContext.getUser() : null);
        newInstance.setTenant(tenant);
        Set<String> contextSet = permissionContextMap.get(className);
        if (contextSet != null && !contextSet.isEmpty()) {
            newInstance.setPermissionContext(contextSet.parallelStream().collect(Collectors.joining("|")));

        }
        newInstance.Init();


        return newInstance;

    }

    public static void addClazz(Clazz clazz) {
        String key = clazz.getName();
        if (!allclazzes.containsKey(key)) {
            allclazzes.put(key, clazz);
        }
    }


    public void setParameter1(Object parameter1) {
        // TODO Auto-generated method stub

    }

    public void setParameter2(Object parameter2) {
        // TODO Auto-generated method stub

    }

    public void setParameter3(Object parameter3) {
        // TODO Auto-generated method stub

    }


    public static Clazz getClazzbyname(String canonicalName) {
        return allclazzes.get(canonicalName);

    }


    public OffsetDateTime getUpdateDate() {
        return updateDate;
    }


    public void setUpdateDate(OffsetDateTime updateDate) {
        this.updateDate = updateDate;
    }


    public boolean addCategory(CategoryToBaseClass categoryToBaseClass) {
        return categories.add(categoryToBaseClass);
    }


    @JsonIgnore
    @OneToMany(targetEntity = CategoryToBaseClass.class, mappedBy = "rightside")

    public List<CategoryToBaseClass> getCategories() {
        return categories;
    }


    public void setCategories(List<CategoryToBaseClass> categories) {
        this.categories = categories;
    }

    public static List<Clazz> getAllClazz() {
        return new ArrayList<>(allclazzes.values());
    }



    /**
     * generates UUID from input string , for every run generateUUIDFromString(s)=generateUUIDFromString(s),
     * id is cached to improve performance
     *
     * @param input
     * @return generated/cached id
     */
    public static String generateUUIDFromString(String input) {
        String id = generatedIds.get(input);
        if (id == null) {
            id = UUID.nameUUIDFromBytes(input.getBytes()).toString();
            id = id.replaceAll("-", "");
            id = id.substring(0, 22);

        }
        return id;

    }

    @JsonIgnore
    @OneToMany(targetEntity = SecurityLink.class, mappedBy = "rightside")
    public List<SecurityLink> getSecurityLinks() {
        return securityLinks;
    }

    public void setSecurityLinks(List<SecurityLink> securityLinks) {
        this.securityLinks = securityLinks;
    }

    public static Class<? extends Baseclass> setSimpleName(String simple, Class<? extends Baseclass> clazz) {
        return simpleNameToClass.put(simple, clazz);
    }

    public static Class<? extends Baseclass> getSimpleName(String simple) {
        return simpleNameToClass.get(simple);
    }


    public static void registerSingletone(Baseclass t) {
        singletoneInstances.put(t.getClass(), t);
    }

    public static void registerPermissionContext(String className, String permissionContext) {
        permissionContextMap.computeIfAbsent(className, f -> new ConcurrentSkipListSet<>()).add(permissionContext);
    }

    public static void registerPermissionContext(Class<?> c, String permissionContext) {
        registerPermissionContext(c.getCanonicalName(), permissionContext);
    }

    public static <T extends Baseclass> T create(Class<T> type, String name, SecurityContext securityContext) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Constructor<T> c = type.getConstructor(String.class, SecurityContext.class);
        return c.newInstance(name, securityContext);

    }

    public static <T extends Baseclass> T createUnchecked(Class<T> type, String name, SecurityContext securityContext) {
        try {
            return create(type, name, securityContext);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;

    }


    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }

    public static List<EntityListener> getRegisteredEntityListener(Class<? extends Baseclass> type) {
        return entityListenerCache.computeIfAbsent(type, f -> computeEntityListener(type));
    }

    public static List<EntityListener> computeEntityListener(Class<? extends Baseclass> type) {
        List<EntityListener> list = null;
        for (Class<?> i = type; i != null; i = i.getSuperclass()) {
            Queue<EntityListener> entityListeners = registeredEntityListener.get(i);

            if (entityListeners != null) {
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.addAll(entityListeners);
            }
        }
        return list;
    }

    public static void registerEntityListener(Class<? extends Baseclass> type, EntityListener entityListener) {
        registeredEntityListener.computeIfAbsent(type, f -> new LinkedBlockingQueue<>()).add(entityListener);
        entityListenerCache.clear();
    }

    public boolean isSystemObject() {
        return systemObject;
    }

    public Baseclass setSystemObject(boolean systemObject) {
        this.systemObject = systemObject;
        return this;
    }


    public boolean isDontUpdateUpdateDate() {
        return dontUpdateUpdateDate;
    }

    public <T extends Baseclass> T setDontUpdateUpdateDate(boolean dontUpdateUpdateDate) {
        this.dontUpdateUpdateDate = dontUpdateUpdateDate;
        return (T) this;
    }

    @Column(name = "dtype", insertable = false, updatable = false)
    @FullTextSearchOptions(include = false)

    public String getDtype() {
        return dtype;
    }

    public <T extends Baseclass> T setDtype(String dtype) {
        this.dtype = dtype;
        return (T) this;
    }

    @Lob
    @FullTextSearchOptions(include = false)
    @JsonIgnore
    public String getSearchKey() {
        return searchKey;
    }

    public <T extends Baseclass> T setSearchKey(String searchKey) {
        this.searchKey = searchKey;
        return (T) this;
    }

    @JsonIgnore
    @OneToMany(targetEntity = PermissionGroupToBaseclass.class, mappedBy = "rightside")
    public List<PermissionGroupToBaseclass> getPermissionGroupToBaseclasses() {
        return permissionGroupToBaseclasses;
    }

    public Baseclass setPermissionGroupToBaseclasses(List<PermissionGroupToBaseclass> permissionGroupToBaseclasses) {
        this.permissionGroupToBaseclasses = permissionGroupToBaseclasses;
        return this;
    }

    @Lob
    public String getPermissionContext() {
        return permissionContext;
    }

    public <T extends Baseclass> T setPermissionContext(String permissionContext) {
        this.permissionContext = permissionContext;
        return (T) this;
    }

    @Override
    @Transient
    public boolean isNoSQL() {
        return false;
    }

    @JsonIgnore
    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonConverter.class)
    public Map<String, Object> getJsonNode() {
        return jsonNode;
    }

    @JsonAnyGetter
    public Map<String, Object> any() {
        return jsonNode;
    }

    public <T extends Baseclass> T setJsonNode(Map<String, Object> jsonNode) {
        this.jsonNode = jsonNode;
        return (T) this;
    }

    public static void setOnBaseclassCreated(Consumer<Baseclass> c) {
        if (Baseclass.onBaseclassCreated == null) {
            Baseclass.onBaseclassCreated = c;
        }
    }
}
