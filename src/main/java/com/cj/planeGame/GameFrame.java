package com.cj.planeGame;

import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

/**
 * @ClassName GameFrame
 * @Description TODO 游戏主窗口
 * @Author CJ
 * @Date 2020/6/16 016 08:44
 * @Version 1.0
 **/
public class GameFrame extends Frame {

	Image planeImg = GameUtil.getImage("images/plane.png");
	Image bg = GameUtil.getImage("images/bg.jpg");

	Plane plane = new Plane(planeImg, 250, 250);
	Shell[] shells = new Shell[50];
	Explode bao;
	Date startTime = new Date();
	Date endTime;
	int period; // 游戏进行时间

	@Override
	public void paint(Graphics g) {
		Color color = g.getColor();
		g.drawImage(bg, 0, 0, null);
		plane.drawSelf(g);

		// 画出所有炮弹
		for (int i = 0; i < shells.length; i++) {
			shells[i].draw(g);

			// 飞机和炮弹碰撞检测
			boolean peng = shells[i].getRectangle().intersects(plane.getRectangle());
			if (peng) {
				plane.live = false;
				if (bao == null) {
					bao = new Explode(plane.x, plane.y);
					endTime = new Date();
					period = (int) ((endTime.getTime() - startTime.getTime()) / 1000);
				}
				bao.draw(g);
			}

			if (!plane.live) {
				g.setColor(Color.magenta);
				Font font = new Font("宋体", Font.BOLD, 50);
				g.setFont(font);
				g.drawString("时间：" + period + "秒", (int) plane.x, (int) plane.y);
			}

		}
		g.setColor(color);
	}

	// 反复重画窗口
	class PaintThread extends Thread {
		@Override
		public void run() {
			while (true) {
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 键盘监听内部类
	class KeyMonitor extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			plane.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			plane.minusDirection(e);
		}
	}
	// 初始化窗口
	public void launchFrame() {
		this.setTitle("飞机大战");
		this.setVisible(true);
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		this.setLocation(600,300);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		new PaintThread().start(); // 启动重画窗口的线程
		addKeyListener(new KeyMonitor()); // 给窗口增加键盘监听

		// 初始化50个炮弹
		for (int i = 0; i < shells.length; i++) {
			shells[i] = new Shell();
		}
	}

	public static void main(String[] args) {
		GameFrame gameFrame = new GameFrame();
		gameFrame.launchFrame();
	}

	private Image offScreenImage = null;

	@Override
	public void update(Graphics g) {
		if(offScreenImage == null) {
			offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);//这是游戏窗口的宽度和高度
		}
		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}

}
