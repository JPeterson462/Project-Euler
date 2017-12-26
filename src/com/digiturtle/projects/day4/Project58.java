package com.digiturtle.projects.day4;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.SieveOfEratosthenes;

public class Project58 implements BasicProject {

	public static void main(String[] args) {
		new Project58().run();
	}
	
	@Override
	public void run() {
		// Lowest Corner
		// =  1 3  13 31
		// +  2 10 18
		// +    8  8
		// Layer
		//    1 2  3  4
		SieveOfEratosthenes sieve = new SieveOfEratosthenes();
		int start = 3;
		double primes = 0, nonPrimes = 1;
		for (long layer = 2; true; layer++) {
			long delta = 2 * layer - 2;
			long corner1 = start, corner2 = start + delta, 
					corner3 = start + 2 * delta, corner4 = start + 3 * delta;
			double ratio = primes / (primes + nonPrimes);
			if (ratio > 0 && ratio < 0.1) {
				break;
			}
			if (sieve.isPrime(corner1))
				primes++;
			else
				nonPrimes++;
			if (sieve.isPrime(corner2))
				primes++;
			else
				nonPrimes++;
			if (sieve.isPrime(corner3))
				primes++;
			else
				nonPrimes++;
			if (sieve.isPrime(corner4))
				primes++;
			else
				nonPrimes++;
			start += 8 * layer - 6;
			System.out.println(layer * 2 - 1);
		}
	}

}
