/**
 * 
 */
package com.database_config.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


/**
 * 
 * @author arup.padhi & priyesh.lenka
 *
 */

@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface Init {}
