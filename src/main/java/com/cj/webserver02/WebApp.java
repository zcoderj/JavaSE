package com.cj.webserver02;

import com.cj.webserver02.servlet.Servlet;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @ClassName XmlTest01
 * @Description TODO SAX解析XML流程
 * @Author CJ
 * @Date 2020/6/23 023 21:29
 * @Version 1.0
 **/
public class WebApp {

	private static WebContext webContext;

	static {
		try {
			// SAX解析
			// 1.获取解析工厂
			SAXParserFactory factory = SAXParserFactory.newInstance();
			// 2.从解析工厂获取解析器
			SAXParser saxParser = null;
			saxParser = factory.newSAXParser();
			// 3.编写处理器，注册处理器
			WebHandler handler = new WebHandler();
			// 4.解析
			saxParser.parse(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("web.xml"), handler);

			// 获取数据
			webContext = new WebContext(handler.getEntitys(), handler.getMappings());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Servlet getServletByUrl(String url) {

		String className = webContext.getClazz("/" + url);
		Class clazz;
		try {
			clazz = Class.forName(className);
			Servlet servlet = (Servlet) clazz.getConstructor().newInstance();
			return servlet;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
