package com.cj.webserver02.servlet;

import com.cj.webserver02.Request;
import com.cj.webserver02.Response;

/**
 * @ClassName RegisterServlet
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/23 023 21:19
 * @Version 1.0
 **/
public class RegisterServlet implements Servlet {
	@Override
	public void service(Request request, Response response) {

		response.print("hahhaha哈哈哈");
	}
}
