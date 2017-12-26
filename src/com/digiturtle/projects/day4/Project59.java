package com.digiturtle.projects.day4;

import com.digiturtle.projects.BasicProject;
import com.digiturtle.projects.Utils;

public class Project59 implements BasicProject {

	public static void main(String[] args) {
		new Project59().run();
	}
	
	@Override
	public void run() {
//		try {
//			System.setOut(new PrintStream(new FileOutputStream("p59.txt")));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		String line = Utils.readFile("cipher.txt")[0];
		String[] parts = line.split(",");
		int[] chars = new int[parts.length];
		for (int i = 0 ; i < chars.length; i++) {
			chars[i] = Integer.parseInt(parts[i]);
		}
/*		for (char c1 = 'a'; c1 <= 'z'; c1++) {
			for (char c2 = 'a'; c2 <= 'z'; c2++) {
				for (char c3 = 'a'; c3 <= 'z'; c3++) {
//					System.out.println("" + c1 + c2 + c3 + ": " + decrypt(chars, c1, c2, c3));
					String decrypted = decrypt(chars, c1, c2, c3);
					if (decrypted != null) {
						System.out.println("" + c1 + c2 + c3 + ": " + decrypted);
					}
				}
			}
		}
		// After analysis, only four possibilities remained and 'god' decrypted best
*/
		String decrypted = decrypt(chars, 'g', 'o', 'd');
		int sum = 0;
		for (int i = 0; i < decrypted.length(); i++) {
			sum += (int) decrypted.charAt(i);
		}
		System.out.println("Sum: " + sum);
	}
	
	public String decrypt(int[] chars, char c1, char c2, char c3) {
		char[] decrypted = new char[chars.length];
		for (int i = 0; i < decrypted.length; i++) {
			int key = 0;
			if (i % 3 == 0)
				key = (int) c1;
			if (i % 3 == 1)
				key = (int) c2;
			if (i % 3 == 2)
				key = (int) c3;
			decrypted[i] = (char) (chars[i] ^ key);
			if ((int) decrypted[i] < 32) {
				return null;
			}
			if ((int) decrypted[i] >= 127) {
				return null;
			}
			if ((int) decrypted[i] == 96) {
				return null;
			}
		}
		return new String(decrypted);
	}

}
