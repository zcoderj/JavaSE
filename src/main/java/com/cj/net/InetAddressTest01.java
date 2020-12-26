package com.cj.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ClassName InetAddressTest01
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/22 022 21:37
 * @Version 1.0
 **/
public class InetAddressTest01 {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress inetAddress = InetAddress.getLocalHost();
		System.out.println(inetAddress.getHostAddress());
		System.out.println(inetAddress.getHostName());

//		InetAddress inetaddress = InetAddress.getByName("www.baidu.com");
//		System.out.println(inetaddress.getHostAddress());
//		System.out.println(inetaddress.getHostName());

//		InetAddress inetAddress = InetAddress.getByName("14.215.177.38");
//		System.out.println(inetAddress.getHostAddress());
//		System.out.println(inetAddress.getHostName());
	}
}
