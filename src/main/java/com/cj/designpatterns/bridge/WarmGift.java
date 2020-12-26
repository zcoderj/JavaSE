package com.cj.designpatterns.bridge;

/**
 * @ClassName WarmGift
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/15 015 16:24
 * @Version 1.0
 **/
public class WarmGift extends Gift {
	public WarmGift(GiftImpl gift) {
		this.gift = gift;
	}
}
