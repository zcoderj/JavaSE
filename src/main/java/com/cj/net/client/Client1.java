package com.cj.net.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @ClassName Client1
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/24 024 15:14
 * @Version 1.0
 **/
public class Client1 {
	public static void main(String[] args) throws IOException {
		// 创建Socket对象，其实是开启实现io的虚拟接口
		// 指定数据接收方的ip地址和端口
		Socket client = new   Socket("localhost", 10086);
		// 获取输出流对象，向服务器发送数据
		OutputStream outputStream = client.getOutputStream();
		// 将输出流对象进行封装
		DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
		// 传输数据
		dataOutputStream.writeUTF("hello，你好");
		// 关闭流
		dataOutputStream.close();
		outputStream.close();
		client.close();
	}
}
