package com.digiturtle.projects.day2;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.Utils;

public class Project36 implements BasicProject {

	public static void main(String[] args) {
		new Project36().run();
	}
	
	@Override
	public void run() {
		int sum = 0;
		for (int n = 1; n < 1_000_000; n++) {
			if (Utils.isPalindrome(Integer.toString(n)) &&
					Utils.isPalindrome(Integer.toBinaryString(n))) {
				sum += n;
			}
		}
		System.out.println("Sum: " + sum);
	}

}
