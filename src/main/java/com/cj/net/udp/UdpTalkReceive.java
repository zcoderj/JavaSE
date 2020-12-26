package com.cj.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @ClassName UdpTalkReceive
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/23 023 12:39
 * @Version 1.0
 **/
public class UdpTalkReceive implements Runnable {

	private DatagramSocket receive;
	private String from;

	public UdpTalkReceive(int port, String from) {
		this.from = from;
		try {
			receive = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		while (true) {
			// 准备容器，封装成包裹
			byte[] container = new byte[1024 * 60];
			DatagramPacket datagramPacket = new DatagramPacket(container, 0, container.length);
			try {
				// 阻塞式接收包裹
				receive.receive(datagramPacket);
				// 处理接受的数据
				byte[] datas = datagramPacket.getData();
				String data = new String(datas, 0, datagramPacket.getLength());
				System.out.println(from + ": " + data);
				if ("bye".equals(data)) {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 释放资源
		receive.close();
	}
}
