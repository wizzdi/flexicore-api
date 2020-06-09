package com.flexicore.data.jsoncontainers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asaf on 12/07/2017.
 */
public class UIContainerRegistrationContainer  extends UIComponentRegistrationContainer {

   private List<UIComponentRegistrationContainer> components= new ArrayList<>();

    public UIContainerRegistrationContainer() {
    }

    public List<UIComponentRegistrationContainer> getComponents() {
        return components;
    }

    public void setComponents(List<UIComponentRegistrationContainer> components) {
        this.components = components;
    }
}
