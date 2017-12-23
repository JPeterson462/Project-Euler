package com.digiturtle.projects.day1;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.Utils;

public class Project18 implements BasicProject {

	public static void main(String[] args) {
		new Project18().run();
	}
	
	@Override
	public void run() {
		String[] lines = Utils.readFile("Problem18.txt");
		int[][] grid = new int[lines.length][lines.length];
		for (int i = 0; i < lines.length; i++) {
			String[] parts = lines[i].split(" ");
			for (int j = 0; j < parts.length; j++) {
				grid[i][j] = Integer.parseInt(parts[j]);
			}
			for (int j = parts.length; j < lines.length; j++) {
				grid[i][j] = 0;
			}
		}
		for (int i = lines.length - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				grid[i][j] = grid[i][j] + Math.max(grid[i + 1][j], grid[i + 1][j + 1]);
			}
		}
		System.out.println(grid[0][0]);
	}

}
