package com.flexicore.service;

import com.flexicore.data.jsoncontainers.UIComponentRegistrationContainer;
import com.flexicore.data.jsoncontainers.UIComponentsRegistrationContainer;
import com.flexicore.interfaces.FlexiCoreService;
import com.flexicore.model.ui.UIComponent;
import com.flexicore.security.SecurityContext;

import java.util.List;

public interface UIComponentService extends FlexiCoreService {

    List<UIComponent> registerAndGetAllowedUIComponents(List<UIComponentRegistrationContainer> componentsToRegister, SecurityContext securityContext);

    void validate(UIComponentsRegistrationContainer uiComponentsRegistrationContainer);
}
