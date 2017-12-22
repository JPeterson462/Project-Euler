package com.digiturtle.projects.day1;

import java.math.BigInteger;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.Utils;

public class Project13 implements BasicProject {

	public static void main(String[] args) {
		new Project13().run();
	}
	
	@Override
	public void run() {
		String[] lines = Utils.readFile("Problem13.txt");
		BigInteger sum = new BigInteger("0");
		for (String line : lines) {
			sum = sum.add(new BigInteger(line));
		}
		System.out.println(sum.toString().substring(0, 10));
	}

}
