package com.digiturtle.projects.day3;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.SieveOfEratosthenes;

public class Project51 implements BasicProject {

	public static void main(String[] args) {
		new Project51().run();
	}

	private SieveOfEratosthenes sieve = new SieveOfEratosthenes();

	@Override
	public void run() {
		int[][] fiveDigitPattern = get5DigitPatterns();
		int[][] sixDigitPattern = get6DigitPatterns();
		int result = Integer.MAX_VALUE;

		for (int i = 11; i < 1000; i += 2) {

			//Only 1,3,7,9 are valid endings
			if (i % 5 == 0) continue;

			int[][] patterns = (i < 100) ?
					fiveDigitPattern : sixDigitPattern;

			for(int j = 0; j < patterns.length; j++) {
				for(int k = 0; k <= 2; k++){

					//Don't generate candidates with leading zero
					if (patterns[j][0] == 0 && k == 0) continue;

					int[] pattern = fillPattern(patterns[j], i);
					int candidate = generateNumber(k, pattern);

					if (candidate < result && sieve.isPrime(candidate)) {
						if (familySize(k, pattern) == 8 )
							result = candidate;
						break;
					}
				}
			}
		}
		
		System.out.println("Result: " + result);
	}

	private int[][] get5DigitPatterns() {
		// Generate all bitmasks
		int[][] retVal = new int[4][];
		retVal[0] = new int[]{1,0,0,0,1};
		retVal[1] = new int[]{0,1,0,0,1};
		retVal[2] = new int[]{0,0,1,0,1};
		retVal[3] = new int[]{0,0,0,1,1};
		return retVal;
	}

	private int[][] get6DigitPatterns() {
		// Generate all bitmasks
		int[][] retVal = new int[10][];
		retVal[0] = new int[] { 1, 1, 0, 0, 0, 1 };
		retVal[1] = new int[] { 1, 0, 1, 0, 0, 1 };
		retVal[2] = new int[] { 1, 0, 0, 1, 0, 1 };
		retVal[3] = new int[] { 1, 0, 0, 0, 1, 1 };
		retVal[4] = new int[] { 0, 1, 1, 0, 0, 1 };
		retVal[5] = new int[] { 0, 1, 0, 1, 0, 1 };
		retVal[6] = new int[] { 0, 1, 0, 0, 1, 1 };
		retVal[7] = new int[] { 0, 0, 1, 1, 0, 1 };
		retVal[8] = new int[] { 0, 0, 1, 0, 1, 1 };
		retVal[9] = new int[] { 0, 0, 0, 1, 1, 1 };
		return retVal;
	}

	private int[] fillPattern(int[] pattern, int number) {
		// Fill in the number using the given bitmask
		int[] filledPattern = new int[pattern.length];
		int temp = number;

		for (int i = filledPattern.length - 1; 0 <= i; i--) {
			if (pattern[i] == 1) {
				filledPattern[i] = temp % 10;
				temp /= 10;
			} else {
				filledPattern[i] = -1;
			}
		}
		return filledPattern;
	}

	private int generateNumber(int repNumber, int[] filledPattern) {
		// Fill in the number using the given bitmask
		int temp = 0;
		for (int i = 0; i < filledPattern.length; i++) {
			temp = temp * 10;
			temp += (filledPattern[i] == -1) ?
					repNumber : filledPattern[i];
		}
		return temp;
	}

	private int familySize(int repeatingNumber, int[] pattern) {
		// Count the number of primes associated with the given bitmask
		int familySize = 1;
		for (int i = repeatingNumber + 1; i < 10; i++) {
			if (sieve.isPrime(generateNumber(i, pattern))) {
				familySize++;
			}
		}
		return familySize;
	}

}
