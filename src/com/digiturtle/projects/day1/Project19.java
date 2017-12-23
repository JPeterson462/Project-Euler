package com.digiturtle.projects.day1;

import com.digiturtle.projects.BasicProject;

public class Project19 implements BasicProject {

	public static void main(String[] args) {
		new Project19().run();
	}
	
	@Override
	public void run() {
		int sundays = 0;
		int day = 1;
		day = dayOfYear(day, 1900);
		for (int year = 1901; year <= 2000; year++) {
			for (int month = 0; month < 12; month++) {
				if (day == 0) {
					sundays++;
				}
				day = dayOfWeek(day, daysInMonth(month, year));
			}
		}
		System.out.println("Sundays: " + sundays);
	}
	
	public boolean isLeapYear(int year) {
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				return year % 400 == 0;
			}
			return true;
		}
		return false;
	}
	
	public int dayOfYear(int before, int year) {
		for (int month = 0; month < 12; month++) {
			before = dayOfWeek(before, daysInMonth(month, year));
		}
		return before;
	}
	
	// 0 = January, 11 = December
	public int daysInMonth(int month, int year) {
		switch (month) {
			// January, March, May, July, August, October, December
			case 0: case 2: case 4: case 6: case 7: case 9: case 11:
				return 31;
			case 1:
				return isLeapYear(year) ? 29 : 28;
		}
		return 30;
	}
	
	// 0 = Sunday, 6 = Saturday
	public int dayOfWeek(int before, int daysInMonth) {
		return (before + daysInMonth) % 7;
	}
	
}
