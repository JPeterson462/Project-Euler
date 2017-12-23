package com.digiturtle.projects.day1;

import com.digiturtle.projects.BasicProject;

public class Project24 implements BasicProject {

	public static void main(String[] args) {
		new Project24().run();
	}
	
	@Override
	public void run() {
		// There are 3,628,800 permutations
		
		// 362,880 starting with each letter
		// The millionth starts with 2
		// 1,000,000 - 725,760 = 274,240
		
		// 40,320 for the second letter
		// The millionth starts with 7
		// 32,320
		
		// 5,040 for the third letter
		// The millionth starts with 8
		// 32,320 - 30,240 = 2,080
		
		// 720 for the fourth letter
		// The millionth starts with 3
		// 2,080 - 1,440 = 640
		
		// 120 for the fifth letter
		// The millionth starts with 9
		// 640 - 600 = 40
		
		// 24 for the sixth letter
		// The millionth starts with 1
		// 40 - 24 = 16
		
		// 6 for the seventh letter
		// The millionth starts with 5
		// 16 - 12 = 4
		
		// 3 for the seventh letter
		// The millionth starts with 4
		// 4 - 3 = 1
		
		// 6 
		// 0
		
		//2783915460
	}

}
