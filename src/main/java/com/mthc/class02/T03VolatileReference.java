package com.mthc.class02;

/**
 * @ClassName T03VolatileReference
 * @Description TODO volatile 修饰引用类型（包括数组）时，只能保证引用本省的可见性，并不能保证内部字段的可见性
 * @Author CJ
 * @Date 2020/11/21 021 08:46
 * @Version 1.0
 **/
public class T03VolatileReference {
	private static class Data {
		int a;
		int b;

		public Data(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	volatile static Data data;

	public static void main(String[] args) {
		Thread writer = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				data = new Data(i, i);
			}
		});

		Thread reader = new Thread(() -> {
			while (data == null) {
			}
			int x = data.a;
			int y = data.a;
			if (x != y) {
				System.out.printf("a = %s,b = %s%n", x, y);
			}
		});

		writer.start();
		reader.start();

		try {
			writer.join();
			reader.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("end");
	}
}
