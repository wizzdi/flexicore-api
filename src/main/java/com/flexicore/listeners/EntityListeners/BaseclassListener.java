package com.flexicore.listeners.EntityListeners;

import com.flexicore.annotations.FullTextSearch;
import com.flexicore.annotations.FullTextSearchOptions;
import com.flexicore.interfaces.EntityListener;
import com.flexicore.model.Baseclass;
import com.flexicore.model.Baseclass_;
import com.flexicore.utils.DateUtils;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.eclipse.persistence.descriptors.DescriptorEventAdapter;

import javax.persistence.*;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Asaf on 01/08/2016.
 */

public class BaseclassListener extends DescriptorEventAdapter {
    /**
     * Created by Asaf on 01/08/2016.
     */


    private static final Map<String, Boolean> freeTextSuportMap = new ConcurrentHashMap<>();

    private static Logger logger= Logger.getLogger(BaseclassListener.class.getCanonicalName());

    //FC hook to keep searchKey,updateDate and creationDate corrent

    @Override
    public void aboutToInsert(DescriptorEvent event) {
        preWrite(event.getObject(),event);
        super.aboutToInsert(event);
    }

    @Override
    public void aboutToUpdate(DescriptorEvent event) {
        preWrite(event.getObject(),event);
        super.aboutToUpdate(event);
    }

    //callback hook

    @Override
    public void preUpdate(DescriptorEvent event) {
        preUpdate(event.getObject());
        super.preUpdate(event);
    }

    @Override
    public void preInsert(DescriptorEvent event) {
        preInsert(event.getObject());
        super.preInsert(event);
    }




    @Override
    public void postInsert(DescriptorEvent event) {
        postInsert(event.getObject());
        super.postInsert(event);
    }

    @Override
    public void postUpdate(DescriptorEvent event) {
        postUpdate(event.getObject());
        super.postUpdate(event);
    }






    private void handleTextSearch(Baseclass b, DescriptorEvent descriptorEvent) {
        try {
            if (isFreeTextSupport(b.getClass())) {
                String freeText= Stream.of( Introspector.getBeanInfo(b.getClass(), Object.class).getPropertyDescriptors()).filter(this::isPropertyForTextSearch).map(PropertyDescriptor::getReadMethod).filter(this::isIncludeMethod).map(f-> invoke(b, f)).filter(Objects::nonNull).map(f->f+"").filter(f->!f.isEmpty()).collect(Collectors.joining("|"));
                b.setSearchKey(freeText);
                descriptorEvent.getRecord().put(Baseclass_.searchKey.getName().toUpperCase(),freeText);
                logger.fine("Free Text field for "+b.getId() +" is set");

            }
        }

        catch (Exception e){
            logger.log(Level.SEVERE,"unable to set free text field",e);
        }
    }

    private boolean isPropertyForTextSearch(PropertyDescriptor f) {
        return propertyTypes.contains(f.getPropertyType());
    }

    private static final Set<Class<?>> propertyTypes= Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            String.class,
            int.class,
            double.class,
            float.class,
            int.class,
            long.class,
            short.class,
            Double.class,
            Float.class,
            Integer.class,
            Long.class,
            Short.class

    )));


    private Object invoke(Baseclass b, Method f) {
        try {
            return f.invoke(b);
        } catch (IllegalAccessException | InvocationTargetException e) {
            logger.log(Level.SEVERE,"unable to invoke method",e);
        }
        return null;
    }

    private boolean isIncludeMethod(Method f) {
        if(f==null||f.isAnnotationPresent(Transient.class)){
            return false;
        }
        FullTextSearchOptions fullTextSearchOptions=f.getAnnotation(FullTextSearchOptions.class);

        return fullTextSearchOptions==null||fullTextSearchOptions.include();
    }

    private boolean isFreeTextSupport(Class<? extends Baseclass> aClass) {
        return freeTextSuportMap.computeIfAbsent(aClass.getCanonicalName(),f-> checkFreeTextSupport(aClass));
    }

    private boolean checkFreeTextSupport(Class<? extends Baseclass> aClass) {
        FullTextSearch annotation = aClass.getAnnotation(FullTextSearch.class);
        return annotation!=null&&annotation.supported();
    }

    private void updateUpdateDate(OffsetDateTime now, Baseclass b,DescriptorEvent descriptorEvent) {
        if (!b.isDontUpdateUpdateDate()) {
            b.setUpdateDate(now);
            descriptorEvent.getRecord().put(Baseclass_.updateDate.getName().toUpperCase(),now);
        } else {
            b.setDontUpdateUpdateDate(false);
            logger.fine("Did not update " + b.getId() + " update date");
        }
    }

    private String getStackTraceString(Baseclass baseclass) {


        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        return Arrays.stream(stackTraceElements).map(StackTraceElement::toString).reduce((s1, s2) -> s1 + "\n" + s2).orElse("");


    }


    public void preWrite(Object o,DescriptorEvent descriptorEvent) {
        if (o instanceof Baseclass) {
            Baseclass b = (Baseclass) o;
            if(logger.isLoggable(Level.FINE)){
                logger.fine("Pre Write Called on "+b.getId() +" stack trace: "+getStackTraceString(b));
            }

            OffsetDateTime now = DateUtils.millisFloor(OffsetDateTime.now());
            handleTextSearch(b,descriptorEvent);
            if (b.getCreationDate() == null) {
                b.setCreationDate(now);
                descriptorEvent.getRecord().put(Baseclass_.creationDate.getName().toUpperCase(), now);
            }
            updateUpdateDate(now, b,descriptorEvent);

        }

    }


    public void preInsert(Object object) {
        if(object instanceof Baseclass){
            Baseclass b= (Baseclass) object;
            if(logger.isLoggable(Level.FINE)){
                logger.fine("Pre Insert Called on "+b.getId() +" stack trace: "+getStackTraceString(b));
            }
            List<EntityListener> entityListeners = Baseclass.getRegisteredEntityListener(b.getClass());

            if (entityListeners != null) {
                for (EntityListener entityListener : entityListeners) {
                    entityListener.prePersist(b);
                }
            }
        }
    }

    public void preUpdate(Object object) {
        if(object instanceof Baseclass){
            Baseclass b= (Baseclass) object;
            if(logger.isLoggable(Level.FINE)){
                logger.fine("Pre Update Called on "+b.getId() +" stack trace: "+getStackTraceString(b));
            }
            List<EntityListener> entityListeners = Baseclass.getRegisteredEntityListener(b.getClass());

            if (entityListeners != null) {
                for (EntityListener entityListener : entityListeners) {
                    entityListener.preUpdate(b);
                }
            }
        }
    }

    public void postInsert(Object object) {
        if(object instanceof Baseclass){
            Baseclass b= (Baseclass) object;
            if(logger.isLoggable(Level.FINE)){
                logger.fine("Post Insert Called on "+b.getId() +" stack trace: "+getStackTraceString(b));
            }
            List<EntityListener> entityListeners = Baseclass.getRegisteredEntityListener(b.getClass());

            if (entityListeners != null) {
                for (EntityListener entityListener : entityListeners) {
                    entityListener.postPersist(b);
                }
            }
        }
    }

    public void postUpdate(Object object) {
        if(object instanceof Baseclass){
            Baseclass b= (Baseclass) object;
            if(logger.isLoggable(Level.FINE)){
                logger.fine("Post Update Called on "+b.getId() +" stack trace: "+getStackTraceString(b));
            }
            List<EntityListener> entityListeners = Baseclass.getRegisteredEntityListener(b.getClass());

            if (entityListeners != null) {
                for (EntityListener entityListener : entityListeners) {
                    entityListener.postUpdate(b);
                }
            }
        }
    }
}
