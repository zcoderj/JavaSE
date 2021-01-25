package com.cj.enumTest;

public enum Season {

	Spring("桃花"), Summer("荷花"), Autumn("菊花"), Winter("梅花");

	private String flower;

	Season(String flower) {
		this.flower = flower;
	}

	public void show() {
		System.out.println(this.flower);
	}
}

enum Day {
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY,
	SUNDAY
}

class EnumTest {
	public static void main(String[] args) {
		Season spring = Season.Spring;
		spring.show();

		Season summer = Season.valueOf("Summer");
		summer.show();

		Season[] seasons = Season.values();
		for (Season season : seasons) {
			season.show();
		}
	}
}
