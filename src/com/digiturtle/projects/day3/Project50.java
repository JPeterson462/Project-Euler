package com.digiturtle.projects.day3;

import java.util.ArrayList;
import java.util.Collections;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.SieveOfEratosthenes;

public class Project50 implements BasicProject {

	public static void main(String[] args) {
		new Project50().run();
	}
	
	private ArrayList<Long> primes = new ArrayList<>();
	
	@Override
	public void run() {
		SieveOfEratosthenes sieve = new SieveOfEratosthenes();
		sieve.computePrimes(1_000_000, p -> primes.add(new Long(p)));
		primes.sort(Long::compare);
		long[] primeSum = new long[primes.size() + 1];
		primeSum[0] = 0;
		for (int i = 0; i < primes.size(); i++) {
			// Cache pre-computed prime sums
			primeSum[i + 1] = primeSum[i] + primes.get(i);
		}
		int numberOfPrimes = 0;
		long result = 0;
		for (int i = numberOfPrimes; i < primeSum.length; i++) {
			for (int j = i - numberOfPrimes - 1; j >= 0; j--) {
				if (primeSum[i] - primeSum[j] > 1_000_000) {
					break;
				}
				if (Collections.binarySearch(primes, primeSum[i] - primeSum[j]) >= 0) {
					numberOfPrimes = i - j;
					result = primeSum[i] - primeSum[j];
				}
			}
		}
		System.out.println("Result: " + result);
		
	}
	
}
