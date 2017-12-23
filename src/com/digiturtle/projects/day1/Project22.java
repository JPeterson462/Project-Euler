package com.digiturtle.projects.day1;

import java.util.ArrayList;
import java.util.Arrays;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.Utils;

public class Project22 implements BasicProject {

	public static void main(String[] args) {
		new Project22().run();
	}
	
	@Override
	public void run() {
		String[] names = Utils.splitCommaSeparatedQuotes(Utils.join(Utils.readFile("names.txt"), ""));
		ArrayList<String> nameList = new ArrayList<>(Arrays.asList(names));
		nameList.sort((a, b) -> a.compareTo(b));
		int score = 0;
		for (int i = 0; i < nameList.size(); i++) {
			score += (i + 1) * score(nameList.get(i));
		}
		System.out.println("Score: " + score);
	}
	
	private int score(String name) {
		String letters = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int score = 0;
		for (int i = 0; i < name.length(); i++) {
			score += letters.indexOf(name.charAt(i));
		}
		return score;
	}

}
