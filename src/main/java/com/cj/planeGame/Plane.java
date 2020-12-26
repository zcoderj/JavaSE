package com.cj.planeGame;

import com.sun.javafx.font.directwrite.DWFactory;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @ClassName Plane
 * @Description 飞机
 * @Author CJ
 * @Date 2020/6/16 016 08:19
 * @Version 1.0
 **/
public class Plane extends GameObject {

	boolean left, up, right, down;
	boolean live = true;

	public Plane(Image img, double x, double y) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = 8;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}

	@Override
	public void drawSelf(Graphics g) {
		if (live) {
			g.drawImage(img, (int)x,(int)y,null);
			if(left) {
				x -= speed;
			}
			if(right) {
				x += speed;
			}
			if(up) {
				y -= speed;
			}
			if(down) {
				y += speed;
			}
		}
	}


	public void addDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				left = true;
				break;
			case KeyEvent.VK_UP:
				up = true;
				break;
			case KeyEvent.VK_RIGHT:
				right = true;
				break;
			case KeyEvent.VK_DOWN:
				down = true;
				break;
			default:
				break;
		}
	}

	public void minusDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				left = false;
				break;
			case KeyEvent.VK_UP:
				up = false;
				break;
			case KeyEvent.VK_RIGHT:
				right = false;
				break;
			case KeyEvent.VK_DOWN:
				down = false;
				break;
			default:
				break;
		}
	}
}
