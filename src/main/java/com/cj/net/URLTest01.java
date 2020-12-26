package com.cj.net;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ClassName URLTest01
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/22 022 22:14
 * @Version 1.0
 **/
public class URLTest01 {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://www.baidu.com:80/index.html?username=cj&account=123#a");
		System.out.println("协议：" + url.getProtocol());
		System.out.println("域名/IP：" + url.getHost());
		System.out.println("端口：" + url.getPort());
		System.out.println("资源1：" + url.getFile());
		System.out.println("资源2：" + url.getPath());
		System.out.println("参数：" + url.getQuery());
		System.out.println("锚点：" + url.getRef());
	}
}
