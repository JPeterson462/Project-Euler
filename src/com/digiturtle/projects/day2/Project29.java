package com.digiturtle.projects.day2;

import java.math.BigInteger;
import java.util.HashSet;

import com.digiturtle.projects.BasicProject;

public class Project29 implements BasicProject {

	public static void main(String[] args) {
		new Project29().run();
	}
	
	@Override
	public void run() {
		HashSet<String> numbers = new HashSet<>();
		for (int a = 2; a <= 100; a++) {
			for (int b = 2; b <= 100; b++) {
				BigInteger ai = new BigInteger("" + a);
				BigInteger c = ai.pow(b);
				numbers.add(c.toString());
			}
		}
		System.out.println("Distinct Terms: " + numbers.size());
	}

}
