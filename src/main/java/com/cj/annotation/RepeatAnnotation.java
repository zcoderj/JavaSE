package com.cj.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

/**
 * @ClassName RepeatAnnotation
 * @Description TODO
 * @Author CJ
 * @Date 2020/8/27 027 10:35
 * @Version 1.0
 **/
public class RepeatAnnotation {

	@MyAnnotation("Hello")
	@MyAnnotation("World")
	public void show(@MyAnnotation("hi") String str) {

	}
}

@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotations {
	MyAnnotation[] value();
}

@Repeatable(MyAnnotations.class)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
	String value() default "hello";
}
