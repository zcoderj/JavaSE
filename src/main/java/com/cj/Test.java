package com.cj;

import com.sun.istack.internal.NotNull;
import com.sun.java.accessibility.util.TopLevelWindowListener;
import sun.print.SunMinMaxPage;
import sun.reflect.generics.scope.MethodScope;

import java.io.ObjectOutputStream;
import java.net.SocketTimeoutException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @ClassName Test
 * @Description TODO
 * @Author CJ
 * @Date 2020/8/12 012 23:29
 * @Version 1.0
 **/
public class Test {

	public static void main(String[] args) {



//		DateTimeFormatter dtf = DateTimeFormatter.ISO_TIME;
//		LocalDateTime ldt = LocalDateTime.now();
//		String str = dtf.format(ldt);
//		System.out.println(str);
//		System.out.println("===");
//		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss");
//		String str2 = dtf2.format(ldt);
//		System.out.println(str2);
//
//		LocalDateTime ldt2 = LocalDateTime.parse(str2, dtf2);
//		System.out.println(ldt2);
//
//		ThreadLocal<String> tl = new ThreadLocal<>();
//		tl.set("haha");
//		tl.remove();

//		LocalDateTime start = LocalDateTime.now();
//
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		LocalDateTime end = LocalDateTime.now();
//		// 获取时间间隔
//		Duration duration = Duration.between(start, end);
//		System.out.println(duration.toMillis());

//		System.out.println(Instant.now().toEpochMilli());


//		System.out.println(Integer.toBinaryString(-1));

//		Integer a = new Integer(1);
//		int b = 1;
//		System.out.println(a == b);
//
//		Integer c = new Integer(200);
//		int d = 200;
//		System.out.println(c == d);

//		List list = new ArrayList();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//
//		System.out.println(list.indexOf(null));

		Stream<Integer> iterate = Stream.iterate(2, n -> n + 1);
		iterate.limit(5).forEach(System.out::println);

	}

}
