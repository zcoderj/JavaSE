package com.cj.designpatterns.strategy;

/**
 * @InterfaceName Comparator
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/8 008 09:44
 * @Version 1.0
 **/
public interface Comparator<T> {

	int compare(T o1, T o2);
}
