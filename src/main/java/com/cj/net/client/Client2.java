package com.cj.net.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @ClassName Client2
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/24 024 15:23
 * @Version 1.0
 **/
public class Client2 {
	public static void main(String[] args) throws IOException {
		Socket client = new Socket("127.0.0.1", 10086);
		// 向服务端发送数据
		OutputStream outputStream = client.getOutputStream();
		outputStream.write("hello server".getBytes());
		// 接收服务端数据
		InputStream inputStream = client.getInputStream();
		byte[] data = new byte[1024];
		int length = inputStream.read(data);
		System.out.println(new String(data, 0, length));

		inputStream.close();
		outputStream.close();
		client.close();
	}
}
