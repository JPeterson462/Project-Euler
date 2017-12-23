package com.digiturtle.projects.day1;

import com.digiturtle.projects.BasicProject;

public class Project17 implements BasicProject {

	public static void main(String[] args) {
		new Project17().run();
	}
	
	@Override
	public void run() {
		String thousand = "onethousand";
		String full = thousand;
		for (int i = 1; i < 1000; i++) {
			full += getNumber(i);
		}
		System.out.println("Letters: " + full.length());
	}
	
	public String getNumber(int n) {
		int hundred = ((n - n % 100) / 100) % 10;
		int ten = ((n - n % 10) / 10) % 10;
		int ones = n % 10;
		String full = "";
		if (hundred > 0) {
			full += getDigit(hundred) + "hundred";
		}
		if ((ten > 0 || ones > 0) && hundred > 0) {
			full += "and";
		}
		if (ten == 1) {
			full += getTeensDigit(ones);
		} else if (ten > 1) {
			full += getTensDigit(ten) + getDigit(ones);
		} else {
			full += getDigit(ones);
		}
		System.out.println(n + " -> " + full);
		return full;
	}
	
	public String getTeensDigit(int n) {
		switch (n) {
			case 0:
				return "ten";
			case 1:
				return "eleven";
			case 2:
				return "twelve";
			case 3:
				return "thirteen";
			case 4:
				return "fourteen";
			case 5:
				return "fifteen";
			case 6:
				return "sixteen";
			case 7:
				return "seventeen";
			case 8:
				return "eighteen";
			case 9:
				return "nineteen";
		}
		return "";
	}
	
	public String getTensDigit(int n) {
		switch (n) {
			case 1:
				return "";
			case 2:
				return "twenty";
			case 3:
				return "thirty";
			case 4:
				return "forty";
			case 5:
				return "fifty";
			case 6:
				return "sixty";
			case 7:
				return "seventy";
			case 8:
				return "eighty";
			case 9:
				return "ninety";
	}
	return "";
	}
	
	public String getDigit(int n) {
		switch (n) {
			case 1:
				return "one";
			case 2:
				return "two";
			case 3:
				return "three";
			case 4:
				return "four";
			case 5:
				return "five";
			case 6:
				return "six";
			case 7:
				return "seven";
			case 8:
				return "eight";
			case 9:
				return "nine";
		}
		return "";
	}

}
