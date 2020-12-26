package com.cj.net.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName TcpServer
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/23 023 14:00
 * @Version 1.0
 **/
public class TcpServer {

	public static void main(String[] args) throws IOException {
		System.out.println("Server...");
		// 1.创建服务器
		ServerSocket server = new ServerSocket(6666);
		// 2.阻塞式等待连接
		Socket client = server.accept();
		// 3.操作
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String data = dis.readUTF();
		System.out.println(data);
		// 4.释放资源
		dis.close();
		client.close();

	}
}
