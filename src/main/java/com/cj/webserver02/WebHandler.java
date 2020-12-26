package com.cj.webserver02;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName WebHandler
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/24 024 11:39
 * @Version 1.0
 **/
public class WebHandler extends DefaultHandler {

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
