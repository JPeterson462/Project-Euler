package com.digiturtle.projects.day3;

import java.math.BigInteger;

import com.digiturtle.projects.BasicProject;

public class Project53 implements BasicProject {

	public static void main(String[] args) {
		new Project53().run();
	}
	
	@Override
	public void run() {
		BigInteger[] factorials = new BigInteger[101];
		for (int i = 0; i < factorials.length; i++) {
			factorials[i] = factorial(new BigInteger(i + ""));
		}
		int count = 0;
		for (int n = 1; n <= 100; n++) {
			for (int r = 1; r < n; r++) {
				BigInteger result = factorials[n].divide(factorials[r].multiply(factorials[n - r]));
				if (result.intValue() > 1_000_000) {
					System.out.println(n + " choose " + r);
					count++;
				}
			}
		}
		System.out.println("Count: " + count);
	}
	
	public BigInteger factorial(BigInteger n) {
		if (n.intValue() <= 1) {
			return new BigInteger("1");
		}
		return n.multiply(factorial(n.subtract(new BigInteger("1"))));
	}

}
