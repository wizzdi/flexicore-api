package com.flexicore.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface FieldForView {
	String group() default "";
	String validation() default "";
	boolean required() default false;

}
