package com.cj.net.client;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @ClassName UDPClient
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/24 024 16:10
 * @Version 1.0
 **/
public class UDPClient {
	public static void main(String[] args) throws IOException {
		// 创建UDP通信的数据报套接字
		DatagramSocket datagramSocket = new DatagramSocket(10086);
		// 新建数据报包,数据包是用来实现一个无连接的分组传送服务。
		Scanner scanner = new Scanner(System.in);
		byte[] data = scanner.nextLine().getBytes();
		DatagramPacket datagramPacket = new DatagramPacket(data, data.length, InetAddress.getByName("localhost"), 10087);
		// 发送数据包
		datagramSocket.send(datagramPacket);

		datagramSocket.close();
	}
}
