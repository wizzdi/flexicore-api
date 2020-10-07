package com.flexicore.service;

import com.flexicore.data.jsoncontainers.PluginInformationHolder;
import com.flexicore.data.jsoncontainers.PluginType;
import com.flexicore.interfaces.FlexiCoreService;
import com.flexicore.interfaces.Plugin;
import com.flexicore.model.Job;
import com.flexicore.model.ModuleManifest;
import com.flexicore.model.PluginRequirement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;


public interface PluginService extends FlexiCoreService {
    static Queue<ModuleManifest> externalModules=new ConcurrentLinkedQueue<>();

    /**
     * instantiates all plugin classes of type #pluginType
     * @deprecated replaced by {@link org.pf4j.PluginManager}
     * @param pluginType interface or specific implementation of the required instance
     * @param requirements (optional) map used to set specific versions of the plugins (key should be the canonical class name)
     * @param orderObject (optional) job object containing info to order the resulting instances
     * @return collection of instantiated objects of extending/implementing pluginType
     */
    @Deprecated
    Collection<?> getPlugins(Class<? extends Plugin> pluginType,
                             HashMap<String, PluginRequirement> requirements, Job orderObject);

    /**
     * used to get the loaded entities (jars , files found in the @link {@link com.flexicore.constants.Constants - entitiesFolder} folder)
     * @return a list of objects describing the loaded entities jars
     */
    List<ModuleManifest> getModelListing();

    /**
     * used to get the loaded plugins (jars , files found in the @link {@link com.flexicore.constants.Constants - pluginFolder} folder)
     * @return a list of objects describing the loaded plugin jars
     */
    Set<ModuleManifest> getPluginModuleListing();

    /**
     * @deprecated replaced by {@link org.pf4j.PluginManager}
     * returns a list of loaded plugin classes
     * @return a list of objects describing the loaded plugin classes
     */
    @Deprecated
    List<PluginInformationHolder> getAll();

    /**
     * @deprecated not required
     * cleans instance ( should be called if {@link #getPlugins(Class, HashMap, Job)} was used to create the instance)
     * @param o instance to be cleaned
     * @return true if the cleanup was successful
     */
    @Deprecated
    boolean cleanUpInstance(Object o);

    /**
     * @deprecated replace with {@link org.pf4j.PluginManager}
     * @param type type of plugin
     * @param reqs additional requirements
     * @param <T> type
     * @return instanciated plugin
     */
    @Deprecated
    <T> T instansiate(Class<T> type, Map<String, PluginRequirement> reqs);
    /**
     * reads manifest into structured #ModuleManifest Object
     * @param jar jar containing the manifest
     * @param logger logger used to log status
     * @return module manifest
     */
    ModuleManifest readModule(File jar, Logger logger);

    /**
     * registers as an external Module ( this will return on health checks etc)
     * @param moduleManifest module manifest object
     */
    static void registerExternalModule(ModuleManifest moduleManifest){
        externalModules.add(moduleManifest);
    }

    /**
     * reads manifest and registers as an external Module ( this will return on health checks etc)
     * @param manifestFile path to manifest file
     * @return
     * @throws IOException
     */
    static ModuleManifest registerExternalModule(File manifestFile) throws IOException {
        ModuleManifest moduleManifest=loadExternalModule(manifestFile);
        registerExternalModule(moduleManifest);
        return moduleManifest;
    }

    /**
     * reads manifest into structured #ModuleManifest Object
     * @param manifestFile path to manifest file
     * @return
     * @throws IOException
     */
    static ModuleManifest loadExternalModule(File manifestFile) throws IOException {
        try(FileInputStream fileInputStream=new FileInputStream(manifestFile)){
            return loadExternalModule(manifestFile, fileInputStream);
        }

    }

    /**
     * reads manifest into structured #ModuleManifest Object
     * @param manifestFile path to manifest file
     * @param inputStream input stream with manifest data
     * @return
     * @throws IOException
     */
    static ModuleManifest loadExternalModule(File manifestFile, InputStream inputStream) throws IOException {
        Properties properties=new Properties();
        properties.load(inputStream);
        String uuid=properties.getProperty("uuid","unknown-"+ UUID.randomUUID());
        String version=properties.getProperty("version","unknown-"+UUID.randomUUID());

        return new ModuleManifest(uuid,version,manifestFile.getAbsolutePath(),manifestFile.getAbsolutePath(),new HashSet<>(),new HashSet<>(), PluginType.External);
    }
}
