package com.cj.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @ClassName UdpClient
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/23 023 11:02
 * @Version 1.0
 **/
public class UdpClient {

	public static void main(String[] args) throws IOException {
		System.out.println("发送端。。。");
		// 1.创建发送端
		DatagramSocket client = new DatagramSocket(6666);
		// 2.准备数据，转成字节数组
		String str = "hello 你好";
		byte[] data = str.getBytes();
		// 3.封装包裹，指定目的地
		DatagramPacket datagramPacket = new DatagramPacket(data, 0, data.length, new InetSocketAddress("localhost", 7777));
		// 4.发送包裹
		client.send(datagramPacket);
		// 5.释放资源
		client.close();
	}
}
