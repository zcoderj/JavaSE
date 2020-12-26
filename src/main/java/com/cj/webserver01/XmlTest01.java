package com.cj.webserver01;

import com.cj.webserver01.servlet.Servlet;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName XmlTest01
 * @Description TODO SAX解析XML流程
 * @Author CJ
 * @Date 2020/6/23 023 21:29
 * @Version 1.0
 **/
public class XmlTest01 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		// SAX解析
		// 1.获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 2.从解析工厂获取解析器
		SAXParser saxParser = factory.newSAXParser();
		// 3.编写处理器，注册处理器
		WebHandler handler = new WebHandler();
		// 4.解析
		saxParser.parse(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("com/cj/webserver01/web.xml"), handler);

		// 获取数据
		WebContext webContext = new WebContext(handler.getEntitys(), handler.getMappings());

		String className = webContext.getClazz("/login");
		System.out.println(className);
		Class clazz = Class.forName(className);
		Servlet servlet = (Servlet) clazz.getConstructor().newInstance();
		System.out.println(servlet);
		servlet.service();
	}
}

class WebHandler extends DefaultHandler {

	private List<Entity> entitys = new ArrayList<>();
	private List<Mapping> mappings = new ArrayList<>();
	private Entity entity;
	private Mapping mapping;
	private String tag; //存储操作标签
	private boolean isMapping = false;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (null != qName) {
			tag = qName; // 存储标签名
			if (tag.equals("servlet")) {
				entity = new Entity();
				isMapping = false;
			} else if (tag.equals("servlet-mapping")) {
				mapping = new Mapping();
				isMapping = true;
			}
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		String content = new String(ch, start, length);
		if (tag != null) {
			if (isMapping) {
				if (tag.equals("servlet-name")) {
					mapping.setName(content);
				} else if (tag.equals("url-pattern")) {
					mapping.addPattern(content);
				}
			} else {
				if (tag.equals("servlet-name")) {
					entity.setName(content);
				} else if (tag.equals("servlet-class")) {
					entity.setClazz(content);
				}
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName != null) {
			if (qName.equals("servlet")) {
				entitys.add(entity);
			} else if (qName.equals("servlet-mapping")) {
				mappings.add(mapping);
			}
		}
		tag = null;
	}

	public List<Entity> getEntitys() {
		return entitys;
	}

	public List<Mapping> getMappings() {
		return mappings;
	}
}
