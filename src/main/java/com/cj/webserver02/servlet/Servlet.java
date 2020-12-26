package com.cj.webserver02.servlet;

import com.cj.webserver02.Request;
import com.cj.webserver02.Response;

/**
 * @InterfaceName Servlet
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/23 023 21:21
 * @Version 1.0
 **/
public interface Servlet {

	void service(Request request, Response response);
}
