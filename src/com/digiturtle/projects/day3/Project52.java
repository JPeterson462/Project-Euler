package com.digiturtle.projects.day3;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.Utils;

public class Project52 implements BasicProject {

	public static void main(String[] args) {
		new Project52().run();
	}
	
	@Override
	public void run() {
		for (int i = 1; i < 1_000_000; i++) {
			int i1 = i * 1, i2 = i * 2, i3 = i * 3;
			int i4 = i * 4, i5 = i * 5, i6 = i * 6;
			if (Utils.isPermutation(i1 + "", i2 + "") && Utils.isPermutation(i2 + "", i3 + "") &&
				Utils.isPermutation(i3 + "", i4 + "") && Utils.isPermutation(i4 + "", i5 + "") &&
				Utils.isPermutation(i5 + "", i6 + "")) {
				System.out.println(i1);
			}
		}
	}

}
