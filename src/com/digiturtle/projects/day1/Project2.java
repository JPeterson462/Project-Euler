package com.digiturtle.projects.day1;

import com.digiturtle.projects.BasicProject;

public class Project2 implements BasicProject {

	public static void main(String[] args) {
		new Project2().run();
	}
	
	@Override
	public void run() {
		int num1 = 1, num2 = 1;
		int sum = 0;
		int max = 4_000_000;
		while (num2 < max) {
			int termSum = num1 + num2;
			num1 = num2;
			num2 = termSum;
			if (num2 % 2 == 0) {
				sum += num2;
			}
		}
		System.out.println("Sum: " + sum);
	}

}
