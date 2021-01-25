package com.cj.net.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName Server2
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/24 024 15:28
 * @Version 1.0
 **/
public class Server2 {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(10086);
		Socket server = serverSocket.accept();
		// 接收客户端数据
		InputStream inputStream = server.getInputStream();
		byte[] buffer = new byte[1024];
		int length = inputStream.read(buffer);
		System.out.println(new String(buffer, 0, length));
		// 向客户端响应数据
		OutputStream outputStream = server.getOutputStream();
		outputStream.write("hello client".getBytes());

		outputStream.close();
		inputStream.close();
		server.close();
		serverSocket.close();
	}
}
