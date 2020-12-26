package com.cj.designpatterns.command;

/**
 * @ClassName Main
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/15 015 16:48
 * @Version 1.0
 **/
public class Main {
	public static void main(String[] args) {
		Content c = new Content("hello world");

//		Command command = new CopyCommand(c);
		Command command = new DeleteCommand(c);
		command.doit();
		System.out.println(c.msg);
		command.doit();
		System.out.println(c.msg);
		command.undo();
		System.out.println(c.msg);
		command.undo();
		System.out.println(c.msg);
	}
}
