package com.digiturtle.projects.day1;

import com.digiturtle.projects.BasicProject;

public class Project6 implements BasicProject {

	public static void main(String[] args) {
		new Project6().run();
	}
	
	@Override
	public void run() {
		int sumSquares = 0, squareSum = 0;
		for (int i = 1; i <= 100; i++) {
			sumSquares += i * i;
			squareSum += i;
		}
		int squaredSum = squareSum * squareSum;
		System.out.println("Difference: " + (squaredSum - sumSquares));
		
	}

}
