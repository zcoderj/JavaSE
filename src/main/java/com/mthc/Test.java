package com.mthc;

/**
 * @ClassName Test
 * @Description TODO
 * @Author CJ
 * @Date 2020/11/17 017 19:26
 * @Version 1.0
 **/
public class Test {

	public static void main(String[] args) {
//		Map<Integer, Integer> map = new HashMap<>();
//		System.out.println(map.put(1, 1));
//		System.out.println(map.put(1, 2));
//		System.out.println(map.put(2, 2));
//		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < 10_0000; i++) {
			m();
		}

		long start = System.currentTimeMillis();
		for (int i = 0; i < 10_0000; i++) {
			m();
		}
		long end = System.currentTimeMillis();
		System.out.println(end + "-" + start + "=" + (end - start));
	}

	public static void m() {
		for (long i = 0; i < 10_0000L; i++) {
			long j =i % 3;
		}
	}
}
