package com.cj.thread;

/**
 * @ClassName DoubleCheckedLocking
 * @Description TODO DCL单例模式
 * @Author CJ
 * @Date 2020/6/22 022 13:47
 * @Version 1.0
 **/
public class DoubleCheckedLocking {

	// 若没有volatile关键字，其他线程可能返回的是一个没有初始化的对象
	// 原因就是对象的新建过程可能存在指令重排（步骤3在步骤2之前执行）
	private static volatile DoubleCheckedLocking instance;

	private DoubleCheckedLocking() {
	}

	public static DoubleCheckedLocking getInstance() {
		if (instance !=  null) {
			return instance;
		}
		synchronized (DoubleCheckedLocking.class) {
			if (instance == null) {
				instance = new DoubleCheckedLocking();
				// 对象创建过程
				// 1.开辟空间
				// 2.初始化对象信息
				// 3.返回对象地址给引用
			}
		}
		return instance;
	}
}
