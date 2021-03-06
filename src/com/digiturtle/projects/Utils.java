package com.digiturtle.projects;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Utils {

	public static boolean isPalindrome(int n) {
		return isPalindrome(Integer.toString(n));
	}
	
	public static boolean isPalindrome(String str) {
		for (int i = 0; i < str.length() / 2 + 1; i++) {
			int j = str.length() - i - 1;
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}
		return true;
	}

	public static String[] readFile(String filename) {
		ArrayList<String> lines = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {
			for (String line = reader.readLine(); line != null; line = reader.readLine()) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines.toArray(new String[0]);
	}

	public static String join(String[] array, String by) {
		String str = "";
		for (int i = 0; i < array.length; i++) {
			if (i > 0) {
				str += by;
			}
			str += array[i];
		}
		return str;
	}

	public static int countDivisors(int n) {
		int divisors = 0;
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				if (n / i == i) {
					divisors++;
				} else {
					divisors += 2;
				}
			}
		}
		return divisors;
	}

	public static int sumDivisors(int n) {
		int sum = 1, max = (int) Math.sqrt(n);
		for (int i = 2; i <= max; i++) {
			if (n % i == 0) {
				sum += i;
				int inv = n / i;
				if (inv != i) {
					sum += inv;
				}
			}
		}
		return sum;
	}

	public static int primeFactors(int n) {
		int count = 0;
		if (n % 2 == 0) {
			count++;
		}
		while (n % 2 == 0) {
			n /= 2;
		}
		for (int i = 3; i <= Math.sqrt(n); i+= 2) {
			if (n % i == 0) {
				count++;
			}
			while (n % i == 0) {
				n /= i;
			}
		}
		if (n > 2) {
			count++;
		}
		return count;
	}

	public static String[] splitCommaSeparatedQuotes(String input) {
		String[] output = input.split(",");
		for (int i = 0; i < output.length; i++) {
			output[i] = output[i].substring(1, output[i].length() - 1);
		}
		return output;
	}

	public static boolean isPandigital(String str) {
		return isPandigital(str, 1);
	}

	public static boolean isPandigital(String str, int start) {
		int upTo = str.length();
		for (int n = start; n <= upTo; n++) {
			if (str.indexOf(String.valueOf(n).charAt(0)) < 0) {
				return false;
			}
		}
		return true;
	}

	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}

	public static int factorial(int n) {
		int prod = 1;
		int i = n;
		while (i > 0) {
			prod *= i;
			i--;
		}
		return prod;
	}

	public static float[] solveQuadraticEquation(float a, float b, float c) {
		// solution = (-b +- sqrt(b^2 - 4ac))/2a
		float solPos = (float) ((-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a));
		float solNeg = (float) ((-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a));
		return new float[] { solPos, solNeg };
	}

	public static boolean isInteger(float val) {
		return (int) val == val;
	}
	
	public static boolean isPermutation(String s0, String s1) {
		char[] c0 = s0.toCharArray(), c1 = s1.toCharArray();
		Arrays.sort(c0);
		Arrays.sort(c1);
		return Arrays.equals(c0, c1);
	}
	
	public static String and(String s0, String s1, int[] mask) {
		String str = "";
		for (int i = 0; i < mask.length; i++) {
			if (mask[i] > 0) {
				str += s0.charAt(i);
			} else {
				str += s1.charAt(i);
			}
		}
		return str;
	}
	
	public static int[] getMask(String str, int length) {
		int[] mask = new int[length];
		for (int i = 0; i < length - str.length(); i++) {
			mask[i] = 0;
		}
		for (int i = length - str.length(); i < length; i++) {
			mask[i] = Integer.parseInt("" + str.charAt(i - (length - str.length())));
		}
		return mask;
	}
	
	public static String sortLetters(String str) {
		char[] letters = str.toCharArray();
		char[] result = Arrays.copyOf(letters, letters.length);
		Arrays.sort(result);
		return new String(result);
	}
	
	public static long reverse(long n) {
		long num = 0;
		while (n > 0) {
			long digit = n % 10;
			num = num * 10 + digit;
			n = (n - digit) / 10;
		}
		return num;
	}
	
	public static String reverse(String str) {
		char[] c = new char[str.length()];
		for (int i = 0; i < c.length; i++) {
			c[i] = str.charAt(c.length - i - 1);
		}
		return new String(c);
	}
	
	public static int sumDigits(String str) {
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += Integer.parseInt(str.charAt(i) + "");
		}
		return sum;
	}
	
	public static long[] toFractionPos(BigDecimal x) {
        String[] parts = x.toString().split("\\.");
        BigDecimal den = BigDecimal.TEN.pow(parts[1].length()); // denominator
        BigDecimal num = (new BigDecimal(parts[0]).multiply(den)).add(new BigDecimal(parts[1])); // numerator
        return reduceFraction(num.longValue(), den.longValue());
    }

    public static long[] reduceFraction(long num, long den) {
        long gcd = BigInteger.valueOf(num).gcd(BigInteger.valueOf(den)).longValue(); // greatest
        long[] rf = { num / gcd, den / gcd };
        return rf;
    }
    
    public static int countDigits(long d) {
    	int count = 0;
    	while (d > 0) {
    		d = (d - d % 10) / 10;
    		count++;
    	}
    	return count;
    }

}
