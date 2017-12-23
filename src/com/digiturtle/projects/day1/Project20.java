package com.digiturtle.projects.day1;

import java.math.BigInteger;

import com.digiturtle.projects.BasicProject;

public class Project20 implements BasicProject {

	public static void main(String[] args) {
		new Project20().run();
	}
	
	@Override
	public void run() {
		System.out.println("Sum of 100!: " + sum(factorial(new BigInteger("100")).toString()));
	}

	private int sum(String number) {
		int sum = 0;
		for (int i = 0; i < number.length(); i++) {
			sum += Integer.parseInt(number.charAt(i) + "");
		}
		return sum;
	}

	public BigInteger factorial(BigInteger n) {
		if (n.intValue() <= 1) {
			return new BigInteger("1");
		}
		return n.multiply(factorial(n.subtract(new BigInteger("1"))));
	}

}
