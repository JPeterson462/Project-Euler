package com.digiturtle.projects.day2;

import java.util.HashSet;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.Utils;

public class Project32 implements BasicProject {

	public static void main(String[] args) {
		new Project32().run();
	}
	
	@Override
	public void run() {
		HashSet<Long> products = new HashSet<>();
		long sum = 0;
		for (long a = 1; a <= 99; a++) {
			for (long b = a > 9 ? 123 : 1234; b <= 10_000 / a + 1; b++) {
				long product = a * b;
				String num = a + "" + b + "" + product;
				if (num.length() == 9 && Utils.isPandigital(num)) {
					products.add(product);
					System.out.println(product);
				}
			}
		}
		for (long product : products) {
			sum += product;
		}
		System.out.println("Sum: " + sum);
	}

}
