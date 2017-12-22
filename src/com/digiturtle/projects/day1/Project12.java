package com.digiturtle.projects.day1;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.Utils;

public class Project12 implements BasicProject {

	public static void main(String[] args) {
		new Project12().run();
	}
	
	@Override
	public void run() {
		int number = 1;
		for (int add = 2; add < 999_999_999; add++) {
			if (Utils.countDivisors(number) >= 500) {
				System.out.println(number);
			}
			number += add;
		}
	}

}
