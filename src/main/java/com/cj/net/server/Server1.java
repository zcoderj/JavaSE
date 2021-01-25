package com.cj.net.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName Server1
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/24 024 15:19
 * @Version 1.0
 **/
public class Server1 {
	public static void main(String[] args) throws IOException {
		// 服务端需要使用ServerSocket来开放本地的端口
		ServerSocket serverSocket = new ServerSocket(10086);
		// 接收client传输过来的数据，需要定义Socket对象
		Socket server = serverSocket.accept();
		// 通过Socket对象获取输入流
		InputStream inputStream = server.getInputStream();
		// 对输入流进行包装
		DataInputStream dataInputStream = new DataInputStream(inputStream);
		// 读取数据
		String data = dataInputStream.readUTF();
		System.out.println(data);
		// 关闭流
		dataInputStream.close();
		inputStream.close();
		server.close();
		serverSocket.close();
	}
}
