package com.digiturtle.projects.day1;

import com.digiturtle.projects.BasicProject;

public class Project9 implements BasicProject {

	public static void main(String[] args) {
		new Project9().run();
	}
	
	@Override
	public void run() {
		for (int c = 1; c <= 1000; c++) {
			for (int b = 1; b < c; b++) {
				int a = 1000 - c - b;
				if (a != b && a > 0) {
					if (a * a + b * b == c * c) {
						System.out.println("Product: " + a * b * c);
					}
				}
			}
		}
	}

}
