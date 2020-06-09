/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.constants;

import com.flexicore.model.Baseclass;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Constants {

    public static final String HTTP_ACCESS_CONTROL_ALLOW_ORIGIN ="*" ;
    public static final InheritanceType INHERITANCE_TYPE= Baseclass.class.getAnnotation(Inheritance.class).strategy();
	public static  boolean JDK8 = Double.parseDouble(System.getProperty("java.specification.version")) <1.9;
    public static boolean HTTPS_ACTIVE = false;
	public static  long CONFIG_PROPERTY_CACHE_SIZE = 1000L;


	public static String UPLOAD_PATH="/home/flexicore/upload/";
	public static String PLUGIN_PATH="/home/flexicore/plugins";
	public static String ENTITIES_PATH="/home/flexicore/entities";
	public static String OUTPUT_PATH=UPLOAD_PATH;
	public static String UPLOAD_URL="/rest/download/";
	public static String USERS_ROOT_DIRECTORY="/home/flexicore/users/";
	public static String SEPERATOR= File.separator;
	public static String PUBLIC_KEY="/home/flexicore/license/public.key";
	public static String FIRST_RUN_FILE="/home/flexicore/firstRun.txt";

	public static long FILE_CLEAN_INTERVAL=60*60*1000;//60*60*1000*24; //day
	public static String jwtTokenSecretLocation ="/home/flexicore/jwt.secret";
	public static long JWTSecondsValid =24*60*60; // one day
	public static boolean enableHTTPErrorLog=true;
	public static int maxHTTPLoggingBodyCharLength=100*1000;
	public static int verificationLinkValidInMin=30;
	public static int userCacheMaxSize=10;

	public static final String systemAdminId="UEKbB6XlQhKOtjziJoUQ8w";

	public static String keySetFilePath="/home/flexicore/keyset.json";
	public static boolean showExceptionsInHttpResponse=false;
	public static String hiddenHttpExceptionMessage="Contact Your System Administrator";
	public static Set<String> commaDelimitedWhiteListIpsForUnsecureApis=new HashSet<>(Arrays.asList("*"));
	public static String timeShiftLocation ="/home/flexicore/timeshift";
	public static String adminEmail="admin@flexicore.com";

}
