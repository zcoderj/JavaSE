package com.cj.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @ClassName UdpServer
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/23 023 11:08
 * @Version 1.0
 **/
public class UdpServer {

	public static void main(String[] args) throws IOException {
		System.out.println("接受端。。。");
		// 1.创建接收端
		DatagramSocket server = new DatagramSocket(7777);
		// 2.准备容器，封装成包裹
		byte[] container = new byte[1024 * 60];
		DatagramPacket datagramPacket = new DatagramPacket(container, 0, container.length);
		// 3.阻塞式接收包裹
		server.receive(datagramPacket);
		// 4.分析数据
		byte[] data = datagramPacket.getData();
		System.out.println(new String(data, 0, datagramPacket.getLength()));
		// 5.释放资源
		server.close();
	}
}
