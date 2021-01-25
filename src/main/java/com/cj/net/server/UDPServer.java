package com.cj.net.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @ClassName UDPServer
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/24 024 16:18
 * @Version 1.0
 **/
public class UDPServer {
	public static void main(String[] args) throws IOException {
		DatagramSocket datagramSocket = new DatagramSocket(10087);
		byte[] data = new byte[1024];
		// 用来接受数据的数据包
		DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
		// 利用创建好的数据包对象来接受数据
		datagramSocket.receive(datagramPacket);
		System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
		datagramSocket.close();
	}
}
