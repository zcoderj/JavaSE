package com.cj.io;

import java.io.*;
import java.util.Date;

/**
 * @ClassName Test09
 * @Description TODO 对象流
 * @Author CJ
 * @Date 2020/6/20 020 09:58
 * @Version 1.0
 **/
public class Test09 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("object.txt")));

		oos.writeObject("哈哈哈");
		oos.writeObject(new Date());
		oos.writeObject(new User("Make", "123"));
		oos.flush();
		oos.close();

		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("object.txt")));

		Object str = ois.readObject();
		Object date = ois.readObject();
		Object user = ois.readObject();
		ois.close();

		if (str instanceof String) {
			System.out.println((String) str);
		}
		if (date instanceof Date) {
			System.out.println((Date) date);
		}
		if (user instanceof User) {
			User u = (User) user;
			System.out.println(u.getUsername() + "==" + u.getPassword());
		}
	}
}

class User implements Serializable {



	private String username;
	// transient 此项不序列化
	private transient String password;

	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
