package com.digiturtle.projects.day2;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.Utils;

public class Project33 implements BasicProject {

	public static void main(String[] args) {
		new Project33().run();
	}
	
	@Override
	public void run() {
		int den = 1, nom = 1;
		for (int i = 1; i < 10; i++) {
			for (int a = 1; a < i; a++) {
				for (int b = 1; b < a; b++) {
					if ((b * 10 + i) * a == b * (i * 10 + a)) {
						den *= a;
						nom *= b;
					}
				}
			}
		}
		System.out.println("Product: " + (den / Utils.gcd(nom, den)));
	}

}
