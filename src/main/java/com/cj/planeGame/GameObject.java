package com.cj.planeGame;

import java.awt.*;

/**
 * @ClassName GameObject
 * @Description 游戏物体
 * @Author CJ
 * @Date 2020/6/16 016 08:08
 * @Version 1.0
 **/
public class GameObject {

	Image img;
	double x, y;
	int speed;
	int width, height;

	public void drawSelf(Graphics g) {
		g.drawImage(img, (int) x, (int) y, null);
	}

	public GameObject(Image img, double x, double y, int speed, int width, int height) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}

	public GameObject(Image img, double x, double y) {
		this.img = img;
		this.x = x;
		this.y = y;
	}

	public GameObject() {
	}

	/**
	 * 返回物体所在的矩形，便于后续的碰撞检测
	 * @return
	 */
	public Rectangle getRectangle() {
		return new Rectangle((int) x, (int) y, width, height);
	}
}
