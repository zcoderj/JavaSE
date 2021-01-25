package com.cj.net;

import java.io.Serializable;
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
		System.out.println(inetAddress);
		System.out.println(InetAddress.getByName("DESKTOP-UFBR45O"));
		System.out.println(inetAddress.getHostName());
		System.out.println(inetAddress.getHostAddress());

		InetAddress inetAddress2 = InetAddress.getByName("www.baidu.com");
		System.out.println(inetAddress2.getHostAddress());
		System.out.println(inetAddress2.getHostName());
	}
}
