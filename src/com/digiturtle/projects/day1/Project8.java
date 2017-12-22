package com.digiturtle.projects.day1;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.Utils;

public class Project8 implements BasicProject {

	public static void main(String[] args) {
		new Project8().run();
	}
	
	@Override
	public void run() {
		String fileContents = Utils.join(Utils.readFile("Problem8.txt"), "");
		long product = 1;
		for (int i = 13; i < fileContents.length(); i++) {
			String subsequence = fileContents.substring(i - 13, i);
			product = Math.max(product, product(subsequence));
		}
		System.out.println("Product: " + product);
	}
	
	private long product(String sequence) {
		long product = 1;
		for (int i = 0; i < sequence.length(); i++) {
			product *= Long.valueOf(sequence.charAt(i) + "");
		}
		return product;
	}

}
