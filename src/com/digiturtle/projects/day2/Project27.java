package com.digiturtle.projects.day2;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.SieveOfEratosthenes;

public class Project27 implements BasicProject {

	public static void main(String[] args) {
		new Project27().run();
	}
	
	private SieveOfEratosthenes sieve = new SieveOfEratosthenes();
	
	@Override
	public void run() {
		long ab = 0, maxPrimes = -Long.MAX_VALUE;
		for (int a = -1000; a <= 1000; a++) {
			for (int b = -1000; b <= 1000; b++) {
				long primes = countPrimes(a, b);
				if (primes > maxPrimes) {
					maxPrimes = primes;
					ab = a * b;
				}
			}
		}
		System.out.println("Maximum Coefficients: " + ab + ", Maximum Primes: " + maxPrimes);
	}
	
	private long countPrimes(int a, int b) {
		long n = 0;
		while (sieve.isPrime(Math.abs(n * n + a * n + b))) {
			n++;
		}
		return n;
	}

}
