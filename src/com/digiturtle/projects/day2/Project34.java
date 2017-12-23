package com.digiturtle.projects.day2;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.Utils;

public class Project34 implements BasicProject {

	public static void main(String[] args) {
		new Project34().run();
	}
	
	@Override
	public void run() {
		int total = 0;
		for (int n = 3; n < 1_000_000; n++) {
			String ns = String.valueOf(n);
			int sum = 0;
			for (int i = 0; i < ns.length(); i++) {
				sum += Utils.factorial(Integer.parseInt(ns.substring(i,  i + 1)));
			}
			if (sum == n) {
				total += sum;
			}
		}
		System.out.println("Total: " + total);
	}

}
