package com.digiturtle.projects.day2;

import java.util.ArrayList;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.SieveOfEratosthenes;

public class Project35 implements BasicProject {

	public static void main(String[] args) {
		new Project35().run();
	}

	private SieveOfEratosthenes sieve = new SieveOfEratosthenes();	

	private ArrayList<Integer> primes = new ArrayList<>();

	@Override
	public void run() {
		int count = 2;
		sieve.computePrimes(1_000_000, this::prime);
		primes.sort(Integer::compare);
		primes.remove(new Integer(2));
		primes.remove(new Integer(5));
		while (primes.size() > 0) {
			count += getCircularPrimes(primes.get(0));
		}
		System.out.println("Circular Prime Count: " + count);
	}

	public int getCircularPrimes(int prime) {
		int multiplier = 1, number = prime, count = 0, d;
		// Count the digits and check for even numbers
		while (number > 0) {
			d = number % 10;
			if (d % 2 == 0 || d == 5) {
				primes.remove(new Integer(prime));
				return 0;
			}
			number /= 10;               
			multiplier *= 10;
			count++;
		}
		multiplier /= 10;
		// Rotate the number and check if they are prime
		number = prime;
		ArrayList<Integer> foundCircularPrimes = new ArrayList<Integer>();
		for (int i = 0; i < count; i++) {                               
			if (primes.contains(number)) {                    
				foundCircularPrimes.add(number);
				primes.remove(new Integer(number));
			} else if (!foundCircularPrimes.contains(number)) {             
				return 0;
			}

			d = number % 10;
			number = d * multiplier + number / 10;
		}
		return foundCircularPrimes.size();
	}

	public void prime(int prime) {
		primes.add(prime);
	}

}
