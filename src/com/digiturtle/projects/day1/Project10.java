package com.digiturtle.projects.day1;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.SieveOfEratosthenes;

public class Project10 implements BasicProject {

	public static void main(String[] args) {
		new Project10().run();
	}
	
	private long sum = 0;
	
	@Override
	public void run() {
		SieveOfEratosthenes sieve = new SieveOfEratosthenes();
		sieve.computePrimes(2_000_000, this::visitPrime);
		System.out.println("Sum: " + sum);
	}
	
	public void visitPrime(long prime) {
		sum += prime;
	}

}
