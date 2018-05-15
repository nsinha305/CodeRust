package strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StringSegmentation {

	static boolean stringSegmentation(String word, Set<String> dictionary) {
		Set<String> solved = new HashSet<String>();
		boolean returnVal = stringSegmentation(word, dictionary, solved);
		for(String s : solved) {
			System.out.println(s);
		}
		return returnVal;
	}

	static boolean stringSegmentation(String word, Set<String> dictionary, Set<String> solved) {
		for (int i = 1; i < word.length(); i++) {
			String first = word.substring(0, i);
			if (dictionary.contains(first)) {
				String second = word.substring(i);
				if (second == null || second.length() == 0 || dictionary.contains(second))
					return true;

				if (!solved.contains(second)) {
					if (stringSegmentation(second, dictionary, solved))
						return true;
					solved.add(second);
				}
			}
			solved.add(first);
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int n = sc.nextInt();
		Set<String> dictionary = new HashSet<String>();
		for (int i = 0; i < n; i++) {
			String word = sc.next();
			dictionary.add(word);
		}
		boolean isSegmented = stringSegmentation(s, dictionary);
		System.out.println(isSegmented);
		sc.close();
	}

}
