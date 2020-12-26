package com.cj.net.udp;

/**
 * @ClassName UdpTalkTeacher
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/23 023 12:52
 * @Version 1.0
 **/
public class UdpTalkTeacher {

	public static void main(String[] args) {

		// 接收
		new Thread(new UdpTalkReceive(7777, "学生")).start();
		// 发送
		new Thread(new UdpTalkSend(8888, "localhost", 5555)).start();
	}
}
