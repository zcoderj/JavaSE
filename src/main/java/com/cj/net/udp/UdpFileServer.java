package com.cj.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @ClassName UdpFileServer
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/23 023 11:24
 * @Version 1.0
 **/
public class UdpFileServer {

	public static void main(String[] args) throws IOException {
		System.out.println("接收端。。。");
		DatagramSocket server = new DatagramSocket(7777);
		byte[] container = new byte[1024 * 60];
		DatagramPacket datagramPacket = new DatagramPacket(container, 0, container.length);
		server.receive(datagramPacket);
		byte[] data = datagramPacket.getData();
		IOUtils.ByteArrayToFile(data, "udp-copy.txt");
		server.close();
	}

}
