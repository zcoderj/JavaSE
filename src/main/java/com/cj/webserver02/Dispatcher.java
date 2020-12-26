package com.cj.webserver02;

import com.cj.webserver02.servlet.Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @ClassName Dispatcher
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/24 024 12:07
 * @Version 1.0
 **/
public class Dispatcher implements Runnable {

	private Socket client;
	private Request request;
	private Response response;

	public Dispatcher(Socket client) {
		this.client = client;
		try {
			request = new Request(client);
			response = new Response(client);
		} catch (IOException e) {
			e.printStackTrace();
			this.release();
		}
	}

	private void release() {
		try {
			client.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			String url = request.getUrl();
			if (url == null || url.length() == 0) {
				InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("index.html");
				byte[] datas = new byte[1024 * 1024];
				int len = is.read(datas);
				response.print((new String(datas, 0, len)));
				is.close();
				return;
			}
			Servlet servlet = WebApp.getServletByUrl(url);
			if (null != servlet) {
				servlet.service(request, response);
				//关注了状态码
				response.pushToBrowser(200);
			} else {
				//错误....
				InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("error.html");
				byte[] datas = new byte[1024 * 1024];
				int len = is.read(datas);
				response.print((new String(datas, 0, len)));
				response.pushToBrowser(404);
				is.close();
			}
		} catch (Exception e) {
			try {
				response.println("服务器繁忙。。。");
				response.pushToBrowser(500);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		release();
	}
}
