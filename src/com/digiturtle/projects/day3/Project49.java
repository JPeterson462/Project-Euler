package com.digiturtle.projects.day3;

import java.util.ArrayList;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.SieveOfEratosthenes;
import com.digiturtle.projects.Utils;

public class Project49 implements BasicProject {

	public static void main(String[] args) {
		new Project49().run();
	}
	
	private ArrayList<Long> primes = new ArrayList<>();
	
	@Override
	public void run() {
		SieveOfEratosthenes sieve = new SieveOfEratosthenes();
		sieve.computePrimes(10_000, p -> primes.add(new Long(p)));
		for (int i = 0; i < primes.size(); i++) {
			for (int j = 0; j < i; j++) {
				long pi = primes.get(i), pj = primes.get(j);
				long pk = pi + (pi - pj);
				if (primes.contains(new Long(pk))) {
					if (Utils.isPermutation(pi + "", pj + "") && Utils.isPermutation(pj + "", pk + "")) {
						System.out.println(pk + ", " + pj + ", " + pi);
					}
				}
			}
		}
	}

}
