package com.cj.net.client;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @ClassName PictureClient
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/24 024 15:33
 * @Version 1.0
 **/
public class PictureClient {
	public static void main(String[] args) throws Exception {
		// 向服务器发送图片
		FileInputStream fileInputStream = new FileInputStream("1.jpg");
		Socket client = new Socket("localhost", 10086);
		OutputStream outputStream = client.getOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fileInputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, len);
		}
		outputStream.flush();
		// 禁用套接字的输出流，任何之前写入的数据都会被发送，相当于告知对方传输完成
		client.shutdownOutput();

		// 接收服务器的响应
		InputStream inputStream = client.getInputStream();
		byte[] result = new byte[1024];
		int length = inputStream.read(result);
		System.out.println(new String(result, 0, length));
		// 禁用套接字的输入流，发送到套接字输入流的任何信息都会被确认然后被静默丢弃。
		client.shutdownInput();

		inputStream.close();
		outputStream.close();
		client.close();
		fileInputStream.close();
	}
}
