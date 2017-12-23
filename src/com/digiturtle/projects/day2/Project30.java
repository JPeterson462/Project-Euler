package com.digiturtle.projects.day2;

import com.digiturtle.projects.BasicProject;

public class Project30 implements BasicProject {

	public static void main(String[] args) {
		new Project30().run();
	}
	
	@Override
	public void run() {
		int total = 0;
		for (int i = 2; i <= 1_000_000; i++) {
			int sum = 0;
			int n = i;
			while (n > 0) {
				int digit = n % 10;
				sum += digit * digit * digit * digit * digit;
				n = (n - digit) / 10;
			}
			if (sum == i) {
				System.out.println(i);
				total += sum;
			}
		}
		System.out.println("Total: " + total);
	}

}
