package me.ifeify.config.annotation;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author ifeify
 */
@BindingAnnotation
@Retention(RUNTIME)
@Target({FIELD, CONSTRUCTOR})
public @interface Redis {
}
