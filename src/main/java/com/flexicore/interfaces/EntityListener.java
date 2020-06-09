package com.flexicore.interfaces;


/**
 * Created by Asaf on 28/07/2017.
 */
public interface EntityListener extends Plugin {

        void prePersist(Object o);


        void postPersist(Object o);


        void preRemove(Object o);


        void postRemove(Object o);


        void preUpdate(Object o);


        void postUpdate(Object o);


        void postLoad(Object o);



}
