package com.digiturtle.projects.day1;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.SieveOfEratosthenes;

public class Project7 implements BasicProject {

	public static void main(String[] args) {
		new Project7().run();
	}
	
	private int primesVisited = 0, prime = 0;
	
	@Override
	public void run() {
		SieveOfEratosthenes sieve = new SieveOfEratosthenes();
		sieve.computePrimes(999_999, this::visitPrime);
		System.out.println("Prime: " + prime);
	}
	
	public void visitPrime(int prime) {
		if (primesVisited == 10_000) {
			this.prime = prime;
		}
		System.out.println(primesVisited);
		primesVisited++;
	}

}
