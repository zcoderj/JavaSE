package com.cj.designpatterns.command;


/**
 * @ClassName Command
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/15 015 16:32
 * @Version 1.0
 **/
public abstract class Command {
	public abstract void doit(); // exec run
	public abstract void undo();
}

class Content {
	String msg;

	public Content(String msg) {
		this.msg = msg;
	}
}

class CopyCommand extends Command {

	Content c;

	public CopyCommand(Content c) {
		this.c = c;
	}

	@Override
	public void doit() {
		c.msg += c.msg;
	}

	@Override
	public void undo() {
		c.msg = c.msg.substring(0, c.msg.length() / 2);
	}
}

class DeleteCommand extends Command {

	Content c;
	String deleted = "";

	public DeleteCommand(Content c) {
		this.c = c;
	}

	@Override
	public void doit() {
		deleted += c.msg.substring(c.msg.length() - 1);
		c.msg = c.msg.substring(0, c.msg.length() - 1);
	}

	@Override
	public void undo() {
		c.msg += deleted.substring(deleted.length() - 1);
		deleted = deleted.substring(0, deleted.length() - 1);
	}
}
