package com.cj.net.server;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName PictureServer
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/24 024 15:45
 * @Version 1.0
 **/
public class PictureServer {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(10086);
		Socket server = serverSocket.accept();
		// 接受客户端上传的图片
		InputStream inputStream = server.getInputStream();
		byte[] buffer = new byte[1024];
		FileOutputStream fileOutputStream = new FileOutputStream("client.jpg");
		int len = 0;
		while ((len = inputStream.read(buffer)) != -1) {
			fileOutputStream.write(buffer, 0, len);
		}
		fileOutputStream.flush();
		server.shutdownInput();
		// 响应数据
		OutputStream outputStream = server.getOutputStream();
		outputStream.write("图片接收成功".getBytes());

		outputStream.close();
		fileOutputStream.close();
		inputStream.close();
		server.close();
		serverSocket.close();
	}
}
