package com.cj.net;

import java.net.InetSocketAddress;

/**
 * @ClassName InetSocketAddress
 * @Description TODO ip ==> 两个字节 0~65536
 * @Author CJ
 * @Date 2020/6/22 022 22:02
 * @Version 1.0
 **/
public class InetSocketAddressTest {

	public static void main(String[] args) {
//		InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8080);
		InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 8080);
		System.out.println(inetSocketAddress.getAddress());
		System.out.println(inetSocketAddress.getHostName());
		System.out.println(inetSocketAddress.getPort());
	}
}
