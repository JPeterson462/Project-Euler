package com.digiturtle.projects.day5;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.SieveOfEratosthenes;

public class Project60 implements BasicProject {

	public static void main(String[] args) {
		new Project60().run();
	}
	
	private ArrayList<Long> primes = new ArrayList<>();
	
	private SieveOfEratosthenes sieve = new SieveOfEratosthenes();
	
	@Override
	public void run() {
		try {
			System.setOut(new PrintStream(new FileOutputStream("p60.txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sieve.computePrimes(1_000_000, p -> primes.add(new Long(p)));
		for (int i = 0; i < primes.size(); i++) {
			for (int j = 0; j < i; j++) {
				if (primePair(primes.get(i), primes.get(j))) {
					for (int k = 0; k < j; k++) {
						if (primePair(primes.get(i), primes.get(k)) &&
								primePair(primes.get(j), primes.get(k))) {
							for (int l = 0; l < k; l++) {
								if (primePair(primes.get(i), primes.get(l)) &&
										primePair(primes.get(j), primes.get(l)) &&
										primePair(primes.get(k), primes.get(l))) {
									for (int m = 0; m < l; m++) {
										System.out.println(m);
										if (primePair(primes.get(i), primes.get(m)) &&
												primePair(primes.get(j), primes.get(m)) &&
												primePair(primes.get(k), primes.get(m)) &&
												primePair(primes.get(l), primes.get(m))) {
											System.out.println("Match: " + (primes.get(i) + primes.get(j) + primes.get(k) + primes.get(l) + primes.get(m)));
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	public boolean primePair(long a, long b) {
		String as = Long.toString(a), bs = Long.toString(b);
		StringBuilder s1 = new StringBuilder(as).append(bs);
		StringBuilder s2 = new StringBuilder(bs).append(as);
		return sieve.isPrime(Long.parseLong(s1.toString())) && sieve.isPrime(Long.parseLong(s2.toString()));
	}

}
