package com.cj.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @ClassName SplitFile
 * @Description TODO 文件分割 序列输入流（将多个输入流放入集合中，以统一操作多个输入流）
 * @Author CJ
 * @Date 2020/6/20 020 11:13
 * @Version 1.0
 **/
public class SplitFile {

	// 源头
	private File source;
	// 目的地（文件夹）
	private String targetDir;
	// 分割后所有文件的路径
	private List<String> targetPaths;
	// 每块大小
	private int blockSize;
	// 块数
	private int blockNumber;

	public SplitFile(String sourcePath, String targetDir, int blockSize) {
		this.source = new File(sourcePath);
		this.targetDir = targetDir;
		this.blockSize = blockSize;
		this.targetPaths = new ArrayList<>();
		// 初始化
		init();
	}

	/**
	 * 初始化
	 */
	private void init() {
		// 文件总大小
		long length = this.source.length();
		// 块数
		this.blockNumber = (int) Math.ceil(length * 1.0 / blockSize);
		// 分割后所有为文件的路径
		for (int i = 0; i < blockNumber; i++) {
			this.targetPaths.add(this.targetDir + "/" + this.source.getName() + i);
		}
	}

	/**
	 * 分割文件
	 */
	public void split() throws IOException {
		// 起始位置
		int beginPosition = 0;
		// 实际大小
		int actualSize = 0;
		// 文件剩余总大小
		long length = this.source.length();
		for (int i = 0; i < this.blockNumber; i++) {
			beginPosition = i * blockSize;
			if (i == this.blockNumber - 1) {
				actualSize = (int) length;
			} else {
				actualSize = this.blockSize;
				length -= blockSize;
			}
			splitDetail(i, beginPosition, actualSize);
		}

	}

	private void splitDetail(int i, int beginPosition, int actualSize) throws IOException {

		RandomAccessFile rafRead = new RandomAccessFile(this.source, "r");
		RandomAccessFile rafWrite = new RandomAccessFile(this.targetPaths.get(i), "rw");
		// 指定读取的起始位置
		rafRead.seek(beginPosition);
		// 读取文件中的指定分段
		// 缓冲容器
		byte[] flush = new byte[1024 * 1];
		int len = -1;
		while ((len = rafRead.read(flush)) != -1) {
			if (actualSize > len) {
				rafWrite.write(flush, 0, len);
			} else {
				rafWrite.write(flush, 0, actualSize);
				break;
			}
		}
		rafWrite.close();
		rafRead.close();
	}

	public void merge(String targetPath) throws IOException {
		// 输入流
		Vector<InputStream> vector = new Vector<>();
		SequenceInputStream sis = null;
		for (int i = 0; i < this.targetPaths.size(); i++) {
			vector.add(new BufferedInputStream(new FileInputStream(this.targetPaths.get(i))));
		}
		sis = new SequenceInputStream(vector.elements());
		// 输出流 追加方式
		OutputStream os = new BufferedOutputStream(new FileOutputStream(targetPath, true));
		// 缓冲容器
		byte[] flush = new byte[1024 * 1];
		int len = -1;
		while ((len = sis.read(flush)) != -1) {
			os.write(flush, 0, len);
		}
		os.flush();
		sis.close();
		os.close();
	}

	public static void main(String[] args) throws IOException {

		SplitFile splitFile = new SplitFile("src/com/cj/io/SplitFile.java", "splitFile", 1024);
		splitFile.split();
		splitFile.merge("SplitFile.txt");
	}
}
