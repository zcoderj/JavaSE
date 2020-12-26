package com.cj.planeGame;

import java.awt.*;

/**
 * @ClassName Shell
 * @Description 炮弹
 * @Author CJ
 * @Date 2020/6/16 016 08:31
 * @Version 1.0
 **/
public class Shell extends GameObject {

	double degree;

	public Shell() {
		x = 200;
		y = 200;
		width = 10;
		height = 10;
		speed = 3;
		degree = Math.random() * Math.PI * 2;
	}

	public void draw(Graphics g) {
		Color color = g.getColor();
		g.setColor(Color.CYAN);

		g.fillOval((int) x, (int) y, width, height);

		// 炮弹沿着任意角度扩散
		x += speed * Math.cos(degree);
		y += speed * Math.sin(degree);

		if (x < 0 || x > Constant.GAME_WIDTH - width) {
			degree = Math.PI - degree;
		}

		if (y < 30 || y > Constant.GAME_HEIGHT - height) {
			degree = -degree;
		}

		g.setColor(color);
	}
}
