package com.flexicore.annotations;

import javax.enterprise.util.Nonbinding;
import javax.interceptor.InterceptorBinding;
import java.lang.annotation.*;

/**
 * Created by Asaf on 18/12/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
@InterceptorBinding
@Target({ElementType.METHOD, ElementType.TYPE})
@Inherited
public @interface Configurable {
    @Nonbinding String uniqueName() default "";
    @Nonbinding String displayName() default "";
    @Nonbinding String propertyDefaultValue() default "";
    @Nonbinding String moldUniqueName() default "";
    @Nonbinding String[] categoriesNames() default "";
}
