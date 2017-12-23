package com.digiturtle.projects.day2;

import com.digiturtle.projects.BasicProject;

public class Project31 implements BasicProject {
	
	public static void main(String[] args) {
		new Project31().run();
	}

	@Override
	public void run() {
		int ways = 0;
		for (int d1 = 0; d1 <= 200; d1++) {
			for (int d2 = 0; d2 <= (200 - d1) / 2; d2++) {
				for (int d5 = 0; d5 <= (200 - d1 - 2 * d2) / 5; d5++) {
					for (int d10 = 0; d10 <= (200 - d1 - 2 * d2 - 5 * d5) / 10; d10++) {
						for (int d20 = 0; d20 <= (200 - d1 - 2 * d2 - 5 * d5 - 10 * d10) / 20; d20++) {
							for (int d50 = 0; d50 <= (200 - d1 - 2 * d2 - 5 * d5 - 10 * d10 - 20 * d20) / 50; d50++) {
								for (int d100 = 0; d100 <= (200 - d1 - 2 * d2 - 5 * d5 - 10 * d10 - 20 * d20 - 50 * d50) / 100; d100++) {
									for (int d200 = 0; d200 <= (200 - d1 - 2 * d2 - 5 * d5 - 10 * d10 - 20 * d20 - 50 * d50 - 100 * d100) / 200; d200++) {
										if (d1 + 2 * d2 + 5 * d5 + 10 * d10 + 20 * d20 + 50 * d50 + 100 * d100 + 200 * d200 == 200) {
											ways++;
											System.out.println("Solution!");
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println("Ways: " + ways);
	}

}
