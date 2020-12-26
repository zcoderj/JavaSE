package com.cj.binarytree;

import java.util.Stack;

/**
 * @ClassName Traversal
 * @Description TODO 利用栈遍历二叉树（非递归方式）
 * @Author CJ
 * @Date 2020/9/10 010 20:31
 * @Version 1.0
 **/
public class Traversal {

	public static void main(String[] args) {
		Node root = new Node(1);
		Node left = new Node(2);
		Node right = new Node(3);
		Node lchild = new Node(4);
		Node rchild = new Node(5);
		left.lchild = lchild;
		left.rchild = rchild;
		root.lchild = left;
		root.rchild = right;

		// 前序遍历
		preorder(root);
		System.out.println();
		// 中序遍历
		inorder(root);
		System.out.println();
		// 后序遍历
		postorder(root);

	}

	/**
	 * 前序遍历
	 * 栈实现前序遍历较简单，由于每次先输出根节点，再输出左节点随后是右节点。
	 * 1、若栈非空输出根节点，并出栈
	 * 2、将右节点压栈（如果存在）
	 * 3、将左节点压栈（如果存在）
	 * 4、重复第1步直到栈空
	 * @param node
	 */
	public static void preorder(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		Node cur = node;
		stack.push(cur);
		while (!stack.empty()) {
			// 输出根节点并出栈
			cur = stack.pop();
			System.out.print(cur.data + " ");
			// 将右结点压栈
			if (cur.rchild != null) {
				stack.push(cur.rchild);
			}
			// 将左节点压栈
			if (cur.lchild != null) {
				stack.push(cur.lchild);
			}
		}
	}

	/**
	 * 中序遍历
	 * 栈的中序遍历需要套两层循环，由于需要先输出左节点，因此必须向下查找直到左节点为空才能输出。处理逻辑如下：
	 * 1、如果栈顶元素非空且左节点存在，将其入栈，重复该过程。若不存在则进入第2步
	 * 2、若栈非空，输出栈顶元素并出栈。判断刚出栈的元素的右节点是否存在，不存在重复第2步，存在则将右节点入栈，跳至第1步
	 * @param node
	 */
	public static void inorder(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		Node cur = node;
		stack.push(cur);
		while (!stack.empty()) {
			// 1.左节点非空则入栈
			while (stack.peek().lchild != null) {
				stack.push(stack.peek().lchild);
			}
			while (!stack.empty()) {
				cur = stack.pop();
				System.out.print(cur.data + " ");
				// 2.右节点非空，则入栈，继续步骤1
				if (cur.rchild != null) {
					stack.push(cur.rchild);
					break;
				}
			}
		}
	}

	/**
	 * 后序遍历
	 * 后序遍历在中序的双层循环的基础上需要加入一个记录，专门记录上一次出栈的节点。步骤如下：
	 * 1、如果栈顶元素非空且左节点存在，将其入栈，重复该过程。若不存在则进入第2步（该过程和中序遍历一致）
	 * 2、判断上一次出栈节点是否当前节点的右节点，或者当前节点是否存在右节点，满足任一条件，将当前节点输出，并出栈。
	 *    否则将右节点压栈。跳至第1步
	 * @param node
	 */
	public static void postorder(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		stack.push(node);
		Node lastPop = null;
		while (!stack.empty()) {
			while (stack.peek().lchild != null) {
				stack.push(stack.peek().lchild);
			}
			while (!stack.empty()) {
				if (lastPop == stack.peek().rchild || stack.peek().rchild == null) {
					lastPop = stack.pop();
					System.out.print(lastPop.data + " ");
				} else if (stack.peek().rchild != null) {
					stack.push(stack.peek().rchild);
					break;
				}
			}
		}
	}
}
