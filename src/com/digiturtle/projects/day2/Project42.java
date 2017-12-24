package com.digiturtle.projects.day2;

import java.util.ArrayList;
import java.util.Arrays;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.Utils;

public class Project42 implements BasicProject {

	public static void main(String[] args) {
		new Project42().run();
	}
	
	@Override
	public void run() {
		String letters = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String[] words = Utils.splitCommaSeparatedQuotes(Utils.join(Utils.readFile("words.txt"), ""));
		ArrayList<String> wordList = new ArrayList<>(Arrays.asList(words));
		int triangleWords = 0;
		for (String word : wordList) {
			int sum = 0;
			for (char letter : word.toCharArray()) {
				sum += letters.indexOf(letter);
			}
			// n^2/2 + n/2 = sum
			float[] solutions = Utils.solveQuadraticEquation(0.5f, 0.5f, -sum);
			if ((solutions[0] > 0 && Utils.isInteger(solutions[0])) ||
					(solutions[1] > 0 && Utils.isInteger(solutions[1]))) {
				triangleWords++;
			}
		}
		System.out.println("Triangle Words: " + triangleWords);
	}

}
