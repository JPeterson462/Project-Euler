package com.digiturtle.projects.day1;

import java.util.HashMap;

import com.digiturtle.projects.BasicProject;

public class Project14 implements BasicProject {

	public static void main(String[] args) {
		new Project14().run();
	}
	
	private HashMap<Integer, Integer> chainLengths;
	
	@Override
	public void run() {
		int n = 1, length = 1;
		chainLengths = new HashMap<>();
		for (int i = 1; i <= 1_000_000; i++) {
			int len = chainLength(i);
			if (len > length) {
				n = i;
				length = len;
			}
		}
		System.out.println("N: " + n);
	}
	
	public int chainLength(int n) {
		if (n <= 1) {
			return 1;
		}
		if (!chainLengths.containsKey(n)) {
			int next = nextTerm(n);
			System.out.println(n + ", " + next);
			int length = 1 + chainLength(next);
			chainLengths.put(n, length);
		}
		return chainLengths.get(n);
	}
	
	private int nextTerm(int n) {
		if (n % 2 == 0) {
			return n / 2;
		}
		return 3 * n + 1;
	}

}
