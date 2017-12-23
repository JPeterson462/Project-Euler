package com.digiturtle.projects.day2;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.SieveOfEratosthenes;

public class Project35 implements BasicProject {
	
	public static void main(String[] args) {
		new Project35().run();
	}
	
	private SieveOfEratosthenes sieve = new SieveOfEratosthenes();	

	@Override
	public void run() {
		int count = 0;
		for (int n = 1; n < 1_000; n++) {
			if (circularPrime(n)) {
				System.out.println(n);
				count++;
			}
		}
		System.out.println("Circular Prime Count: " + count);
	}
	
	public boolean circularPrime(int prime) {
		int n = prime, count = 0;
		while (n > 0) {
			n /= 10;
			count++;
		}
		n = prime;
		for (int i = 0; i < count; i++) {
			if (sieve.isPrime(n)) {
				String ns = "" + n;
				ns = ns.substring(1) + ns.charAt(0);
				n = Integer.parseInt(ns);
			} else {
				return false;
			}
		}
		return true;
	}

}
