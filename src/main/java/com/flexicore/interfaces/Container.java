package com.flexicore.interfaces;

/**
 * Created by Asaf on 13/11/2016.
 */
public interface Container<T>  extends ServicePlugin{

    Container<T> contain(T toContain);
    Class<T> getType();
}
