package com.cj.designpatterns.builder.builder;

/**
 * @ClassName Computer
 * @Description TODO
 * @Author CJ
 * @Date 2020/9/13 013 21:32
 * @Version 1.0
 **/
public class Computer {
	CPU cpu;
	Memory memory;
	Board board;

	public Computer(CPU cpu, Memory memory, Board board) {
		this.cpu = cpu;
		this.memory = memory;
		this.board = board;
	}

	@Override
	public String toString() {
		return "Computer{" +
				"cpu=" + cpu +
				", memory=" + memory +
				", board=" + board +
				'}';
	}
}

class CPU {
	String brand;
	String generation;

	public CPU(String brand, String generation) {
		this.brand = brand;
		this.generation = generation;
	}

	@Override
	public String toString() {
		return "CPU{" +
				"brand='" + brand + '\'' +
				", generation='" + generation + '\'' +
				'}';
	}
}

class Memory {
	String brand;
	String generation;

	public Memory(String brand, String generation) {
		this.brand = brand;
		this.generation = generation;
	}

	@Override
	public String toString() {
		return "Memory{" +
				"brand='" + brand + '\'' +
				", generation='" + generation + '\'' +
				'}';
	}
}

class Board {
	String brand;
	String generation;

	public Board(String brand, String generation) {
		this.brand = brand;
		this.generation = generation;
	}

	@Override
	public String toString() {
		return "Board{" +
				"brand='" + brand + '\'' +
				", generation='" + generation + '\'' +
				'}';
	}
}

interface ComputerBuilder {
	CPU buildCpu();
	Memory buildMemory();
	Board buildBoard();
}

class HuaweiComputerBuilder implements ComputerBuilder {

	@Override
	public CPU buildCpu() {
		return new CPU("intel", "i7");
	}

	@Override
	public Memory buildMemory() {
		return new Memory("Kingston", "KVR26N");
	}

	@Override
	public Board buildBoard() {
		return new Board("技嘉", "B365");
	}
}

// 组装者
interface ComputerDirector {
	Computer builder();
}

class HuaweiDirector implements ComputerDirector {

	private ComputerBuilder computerBuilder;

	public HuaweiDirector(ComputerBuilder computerBuilder) {
		this.computerBuilder = computerBuilder;
	}

	@Override
	public Computer builder() {
		CPU cpu = computerBuilder.buildCpu();
		Memory memory = computerBuilder.buildMemory();
		Board board = computerBuilder.buildBoard();
		return new Computer(cpu, memory, board);
	}
}
