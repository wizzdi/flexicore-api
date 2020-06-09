/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * used to define default links of default objects, for example, it is used to link Admin Role with all operations with full permit.
 * it is used when an instance is created when the system is initialized and needs to be linked to
 * other instances already created or yet to be created. For example:
 * When an operation is created (see:registerOperationsInclass) it is automatically linked with Roles.
 * @author Avishay Ben Natan
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoLink {
	/**
	 * the name of the link
	 * @return
	 */
	String[] Name() default "";

	String[] Description() default "";
	/**
	 * define left link , if not empty, the created instance will go to right
	 * @return
	 */
	String[] LeftID() default "";
	/**
	 * define right link, if not empty, the created instance will go to left.
	 * @return
	 */
	String[] RightID() default "";
	String[] LinkClassName() default "";
	String[] value() default "";
	
}
