package com.digiturtle.projects.day1;

import com.digiturtle.projects.BasicProject;

public class Project5 implements BasicProject {

	public static void main(String[] args) {
		new Project5().run();
	}
	
	@Override
	public void run() {
		// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
		int smallestEvenlyDivisible = 0;
		for (int i = 1; smallestEvenlyDivisible == 0; i++) {
			if (divisible(i, 1) && divisible(i, 2) && divisible(i, 3) && divisible(i, 4)
					&& divisible(i, 5) && divisible(i, 6) && divisible(i, 7) && divisible(i, 8)
					&& divisible(i, 9) && divisible(i, 10) && divisible(i, 11) && divisible(i, 12)
					&& divisible(i, 13) && divisible(i, 14) && divisible(i, 15) && divisible(i, 16)
					&& divisible(i, 17) && divisible(i, 18) && divisible(i, 19) && divisible(i, 20)) {
				smallestEvenlyDivisible = i;
			}
		}
		System.out.println("Smallest Evenly Divisible: " + smallestEvenlyDivisible);
	}
	
	private boolean divisible(int n, int factor) {
		return n % factor == 0;
	}

}
