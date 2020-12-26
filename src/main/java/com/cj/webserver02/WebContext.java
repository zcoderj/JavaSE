package com.cj.webserver02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName WebContext
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/23 023 21:46
 * @Version 1.0
 **/
public class WebContext {

	private List<Entity> entitys = null;
	private List<Mapping> mappings = null;
	private Map<String, String> entityMap = new HashMap<>();
	private Map<String, String> mappingMap = new HashMap<>();

	public WebContext(List<Entity> entitys, List<Mapping> mappings) {
		this.entitys = entitys;
		this.mappings = mappings;

		for (Entity entity : entitys) {
			entityMap.put(entity.getName(), entity.getClazz());
		}

		for (Mapping mapping : mappings) {
			for (String pattern : mapping.getPatterns()) {
				mappingMap.put(pattern, mapping.getName());
			}
		}
	}

	public String getClazz(String pattern) {
		String name = mappingMap.get(pattern);
		return entityMap.get(name);
	}
}
