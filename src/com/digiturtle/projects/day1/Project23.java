package com.digiturtle.projects.day1;

import java.util.ArrayList;
import java.util.HashSet;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.Utils;

public class Project23 implements BasicProject {
	
	public static void main(String[] args) {
		new Project23().run();
	}

	@Override
	public void run() {
		ArrayList<Integer> abundants = new ArrayList<>();
		HashSet<Integer> results = new HashSet<>();
		for (int i = 2; i <= 28123; i++) {
			if (abundant(i)) {
				abundants.add(i);
			}
		}
		for (int a = 0; a < abundants.size(); a++) {
			for (int b = 0; b <= a; b++) {
				int sum = abundants.get(a) + abundants.get(b);
				results.add(sum);
			}
		}
		long sum = 0;
		for (int i = 1; i <= 28123; i++) {
			if (!results.contains(i)) {
				sum += i;
			}
		}
		System.out.println("Sum: " + sum);
	}
	
	public boolean abundant(int n) {
		return Utils.sumDivisors(n) > n;
	}

}
