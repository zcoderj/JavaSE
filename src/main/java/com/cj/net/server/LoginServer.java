package com.cj.net.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName LoginServer
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/24 024 15:56
 * @Version 1.0
 **/
public class LoginServer {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ServerSocket serverSocket = new ServerSocket(10086);
		while (true) {
			Socket socket = serverSocket.accept();
			LoginThread loginThread = new LoginThread(socket);
			new Thread(loginThread).start();
		}
//		serverSocket.close();
	}
}
