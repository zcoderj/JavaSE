package com.cj.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @ClassName UdpFileClient
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/23 023 11:24
 * @Version 1.0
 **/
public class UdpFileClient {

	public static void main(String[] args) throws IOException {
		System.out.println("发送端。。。");
		DatagramSocket client = new DatagramSocket(6666);
		byte[] data = IOUtils.FileToByteArray("udp.txt");
		DatagramPacket datagramPacket = new DatagramPacket(data, 0, data.length, new InetSocketAddress("localhost", 7777));
		client.send(datagramPacket);
		client.close();
	}
}
