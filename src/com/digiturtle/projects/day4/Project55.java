package com.digiturtle.projects.day4;

import java.math.BigInteger;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.Utils;

public class Project55 implements BasicProject {

	public static void main(String[] args) {
		new Project55().run();
	}
	
	@Override
	public void run() {
		int count = 0;
		for (int n = 1; n <= 10_000; n++) {
			BigInteger b = new BigInteger("" + n);
			if (isLychrel(b)) {
				count++;
			}
		}
		System.out.println("Count: " + count);
	}
	
	public boolean isLychrel(BigInteger b) {
		for (int i = 1; i <= 50; i++) {
			b = lychrel(b);
			if (Utils.isPalindrome(b.toString())) {
				return false;
			}
		}
		return true;
	}
	
	public BigInteger lychrel(BigInteger n) {
		BigInteger b = new BigInteger(Utils.reverse(n.toString()));
		return b.add(n);
	}

}
