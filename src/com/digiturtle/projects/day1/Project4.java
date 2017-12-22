package com.digiturtle.projects.day1;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.Utils;

public class Project4 implements BasicProject {

	public static void main(String[] args) {
		new Project4().run();
	}
	
	@Override
	public void run() {
		int largestPalindrome = 1;
		for (int a = 0; a < 1000; a++) {
			for (int b = 0; b < 1000; b++) {
				int combined = a * b;
				if (combined > largestPalindrome) {
					String str = String.valueOf(combined);
					if (Utils.isPalindrome(str)) {
						largestPalindrome = combined;
					}
				}
			}
		}
		System.out.println("Largest Palindrome: " + largestPalindrome);
	}

}
