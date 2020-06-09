package com.flexicore.data.jsoncontainers;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CrossLoaderResolver extends TypeIdResolverBase {

    private static Map<String, Class<?>> types = new HashMap<>();
    private JavaType superType;

    @Override
    public void init(JavaType baseType) {
        superType = baseType;
    }


    @Override
    public String idFromValue(Object obj) {
        return idFromValueAndType(obj, obj.getClass());
    }

    @Override
    public JavaType typeFromId(DatabindContext context, String id) throws IOException {
        Class<?> c = types.get(id);
        if(c==null){
            try {
                c= Class.forName(id,false,superType.getRawClass().getClassLoader());
            } catch (ClassNotFoundException e) {
                throw new IOException("could not find type "+id,e);
            }
        }

        return context.getTypeFactory().withClassLoader(c.getClassLoader()).constructSpecializedType(superType,c);
    }

    @Override
    public String idFromValueAndType(Object obj, Class<?> subType) {
        return subType.getCanonicalName();
    }

    @Override
    public JsonTypeInfo.Id getMechanism() {
        return JsonTypeInfo.Id.CLASS;
    }

    public static void registerClass(Class<?> c){
        types.put(c.getCanonicalName(),c);
    }

    public static void registerClass(Class<?>... c){
        for (Class<?> aClass : c) {
            types.put(aClass.getCanonicalName(),aClass);
        }
    }

    public static Class<?> getRegisteredClass(String classFullName) {
        return types.computeIfAbsent(classFullName,f-> getClass(classFullName));
    }

    private static Class<?> getClass(String classFullName) {
        try {
            return Class.forName(classFullName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
