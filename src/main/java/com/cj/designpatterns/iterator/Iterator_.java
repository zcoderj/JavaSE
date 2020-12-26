package com.cj.designpatterns.iterator;

/**
 * @InterfaceName Iterator_
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/13 013 20:12
 * @Version 1.0
 **/
public interface Iterator_<E> {

	boolean hasNext();

	E next();
}
