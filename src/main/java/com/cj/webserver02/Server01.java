package com.cj.webserver02;

import com.cj.webserver02.servlet.LoginServlet;
import com.cj.webserver02.servlet.RegisterServlet;
import com.cj.webserver02.servlet.Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName Server01
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/24 024 07:13
 * @Version 1.0
 **/
public class Server01 {

	private ServerSocket serverSocket;
	private boolean isRunning;

	public static void main(String[] args) {
		Server01 server = new Server01();
		server.start();
	}

	public void start() {
		try {
			serverSocket = new ServerSocket(8888);
			isRunning = true;
			receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器启动失败。。。");
			stop();
		}
	}

	/**
	 * 处理请求
	 */
	public void receive() {
		while (isRunning) {
			try {
				Socket client = serverSocket.accept();
				System.out.println("一个客户端建立了连接。。。");
				// 多线程处理
				new Thread(new Dispatcher(client)).start();

			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("客户端错误。。。");
			}
		}

	}

	private void stop() {
		isRunning = false;
		try {
			serverSocket.close();
			System.out.println("服务器停止。。。");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
