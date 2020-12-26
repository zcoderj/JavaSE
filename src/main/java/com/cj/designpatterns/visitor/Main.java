package com.cj.designpatterns.visitor;

/**
 * @ClassName Main
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/13 013 20:59
 * @Version 1.0
 **/
public class Main {
	public static void main(String[] args) {
		Computer computer = new Computer();

		PersonelVisitor personelVisitor = new PersonelVisitor();
		computer.accept(personelVisitor);
		System.out.println("个人：" + personelVisitor.totalPrice);

		CompanyVisitor companyVisitor = new CompanyVisitor();
		computer.accept(companyVisitor);
		System.out.println("企业：" + companyVisitor.totalParice);
	}
}

class Computer {
	ComputerPart cpu = new CPU();
	ComputerPart memeory = new Memory();
	ComputerPart board = new Board();

	public void accept(Visitor visitor) {
		this.cpu.accept(visitor);
		this.memeory.accept(visitor);
		this.board.accept(visitor);
	}
}

abstract class ComputerPart {
	abstract void accept(Visitor visitor);
	// some other operations eg: getName getBrand
	abstract double getPrice();
}

class CPU extends ComputerPart {

	@Override
	void accept(Visitor visitor) {
		visitor.visitCpu(this);
	}

	@Override
	double getPrice() {
		return 100;
	}
}

class Memory extends ComputerPart {

	@Override
	void accept(Visitor visitor) {
		visitor.visitMemory(this);
	}

	@Override
	double getPrice() {
		return 200;
	}
}

class Board extends ComputerPart {

	@Override
	void accept(Visitor visitor) {
		visitor.visitBoard(this);
	}

	@Override
	double getPrice() {
		return 300;
	}
}

interface Visitor {
	void visitCpu(CPU cpu);
	void visitMemory(Memory memory);
	void visitBoard(Board board);
}

class PersonelVisitor implements Visitor {

	double totalPrice = 0.0;

	@Override
	public void visitCpu(CPU cpu) {
		totalPrice += cpu.getPrice() * 0.9;
	}

	@Override
	public void visitMemory(Memory memory) {
		totalPrice += memory.getPrice() * 1.0;
	}

	@Override
	public void visitBoard(Board board) {
		totalPrice += board.getPrice() * 1.0;
	}
}

class CompanyVisitor implements Visitor {

	double totalParice = 0.0;

	@Override
	public void visitCpu(CPU cpu) {
		totalParice += cpu.getPrice() * 0.5;
	}

	@Override
	public void visitMemory(Memory memory) {
		totalParice += memory.getPrice() * 0.5;
	}

	@Override
	public void visitBoard(Board board) {
		totalParice += board.getPrice() * 0.5;
	}
}
