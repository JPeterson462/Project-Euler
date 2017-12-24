package com.digiturtle.projects.day2;

import com.digiturtle.projects.BasicProject;

public class Project44 implements BasicProject {
	
	public static void main(String[] args) {
		new Project44().run();
	}

	@Override
	public void run() {
		int difference = Integer.MAX_VALUE;
		for (int k = 1; k < 10_000; k++) {
			for (int j = 1; j < k; j++) {
				int pj = getPentagonal(j), pk = getPentagonal(k);
				if (isPentagonal(pj + pk) && isPentagonal(pk - pj)) {
					if (pk - pj < difference) {
						difference = pk - pj;
					}
				}
			}
		}
		System.out.println("Difference: " + difference);
	}
	
	public int getPentagonal(int n) {
		return (n) * (3 * n - 1) / 2;
	}
	
	public boolean isPentagonal(int number) {
		double x = (Math.sqrt(1 + 24 * number) + 1.0) / 6.0;
		return x == (int) x;
	}

}
