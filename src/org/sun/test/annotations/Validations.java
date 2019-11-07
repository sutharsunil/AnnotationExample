/**
 * 
 */
package org.sun.test.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target(METHOD)
/**
 * @author win
 *
 */
public @interface Validations 
{
	String name() default "ValidateMe";
	int min() default 0;
	int max() default Integer.MAX_VALUE;
	int minLength() default 1;
	int maxLength() default Integer.MAX_VALUE;
	boolean isnull() default false;
	Required required();
	
}
