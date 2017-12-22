package com.digiturtle.projects.day1;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.SieveOfEratosthenes;

public class Project3 implements BasicProject {

	public static void main(String[] args) {
		new Project3().run();
	}
	
	@Override
	public void run() {
		SieveOfEratosthenes sieve = new SieveOfEratosthenes();
		long largestPrime = sieve.computeLargestPrimeFactor(600851475143L);
		System.out.println("Largest Prime Factor: " + largestPrime);
	}

}
