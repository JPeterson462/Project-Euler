package com.digiturtle.projects.day3;

import java.util.ArrayList;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.SieveOfEratosthenes;

public class Project46 implements BasicProject {

	public static void main(String[] args) {
		new Project46().run();
	}
	
	private ArrayList<Long> primes = new ArrayList<>();
	
	@Override
	public void run() {
		SieveOfEratosthenes sieve = new SieveOfEratosthenes();
		sieve.computePrimes(10_000, p -> primes.add(new Long(p)));
		int result = 1;
		boolean notFound = true;
		while (notFound) {
			result += 2;
			int j = 0;
			notFound = false;
			while (result >= primes.get(j)) { // Try all primes to see if one matches
				// If none are found notFound will be set to false indicating a solution found
				double x = Math.sqrt((result - primes.get(j)) / 2);
				if (x == (int) x) {
					notFound = true;
					break;
				}
				j++;
			}
		}
		System.out.println("Result: " + result);
	}
	
}
