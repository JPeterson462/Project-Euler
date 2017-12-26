package com.digiturtle.projects.day4;

import java.math.BigInteger;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.Utils;

public class Project56 implements BasicProject {

	public static void main(String[] args) {
		new Project56().run();
	}
	
	@Override
	public void run() {
		int maximumSum = 0;
		for (int a = 1; a < 100; a++) {
			for (int b = 1; b < 100; b++) {
				BigInteger i = new BigInteger(a + "").pow(b);
				int sum = Utils.sumDigits(i.toString());
				maximumSum = Integer.max(maximumSum, sum);
			}
		}
		System.out.println("Sum: " + maximumSum);
	}

}
