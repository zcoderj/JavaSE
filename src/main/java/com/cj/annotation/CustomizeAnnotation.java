package com.cj.annotation;

import java.lang.annotation.*;

/**
 * @ClassName CustomizeAnnotation
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/25 025 13:23
 * @Version 1.0
 **/

@MyAnnotation1
public class CustomizeAnnotation {

}


@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
// 表示当前注解能够被继承，即当 @MyAnnotation1 加载某个类A上时，加入类B继承了A，则B也会带上该注解。
@Inherited
@interface MyAnnotation1 {
	String name() default "zs";
	int age() default 18;
}
