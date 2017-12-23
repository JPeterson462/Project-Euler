package com.digiturtle.projects.day2;

import com.digiturtle.projects.BasicProject;

public class Project28 implements BasicProject {

	public static void main(String[] args) {
		new Project28().run();
	}
	
	@Override
	public void run() {
		// f(n) = 4(2n+1)^2 – 12n + f(n-1)
		System.out.println("Sum: " + f(500));
	}
	
	public int f(int n) {
		if (n == 0) {
			return 1;
		}
		return 4 * (2 * n + 1) * (2 * n + 1) - 12 * n + f(n - 1);
	}
	
}
