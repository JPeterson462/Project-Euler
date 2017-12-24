package com.digiturtle.projects.day3;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.Utils;

public class Project47 implements BasicProject {

	public static void main(String[] args) {
		new Project47().run();
	}
	
	@Override
	public void run() {
		int i = -1;
		for (int n = 1; n < 1_000_000 && i < 0; n++) {
			if (Utils.primeFactors(n + 0) == 4 && Utils.primeFactors(n + 1) == 4
					&& Utils.primeFactors(n + 2) == 4 && Utils.primeFactors(n + 3) == 4) {
				i = n;
			}
		}
		System.out.println("Result: " + i);
	}

}
