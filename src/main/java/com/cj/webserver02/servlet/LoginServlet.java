package com.cj.webserver02.servlet;

import com.cj.webserver02.Request;
import com.cj.webserver02.Response;

/**
 * @ClassName LoginServlet
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/23 023 21:19
 * @Version 1.0
 **/
public class LoginServlet implements Servlet {
	@Override
	public void service(Request request, Response response) {

		response.print("<html>");
		response.print("<head>");
		response.print("<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\" charset=\"UTF-8\">");
		response.print("<title>");
		response.print("服务器响应");
		response.print("</title>");
		response.print("</head>");
		response.print("<body>");
		String[] hobbies = request.getParameterValues("hobby");
		response.print("回来了==" + request.getMethod() + "==" + request.getUrl() + "==" +
				request.getParameter("username") + "==" + hobbies[0] + "==" + hobbies[1] + "==" + request.getParameter("age"));
		response.print("</body>");
		response.print("</html>");
	}
}
