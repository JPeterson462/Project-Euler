package com.digiturtle.projects;

public class SieveOfEratosthenes {
	
	@FunctionalInterface
	public interface PrimeVisitor {
		
		public void visit(int prime);
		
	}
	
	public long computeLargestPrimeFactor(long n) {
		long largestPrime = 1;
		while (n % 2 == 0) {
			largestPrime = 2;
			n = n / 2;
		}
		for (long i = 3, max = (int) Math.sqrt(n); i <= max; i += 2) {
			while (n % i == 0) {
				largestPrime = i;
				n = n / i;
			}
		}
		return largestPrime;
	}
	
	public void computePrimes(long n, PrimeVisitor visitor) {
		boolean prime[] = new boolean[(int) (n + 1)];
		java.util.Arrays.fill(prime, true);
		for (int p = 2; p * p <= n; p++) {
			if (prime[p]) {
				for (int i = p * 2; i <= n; i += p) {
					prime[i] = false;
				}
			}
		}
		for (int i = 2; i <= n; i++) {
			if (prime[i]) {
				visitor.visit(i);
			}
		}
	}

}
