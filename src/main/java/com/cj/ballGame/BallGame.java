package com.cj.ballGame;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName BallGame
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/16 016 08:03
 * @Version 1.0
 **/
public class BallGame extends JFrame {

	Image ball = Toolkit.getDefaultToolkit().getImage("image/ball.png");
	Image desk = Toolkit.getDefaultToolkit().getImage("image/desk.jpg");

	double x = 100;
	double y = 100;
	double degree = 3.14 / 3; // 弧度，60度

	// 画窗口
	@Override
	public void paint(Graphics graphics) {
		graphics.drawImage(desk, 0, 0, null);
		graphics.drawImage(ball, (int) x, (int) y, null);

		x = x + 10 * Math.cos(degree);
		y = y + 10 * Math.sin(degree);
		// 碰到底部或顶部，则变角度
		if (y > 500 - 30 - 40 || y < 40 + 40) { // 500球桌高度，30球直径，40桌面边框宽度
			degree = -degree; // 沿x轴对称变化
		}
		// 碰到左边或右边
		if (x < 0 || x > 856 - 40 - 30) {
			degree = 3.14 - degree; // 沿y轴对称变化
		}
	}

	// 窗口加载
	void launchFrame() {
		setSize(856, 500);
		setLocation(50, 50);
		setVisible(true); // 让窗口可见

		while (true) {
			repaint();
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		BallGame ballGame = new BallGame();
		ballGame.launchFrame();
	}
}

