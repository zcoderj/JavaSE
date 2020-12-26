package com.cj.designpatterns.builder;

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
	ComputerBuilder buildCpu();
	ComputerBuilder buildMemory();
	ComputerBuilder buildBoard();
	Computer build();
}

class HuaweiComputerBuilder implements ComputerBuilder {

	private Computer computer = new Computer();

	@Override
	public ComputerBuilder buildCpu() {
		computer.cpu = new CPU("intel", "i7");
		return this;
	}

	@Override
	public ComputerBuilder buildMemory() {
		computer.memory = new Memory("Kingston", "KVR26N");
		return this;
	}

	@Override
	public ComputerBuilder buildBoard() {
		computer.board = new Board("技嘉", "B365");
		return this;
	}

	@Override
	public Computer build() {
		return computer;
	}
}
