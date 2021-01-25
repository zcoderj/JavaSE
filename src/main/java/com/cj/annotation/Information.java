package com.cj.annotation;

import com.cj.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface Information {

	int id() default -1;

	String[] name() default "";
}
