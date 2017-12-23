package com.digiturtle.projects.day1;

import java.math.BigInteger;

import com.digiturtle.projects.BasicProject;

public class Project16 implements BasicProject {

	public static void main(String[] args) {
		new Project16().run();
	}
	
	@Override
	public void run() {
		BigInteger base = new BigInteger("2");
		System.out.println("Sum: " + sum(base.pow(1000).toString()));
	}
	
	private int sum(String number) {
		int sum = 0;
		for (int i = 0; i < number.length(); i++) {
			sum += Integer.parseInt(number.charAt(i) + "");
		}
		return sum;
	}

}
