package com.digiturtle.projects.day2;

import com.digiturtle.projects.BasicProject;

public class Project26 implements BasicProject {

	public static void main(String[] args) {
		new Project26().run();
	}

	@Override
	public void run() {
		System.out.println("Longest Recurring Cycle: " + findLongestRepeating());
	}
	
	public int findLongestRepeating() {
		int len = 0, d = 0;
		for (int i = 1000; i > 1; i--) { // Iterate through d values
			if (len >= i) {
				break;
			}
			d = i;
			int[] foundRemainders = new int[i];
			int value = 1, position = 0;
			while (foundRemainders[value] == 0 && value != 0) { // Compute the digits of 1/d
				foundRemainders[value] = position;
				value *= 10;
				value %= i;
				position++; // Count digits until there is a repeated digit
			}
			if (position - foundRemainders[value] > len) {
				len = position - foundRemainders[value];
			}
		}
		return d;
	}

}
