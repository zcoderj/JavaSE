package com.cj.webserver01;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Mapping
 * @Description TODO
 * @Author CJ
 * @Date 2020/6/23 023 21:26
 * @Version 1.0
 **/
public class Mapping {

	private String name;
	private Set<String> patterns;

	public Mapping() {
		this.patterns = new HashSet<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getPatterns() {
		return patterns;
	}

	public void setPatterns(Set<String> patterns) {
		this.patterns = patterns;
	}

	public void addPattern(String pattern) {
		this.patterns.add(pattern);
	}
}
