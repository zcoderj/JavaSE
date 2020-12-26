package com.cj.io;

import java.io.*;

/**
 * @ClassName Test08
 * @Description TODO 数据流
 * @Author CJ
 * @Date 2020/6/20 020 09:43
 * @Version 1.0
 **/
public class Test08 {

	public static void main(String[] args) throws IOException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		DataOutputStream dos = new DataOutputStream(baos);
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));

		dos.writeUTF("haha");
		dos.writeInt(18);
		dos.writeChar('a');
		dos.writeBoolean(true);
		dos.flush();

		byte[] data = baos.toByteArray();
		System.out.println("data.length:" + data.length);
		System.out.println(data[4]);

		DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(data)));
		System.out.println(dis.readUTF());
		System.out.println(dis.readInt());
		System.out.println(dis.readChar());
		System.out.println(dis.readBoolean());
	}
}
