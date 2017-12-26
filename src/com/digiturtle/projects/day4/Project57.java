package com.digiturtle.projects.day4;

import java.math.BigInteger;

import com.digiturtle.projects.BasicProject;

public class Project57 implements BasicProject {

	public static void main(String[] args) {
		new Project57().run();
	}
	
	@Override
	public void run() {
		// b = 1 + 1 / 2
		// b
		// t0 = 1 + 1 / (1 + b)
		// t1 = 1 + 1 / (1 + t0)
		// t2 = 1 + 1 / (1 + t1)
		int count = 0;
		BigInteger den = new BigInteger("2"), num = new BigInteger("3");
		for (int i = 1; i < 1000; i++) {
			num = num.add(den.multiply(new BigInteger("2")));
			den = num.subtract(den);
			if (num.toString().length() > den.toString().length()) {
				count++;
			}
		}
		System.out.println("Count: " + count);
	}

}
