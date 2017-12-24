package com.digiturtle.projects.day2;

import com.digiturtle.projects.BasicProject;

public class Project40 implements BasicProject {

	public static void main(String[] args) {
		new Project40().run();
	}
	
	@Override
	public void run() {
		StringBuilder s = new StringBuilder("0");
		for (int n = 1; n < 190_000; n++) {
			s.append(n);
		}
		int d1 = Integer.valueOf("" + s.charAt(1));
		int d2 = Integer.valueOf("" + s.charAt(10));
		int d3 = Integer.valueOf("" + s.charAt(100));
		int d4 = Integer.valueOf("" + s.charAt(1_000));
		int d5 = Integer.valueOf("" + s.charAt(10_000));
		int d6 = Integer.valueOf("" + s.charAt(100_000));
		int d7 = Integer.valueOf("" + s.charAt(1_000_000));
		System.out.println(d1 * d2 * d3 * d4 * d5 * d6 * d7);
	}

}
