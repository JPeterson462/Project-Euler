package com.digiturtle.projects.day2;

import java.util.ArrayList;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.SieveOfEratosthenes;

public class Project37 implements BasicProject {

	public static void main(String[] args) {
		new Project37().run();
	}
	
	private SieveOfEratosthenes sieve = new SieveOfEratosthenes();
	
	private ArrayList<Integer> truncatable = new ArrayList<>();
	
	@Override
	public void run() {
		sieve.computePrimes(1_000_000, this::visitPrime);
		System.out.println(truncatable);
		int sum = 0;
		for (int truncated : truncatable) {
			sum += truncated;
		}
		System.out.println("Sum: " + sum);
	}
	
	public void visitPrime(int prime) {
		if (prime < 10) {
			return;
		}
		String str = String.valueOf(prime);
		while (str.length() > 0) {
			if (!sieve.isPrime(Integer.parseInt(str))) {
				return;
			}
			str = str.substring(1);
		}
		str = String.valueOf(prime);
		while (str.length() > 0) {
			if (!sieve.isPrime(Integer.parseInt(str))) {
				return;
			}
			str = str.substring(0, str.length() - 1);
		}
		truncatable.add(prime);
	}

}
