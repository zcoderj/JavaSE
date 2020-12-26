package com.cj.planeGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * @ClassName GameUtil
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/16 016 08:14
 * @Version 1.0
 **/
public class GameUtil {

	private GameUtil() {
	}

	/**
	 * 返回指定路径的图片对象
	 * @param path
	 * @return
	 */
	public static Image getImage(String path) {
		BufferedImage bi = null;
		try {
			URL url = GameUtil.class.getClassLoader().getResource(path);
			bi = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bi;
	}
}
