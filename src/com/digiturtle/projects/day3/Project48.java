package com.digiturtle.projects.day3;

import java.math.BigInteger;

import com.digiturtle.projects.BasicProject;

public class Project48 implements BasicProject {

	public static void main(String[] args) {
		new Project48().run();
	}
	
	@Override
	public void run() {
		BigInteger e = new BigInteger("0");
		for (int i = 1; i <= 1000; i++) {
			BigInteger b = new BigInteger("" + i).pow(i);
			e = e.add(b);
		}
		String str = e.toString();
		System.out.println(str.substring(str.length() - 10));
	}

}
