package com.digiturtle.projects.day2;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.SieveOfEratosthenes;
import com.digiturtle.projects.Utils;

public class Project41 implements BasicProject {

	public static void main(String[] args) {
		new Project41().run();
	}
	
	private int largestPrime = 0;
	
	@Override
	public void run() {
		SieveOfEratosthenes sieve = new SieveOfEratosthenes();
		sieve.computePrimes(10_000_000, this::visitPrime);
		System.out.println("Largest Pandigital Prime: " + largestPrime);
	}
	
	public void visitPrime(int prime) {
		if (Utils.isPandigital(String.valueOf(prime))) {
			largestPrime = prime;
		}
	}

}
