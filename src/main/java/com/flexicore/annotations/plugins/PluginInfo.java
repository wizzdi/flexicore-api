/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.annotations.plugins;

import org.springframework.beans.factory.annotation.Qualifier;

import javax.enterprise.util.Nonbinding;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Qualifier

@Retention(RetentionPolicy.RUNTIME)
public @interface PluginInfo {
	int DEFAULT_ORDER=100;
	int version();
	@Nonbinding boolean autoInstansiate() default false;
	@Nonbinding int order() default DEFAULT_ORDER;



}
