package com.cj.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName StreamDemo
 * @Description TODO
 * @Author CJ
 * @Date 2021/1/25 025 13:44
 * @Version 1.0
 **/
public class StreamDemo {
	public static void main(String[] args) {
		// Stream的生成操作

		// 通过数组生成
//		Integer[] arr1 = {1, 2, 3};
//		Stream<Integer> s1 = Stream.of(arr1);
//		s1.forEach(System.out::println);

		// 通过集合生成
//		List<Integer> list1 = Arrays.asList(1, 2, 3);
//		Stream<Integer> s2 = list1.stream();
//		s2.forEach(System.out::println);

		// 通过generate方法生成
//		Stream<Integer> s3 = Stream.generate(() -> 1);
//		// 不加limit将会无限输出 1
//		s3.limit(5).forEach(System.out::println);

		// 通过iterate方法生成
//		Stream<Integer> s4 = Stream.iterate(1, x -> x + 1);
//		s4.limit(5).forEach(System.out::println);

		// 其他方式
//		String str1 = "abc";
//		IntStream is1 = str1.chars();
//		is1.forEach(System.out::println);


		// 中间操作：若调用方法之后返回的结果是Stream对象，则意味着施一个中间操作

		// 输出集合中所有偶数
//		Arrays.asList(1, 2, 3, 4, 5).stream().filter(x -> x % 2 == 0).forEach(System.out::println);

		// 求集合中所有偶数的和
//		int sum = Arrays.asList(1, 2, 3, 4, 5).stream().filter(x -> x % 2 == 0).mapToInt(x -> x).sum();
//		System.out.println(sum);

		List<Integer> list2 = Arrays.asList(5, 2, 2, 3);

		// 求集合中的最大值
//		Optional<Integer> max = list2.stream().max((a, b) -> a - b);
//		System.out.println(max.get());

		// 求集合中最小值
//		System.out.println(list2.stream().min((a, b) -> a - b).get());

		// 取任意一个值
		// 如果是数据较少，串行地情况下，一般会返回第一个结果，如果是并行的情况，那就不能确保是第一个。
//		System.out.println(list2.stream().findAny().get());
//		System.out.println(list2.stream().parallel().findAny().get());

		// 取第一个值
//		System.out.println(list2.stream().parallel().findFirst().get());

//		Stream<Integer> s3 = list2.stream().filter(x -> {
//			System.out.println("运行代码");
//			return x % 2 == 0;
//		});
//		System.out.println(s3.findFirst().get());

		// 获取最大值和最小值，但是不使用min和max方法
//		System.out.println(list2.stream().sorted().findFirst().get()); // 最小
//		System.out.println(list2.stream().sorted((a, b) -> b - a).findFirst().get()); // 最大

//		List<String> list3 = Arrays.asList("java", "c#", "python", "scala");
//		list3.stream().sorted().forEach(System.out::println);
//		list3.stream().sorted((a, b) -> a.length() - b.length()).forEach(System.out::println);

		// 将集合中的元素进行过滤，然后返回一个集合对象
//		List<Integer> collect = list2.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
//		collect.forEach(System.out::println);

		// 去重操作
//		list2.stream().distinct().forEach(System.out::println);

		// 打印20-30这样的集合数据，skip：跳过20个
//		Stream.iterate(1, x -> x + 1).limit(50).skip(20).limit(10).forEach(System.out::println);
		// 或
//		Stream.iterate(21, x -> x + 1).limit(10).forEach(System.out::println);

//		String str2 = "1,2,3,4,5";
//		System.out.println(Stream.of(str2.split(",")).mapToInt(x -> Integer.valueOf(x)).sum());
//		System.out.println(Stream.of(str2.split(",")).mapToInt(Integer::valueOf).sum());
//		System.out.println(Stream.of(str2.split(",")).map(x -> Integer.valueOf(x)).mapToInt(x -> x).sum());
//		System.out.println(Stream.of(str2.split(",")).map(Integer::valueOf).mapToInt(x -> x).sum());

		// 创建一组自定义对象
		String str3 = "java,c#,python";
//		Stream.of(str3.split(",")).map(x -> new Language(x)).forEach(System.out::println);
//		Stream.of(str3.split(",")).map(Language::new).forEach(System.out::println);
//		Stream.of(str3.split(",")).map(x -> Language.build(x)).forEach(System.out::println);
//		Stream.of(str3.split(",")).map(Language::build).forEach(System.out::println);

		String str4 = "1,2,3";
		// 将str4中的每一个数组打印出来，同时算出最终的求和结果
		// peek(Consumer<? super T> action)：在处理流过程中对元素做一些处理等
//		System.out.println(Stream.of(str4.split(",")).peek(System.out::println).mapToInt(Integer::valueOf).sum());

		// 所有元素都满足某条件返回true
		System.out.println(list2.stream().allMatch(x -> x >= 2));
		// 任意一个元素满足某条件true
		System.out.println(list2.stream().anyMatch(x -> x <= 0));
	}
}

class Language {
	public String name;

	public Language() {
	}

	public Language(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Language{" +
				"name='" + name + '\'' +
				'}';
	}

	public static Language build(String name) {
		return new Language(name);
	}
}
