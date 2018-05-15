package strings;

import java.util.Scanner;

public class RegularExpression {

	static boolean match(String text, String pattern, int i, int j) {
		if (i == text.length() && j == pattern.length())
			return true;
		if (j < pattern.length() - 1 && pattern.charAt(j + 1) == '*') {
			for (int k = i; k <= text.length(); k++) {
				if (match(text, pattern, k, j + 2))
					return true;
				if (k >= text.length())
					return false;
				if (pattern.charAt(j) != '.' && pattern.charAt(j) != text.charAt(k))
					return false;
			}
		} else if (i < text.length() && j < pattern.length()
				&& (pattern.charAt(j) == '.' || pattern.charAt(j) == text.charAt(i)))
			return match(text, pattern, i + 1, j + 1);
		return false;
	}

	static boolean match(String text, String pattern) {
		return match(text, pattern, 0, 0);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.next();
		String pattern = sc.next();
		boolean isMatch = match(text, pattern);
		System.out.println("String : " + text + " is a match for Pattern : " + pattern + " -- true/false? : " + isMatch);
		sc.close();

	}

}
