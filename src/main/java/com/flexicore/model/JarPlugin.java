package com.flexicore.model;

import java.io.File;

/**
 * Created by Asaf on 26/02/2017.
 */
public class JarPlugin {

    private File file;
    private ModuleManifest moduleManifest;

    public JarPlugin(File file, ModuleManifest moduleManifest) {
        this.file = file;
        this.moduleManifest = moduleManifest;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public ModuleManifest getModuleManifest() {
        return moduleManifest;
    }

    public void setModuleManifest(ModuleManifest moduleManifest) {
        this.moduleManifest = moduleManifest;
    }
}
