package com.digiturtle.projects.day1;

import com.digiturtle.projects.BasicProject;

public class Project1 implements BasicProject {

	public static void main(String[] args) {
		new Project1().run();
	}

	@Override
	public void run() {
		int sum = 0;
		int max = 1000;
		for (int i = 1; i < max; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		// Result
		System.out.println("Sum: " + sum);
	}

}
