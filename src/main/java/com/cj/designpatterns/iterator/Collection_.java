package com.cj.designpatterns.iterator;

/**
 * @InterfaceName Collection_
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/13 013 20:13
 * @Version 1.0
 **/
public interface Collection_<E> {

	void add(E e);

	int size();

	Iterator_<E> iterator();
}
