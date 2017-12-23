package com.digiturtle.projects;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Utils {
	
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
	
	public static String[] splitCommaSeparatedQuotes(String input) {
		String[] output = input.split(",");
		for (int i = 0; i < output.length; i++) {
			output[i] = output[i].substring(1, output[i].length() - 1);
		}
		return output;
	}
	
	public static boolean isPandigital(String str) {
		int upTo = str.length();
		for (int n = 1; n <= upTo; n++) {
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

}
