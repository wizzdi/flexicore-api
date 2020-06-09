package com.flexicore.service;

import com.flexicore.interfaces.Container;
import com.flexicore.interfaces.FlexiCoreService;
import com.flexicore.model.Baseclass;

public interface ContainerService extends FlexiCoreService {
    /**
     * transforms baseclass into contained type , this is usually easily serializable type
     * @param contained baseclass to contain
     * @param <T> anything that extends baseclass
     * @return the contained baseclass
     */
    <T extends Baseclass> Container<T> getContainer(T contained);
}
