package com.cj.designpatterns.bridge;

/**
 * @ClassName WildGift
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/15 015 16:25
 * @Version 1.0
 **/
public class WildGift extends Gift {
	public WildGift(GiftImpl gift) {
		this.gift = gift;
	}
}
