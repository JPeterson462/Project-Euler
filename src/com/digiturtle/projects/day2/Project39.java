package com.digiturtle.projects.day2;

import com.digiturtle.projects.BasicProject;

public class Project39 implements BasicProject {

	public static void main(String[] args) {
		new Project39().run();
	}
	
	@Override
	public void run() {
		int solutions = 0;
		int pv = 0;
		for (int p = 1; p <= 1000; p++) {
			int slns = solutions(p);
			if (slns > solutions) {
				pv = p;
				solutions = slns;
			}
		}
		System.out.println("P: " + pv);
	}
	
	public int solutions(int p) {
		int solutions = 0;
		for (int c = 1; c <= p; c++) {
			for (int b = 1; b * b < c * c; b++) {
				int a = p - c - b;
				if (a < 0) {
					continue;
				}
				if (a > b || b > c) {
					continue;
				}
				if (a * a + b * b == c * c) {
					solutions++;
				}
			}
		}
		return solutions;
	}

}
