package com.cj.designpatterns.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Main
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/9 009 15:25
 * @Version 1.0
 **/
public class Main {
	public static void main(String[] args) {
		Request request = new Request();
		request.str = "<script>hahaha</script>996,996";
		Response response = new Response();
		response.str = "response";
		FilterChain chain = new FilterChain();
		chain.add(new ScriptFilter()).add(new SensitiveWordFilter()).doFilter(request, response);
		System.out.println(request.str);
		System.out.println(response.str);
	}
}

interface Filter {
	void doFilter(Request request, Response response, FilterChain chain);
}

class ScriptFilter implements Filter {

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		request.str = request.str.replaceAll("<", "[").replaceAll(">", "]") + "=>ScriptFilter";
		chain.doFilter(request, response);
		response.str += "=>ScriptFilter";
	}
}

class SensitiveWordFilter implements Filter {

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		request.str = request.str.replaceAll("996", "955") + "=>SensitiveWordFilter";
		chain.doFilter(request, response);
		response.str += "=>SensitiveWordsFilter";
	}
}

class FilterChain {
	List<Filter> filters = new ArrayList<>();
	int index = 0;

	public FilterChain add(Filter filter) {
		filters.add(filter);
		return this;
	}

	public void doFilter(Request request, Response response) {
		if (index == filters.size()) {
			return;
		}
		filters.get(index++).doFilter(request, response, this);
	}
}

class Request {
	String str;
}

class Response {
	String str;
}

