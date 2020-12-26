package com.cj.juc;

import java.time.Instant;
import java.util.stream.LongStream;

/**
 * @ClassName TestForkJoin
 * @Description TODO
 * @Author CJ
 * @Date 2020/8/31 031 11:15
 * @Version 1.0
 **/
public class TestForkJoin {
	public static void main(String[] args) {
		Instant start = Instant.now();


		LongStream.rangeClosed(0, 100000000L)
				.parallel() // java8 并行流
				.reduce(0, Long::sum); // 累加
	}
}
