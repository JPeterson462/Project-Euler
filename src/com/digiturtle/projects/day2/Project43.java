package com.digiturtle.projects.day2;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.Utils;

public class Project43 implements BasicProject {

	public static void main(String[] args) {
		new Project43().run();
	}
	
	@Override
	public void run() {
		/*long sum = 0;
		for (long n = 123456789; n <= 9876543210L; n++) {
			String str = String.valueOf(n);
			if (str.length() == 9) {
				str = "0" + str;
			}
			System.out.println(n);
			if (str.length() == 10 && Utils.isPandigital(str)) {
				int d234 = Integer.parseInt(str.substring(1, 4));
				int d345 = Integer.parseInt(str.substring(2, 5));
				int d456 = Integer.parseInt(str.substring(3, 6));
				int d567 = Integer.parseInt(str.substring(4, 7));
				int d678 = Integer.parseInt(str.substring(5, 8));
				int d789 = Integer.parseInt(str.substring(6, 9));
				int d890 = Integer.parseInt(str.substring(7, 10));
				if (d234 % 2 == 0 && d345 % 3 == 0 && d456 % 5 == 0 &&
						d567 % 7 == 0 && d678 % 11 == 0 && d789 % 13 == 0 &&
						d890 % 17 == 0) {
					sum += n;
				}
			}
		}
		System.out.println("Sum: " + sum);*/
		// d4 = 0,2,4,6,8
		// d6 = 0,5
		long sum = 0;
		for (int d1 = 0; d1 < 10; d1++) {
			for (int d2 = 0; d2 < 10; d2++) {
				if (d2 == d1) continue;
				for (int d3 = 0; d3 < 10; d3++) {
					if (d3 == d2 || d3 == d1) continue;
					for (int d4 = 0; d4 < 10; d4 += 2) {
						if (d4 == d3 || d4 == d2 || d4 == d1) continue;
						for (int d5 = 0; d5 < 10; d5++) {
							if (d5 == d4 || d5 == d3 || d5 == d2 || d5 == d1) continue;
							for (int d6 = 0; d6 < 10; d6 += 5) {
								if (d6 == d5 || d6 == d4 || d6 == d3 || d6 == d2 || d6 == d1) continue;
								for (int d7 = 0; d7 < 10; d7++) {
									if (d7 == d6 || d7 == d5 || d7 == d4 || d7 == d3 || d7 == d2 || d7 == d1) continue;
									for (int d8 = 0; d8 < 10; d8++) {
										if (d8 == d7 || d8 == d6 || d8 == d5 || d8 == d4 || d8 == d3 || d8 == d2 || d8 == d1) continue;
										for (int d9 = 0; d9 < 10; d9++) {
											if (d9 == d8 || d9 == d7 || d9 == d6 || d9 == d5 || d9 == d4 || d9 == d3 || d9 == d2 || d9 == d1) continue;
											for (int d10 = 0; d10 < 10; d10++) {
												if (d10 == d9 || d10 == d8 || d10 == d7 || d10 == d6 || d10 == d5 || d10 == d4 || d10 == d3 || d10 == d2 || d10 == d1) continue;
												String str = "" + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9 + d10;
												if (str.length() == 10 && Utils.isPandigital(str)) {
													int d234 = Integer.parseInt(str.substring(1, 4));
													int d345 = Integer.parseInt(str.substring(2, 5));
													int d456 = Integer.parseInt(str.substring(3, 6));
													int d567 = Integer.parseInt(str.substring(4, 7));
													int d678 = Integer.parseInt(str.substring(5, 8));
													int d789 = Integer.parseInt(str.substring(6, 9));
													int d890 = Integer.parseInt(str.substring(7, 10));
													if (d234 % 2 == 0 && d345 % 3 == 0 && d456 % 5 == 0 &&
															d567 % 7 == 0 && d678 % 11 == 0 && d789 % 13 == 0 &&
															d890 % 17 == 0) {
														sum += Long.parseLong(str);
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println("Sum: " + sum);
	}

}
