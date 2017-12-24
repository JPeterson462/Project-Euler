package com.digiturtle.projects.day2;

import com.digiturtle.projects.BasicProject;

public class Project45 implements BasicProject {

	public static void main(String[] args) {
		new Project45().run();
	}
	
	@Override
	public void run() {
		for (long m = 1; m < 1_000_000; m++) {
			long n = (m * (m + 1)) / 2; // Generate triangular numbers
			// Hexagonal numbers are triangular
			if (isPentagonal(n)) {
				System.out.println(n);
			}
		}
		// Skip one and take the next (only every other triangular number is hexagonal)
	}

	public boolean isPentagonal(long number) {
		// a = 3/2, b = -1/2, c = -number
		// (-b + sqrt(b^2 - 4ac)) / 3
		double x = (Math.sqrt(1 + 24 * number) + 1.0) / 6.0;
		return x == (long) x;
	}
	
}
