package com.cj.net.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @ClassName TcpClient
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/23 023 14:00
 * @Version 1.0
 **/
public class TcpClient {

	public static void main(String[] args) throws IOException {
		System.out.println("Client...");
		// 1.建立连接
		Socket client = new Socket("localhost", 6666);
		// 2.操作
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		dos.writeUTF("hello 你好");
		dos.flush();
		// 3.释放资源
		dos.close();
		client.close();
	}
}
