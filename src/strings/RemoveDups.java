package strings;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDups {

	static String removeDups1(String s) {
		char[] ar = new char[s.length()];
		HashSet<Character> set = new HashSet<Character>();
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			if (!set.contains(s.charAt(i))) {
				set.add(s.charAt(i));
				ar[j] = s.charAt(i);
				j++;
			}
		}
		return new String(ar, 0, j);
	}

	static String removeDups2(String s) {
		int j = 0;
		char[] ar = s.toCharArray();
		ar[0] = s.charAt(0);
		for (int k = 1; k < s.length(); k++) {
			boolean found = false;
			for (int l = 0; l <= j; l++) {
				if (s.charAt(k) == ar[l]) {
					found = true;
				}
			}
			if (!found) {
				// System.out.println(s.charAt(k));
				ar[j + 1] = s.charAt(k);
				j++;
			}
		}
		return new String(ar, 0, j + 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		// s = removeDups1(s);
		s = removeDups2(s);
		System.out.println("The String without duplicates is : " + s);
		sc.close();
	}

}
