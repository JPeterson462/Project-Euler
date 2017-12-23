package com.digiturtle.projects.day1;

import java.math.BigInteger;

import com.digiturtle.projects.BasicProject;

public class Project15 implements BasicProject {
	
	public static void main(String[] args) {
		new Project15().run();
	}

	@Override
	public void run() {
		BigInteger a = new BigInteger("20"), b = new BigInteger("20");
		BigInteger n = a.add(b), k = a;
		BigInteger paths = factorial(n).divide((factorial(k).multiply(factorial(n.subtract(k)))));
		System.out.println("Paths: " + paths);
	}
	
	public BigInteger factorial(BigInteger n) {
		if (n.intValue() <= 1) {
			return new BigInteger("1");
		}
		return n.multiply(factorial(n.subtract(new BigInteger("1"))));
	}

}
