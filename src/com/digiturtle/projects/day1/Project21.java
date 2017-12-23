package com.digiturtle.projects.day1;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.Utils;

public class Project21 implements BasicProject {

	public static void main(String[] args) {
		new Project21().run();
	}
	
	@Override
	public void run() {
		System.out.println(Utils.sumDivisors(284));
		int sum = 0;
		for (int i = 1; i <= 10_000; i++) {
			if (Utils.sumDivisors(Utils.sumDivisors(i)) == i && 
					i != Utils.sumDivisors(i)) {
				sum += i;
			}
		}
		System.out.println("Sum: " + sum);
	}

}
