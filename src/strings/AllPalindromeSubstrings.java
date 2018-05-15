package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllPalindromeSubstrings {

	static void getPalindromes(String s, int j, int k, List<String> list) {
		for (; j >= 0 && k < s.length(); j--, k++) {
			if (s.charAt(j) != s.charAt(k))
				break;
			list.add(s.substring(j, k + 1));
		}
	}

	static List<String> getAllPalindromes(String s) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			getPalindromes(s, i - 1, i + 1, list); // odd
			getPalindromes(s, i, i + 1, list); // even
		}
		return list;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		List<String> allPalindromes = getAllPalindromes(s);
		System.out.println("Palindromes : -");
		for (String p : allPalindromes)
			System.out.println(p);
		sc.close();

	}

}
