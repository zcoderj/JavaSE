package com.cj.designpatterns.composite;

/**
 * @InterfaceName Component
 * @Description TODO 组合模式（树状结构）
 * @Author CJ
 * @Date 2020/9/17 017 22:07
 * @Version 1.0
 **/
public interface Component {
	void operation();
}

interface Leaf extends Component {
}

interface Composite extends Component {

	void add(Component c);
	void remove(Component c);
	Component getChild(int index);
}
