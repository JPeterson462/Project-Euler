package com.digiturtle.projects.day2;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.Utils;

public class Project38 implements BasicProject {

	public static void main(String[] args) {
		new Project38().run();
	}
	
	@Override
	public void run() {
		int max = 0;
		for (int n = 1; n < 100_000; n++) {
			for (int j = 2; j < 10; j++) {
				String sum = "";
				for (int i = 1; i <= j; i++) {
					sum += i * n;
				}
				if (sum.length() == 9 && Utils.isPandigital(sum)) {
					max = Math.max(max, Integer.parseInt(sum));
				}
			}
		}
		System.out.println("Max: " + max);
	}

}
