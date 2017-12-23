package com.digiturtle.projects.day1;

import java.util.HashMap;

import com.digiturtle.projects.BasicProject;

public class Project14 implements BasicProject {

	public static void main(String[] args) {
		new Project14().run();
	}
	
	private HashMap<Long, Long> chainLengths;
	
	@Override
	public void run() {
		long n = 1, length = 1;
		chainLengths = new HashMap<>();
		chainLengths.put(1L, 1L);
		for (long i = 2; i <= 1_000_000; i++) {
			long len = chainLength(i);
			if (len > length) {
				n = i;
				length = len;
			}
		}
		System.out.println("N: " + n);
	}
	
	public long chainLength(long n) {
		if (!chainLengths.containsKey(n)) {
			long next = nextTerm(n);
			long length = 1 + chainLength(next);
			chainLengths.put(n, length);
		}
		return chainLengths.get(n);
	}
	
	private long nextTerm(long n) {
		if (n % 2 == 0) {
			return n / 2;
		}
		return 3 * n + 1;
	}

}
