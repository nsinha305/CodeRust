package strings;

import java.util.Scanner;

public class RemoveWhiteSpaces {

	static String removeWhiteSpaces(String s) {
		char[] ar = s.toCharArray();
		int write = 0;
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isWhitespace(s.charAt(i))) {
				ar[write] = s.charAt(i);
				write++;
			}
		}
		return new String(ar, 0, write);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		s = removeWhiteSpaces(s);
		System.out.println("The String without white spaces is : " + s);
		sc.close();
	}

}
