package org.sun.test.annotations;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({METHOD,ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Required 
{
	boolean value() default true;
}
