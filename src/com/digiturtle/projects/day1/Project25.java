package com.digiturtle.projects.day1;

import java.math.BigInteger;

import com.digiturtle.projects.BasicProject;

public class Project25 implements BasicProject {

	public static void main(String[] args) {
		new Project25().run();
	}
	
	@Override
	public void run() {
		BigInteger a = new BigInteger("0");
		BigInteger b = new BigInteger("1");
		int j = 0;
		for (int i = 1; b.toString().length() < 1000; i++) {
			BigInteger sum = a.add(b);
			a = b;
			b = sum;
			j = i + 1;
		}
		System.out.println(j);
	}

}
