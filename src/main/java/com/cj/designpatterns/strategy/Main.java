package com.cj.designpatterns.strategy;

import java.util.Arrays;

/**
 * @ClassName Main
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/8 008 09:43
 * @Version 1.0
 **/
public class Main {

	public static void main(String[] args) {
		Dog[] dogs = {new Dog(3), new Dog(1), new Dog(4)};
		Cat[] cats = {new Cat(3, 4), new Cat(2, 3), new Cat(1, 5)};
//		Sorter<Dog> sorter1 = new Sorter<>();
//		sorter1.sort(dogs, new DogComparator());
//		System.out.println(Arrays.toString(dogs));

		Sorter<Dog> sorter2 = new Sorter<>();
		sorter2.sort(dogs, (o1, o2) -> o1.height - o2.height);
		System.out.println(Arrays.toString(dogs));

		Sorter<Cat> sorter3 = new Sorter<>();
		sorter3.sort(cats, new CatHeightComparator());
//		sorter3.sort(cats, new CatWeightComparator());
		System.out.println(Arrays.toString(cats));


	}
}
