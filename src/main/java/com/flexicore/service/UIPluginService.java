package com.flexicore.service;

import com.flexicore.data.jsoncontainers.UIComponentRegistrationContainer;
import com.flexicore.data.jsoncontainers.UIComponentsRegistrationContainer;
import com.flexicore.data.jsoncontainers.UIPluginCreationContainer;
import com.flexicore.interfaces.FlexiCoreService;
import com.flexicore.model.FilteringInformationHolder;
import com.flexicore.model.ui.UIComponent;
import com.flexicore.model.ui.plugins.UIInterface;
import com.flexicore.model.ui.plugins.UIPlugin;
import com.flexicore.security.SecurityContext;

import java.util.List;

public interface UIPluginService extends FlexiCoreService {
    List<UIInterface> listUIInterfaces(FilteringInformationHolder filteringInformationHolder, int pageSize, int currentPage, SecurityContext securityContext);

    List<UIPlugin> listUIPluginsByInterface(UIInterface uiInterface, FilteringInformationHolder filteringInformationHolder, int pageSize, int currentPage, SecurityContext securityContext);

    UIPlugin registerUIPlugin(UIPluginCreationContainer uiPluginCreationContainer, SecurityContext securityContext);

    UIInterface createUIInterface(String name, SecurityContext securityContext);

    String getUIInterfaceId(String name);

    List<UIComponent> registerAndGetAllowedUIComponents(List<UIComponentRegistrationContainer> componentsToRegister, SecurityContext securityContext);

    void validate(UIComponentsRegistrationContainer uiComponentsRegistrationContainer);
}
