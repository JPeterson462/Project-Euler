package com.digiturtle.projects.day1;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.Utils;

public class Project11 implements BasicProject {

	public static void main(String[] args) {
		new Project11().run();
	}
	
	@Override
	public void run() {
		String[] lines = Utils.readFile("Problem11.txt");
		int[][] grid = new int[lines.length][lines.length];
		for (int i = 0; i < lines.length; i++) {
			String line = lines[i];
			String[] numbers = line.split(" ");
			for (int j = 0; j < numbers.length; j++) {
				grid[i][j] = Integer.parseInt(numbers[j]);
			}
		}
		int maxProduct = 0;
		int[][] quad = new int[4][4];
		for (int i = 0; i < grid.length - quad.length; i++) {
			for (int j = 0; j < grid.length - quad.length; j++) {
				quad[0][0] = grid[i + 0][j + 0];
				quad[1][0] = grid[i + 1][j + 0];
				quad[2][0] = grid[i + 2][j + 0];
				quad[3][0] = grid[i + 3][j + 0];
				quad[0][1] = grid[i + 0][j + 1];
				quad[1][1] = grid[i + 1][j + 1];
				quad[2][1] = grid[i + 2][j + 1];
				quad[3][1] = grid[i + 3][j + 1];
				quad[0][2] = grid[i + 0][j + 2];
				quad[1][2] = grid[i + 1][j + 2];
				quad[2][2] = grid[i + 2][j + 2];
				quad[3][2] = grid[i + 3][j + 2];
				quad[0][3] = grid[i + 0][j + 3];
				quad[1][3] = grid[i + 1][j + 3];
				quad[2][3] = grid[i + 2][j + 3];
				quad[3][3] = grid[i + 3][j + 3];
				maxProduct = Math.max(maxProduct, maxProduct(quad));
			}
		}
		System.out.println("Max Product: " + maxProduct);
	}
	
	public int maxProduct(int[][] quad) {
		int col0 = quad[0][0] * quad[1][0] * quad[2][0] * quad[3][0];
		int col1 = quad[0][1] * quad[1][1] * quad[2][1] * quad[3][1];
		int col2 = quad[0][2] * quad[1][2] * quad[2][2] * quad[3][2];
		int col3 = quad[0][3] * quad[1][3] * quad[2][3] * quad[3][3];
		int maxCol = Math.max(col0, Math.max(col1, Math.max(col2, col3)));
		int row0 = quad[0][0] * quad[0][1] * quad[0][2] * quad[0][3];
		int row1 = quad[1][0] * quad[1][1] * quad[1][2] * quad[1][3];
		int row2 = quad[2][0] * quad[2][1] * quad[2][2] * quad[2][3];
		int row3 = quad[3][0] * quad[3][1] * quad[3][2] * quad[3][3];
		int maxRow = Math.max(row0, Math.max(row1, Math.max(row2, row3)));
		int diag0 = quad[0][0] * quad[1][1] * quad[2][2] * quad[3][3];
		int diag1 = quad[0][3] * quad[1][2] * quad[2][1] * quad[3][0];
		return Math.max(diag0, Math.max(diag1, Math.max(maxCol, maxRow)));
		
	}

}
