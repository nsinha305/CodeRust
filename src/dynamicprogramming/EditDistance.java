package dynamicprogramming;

import java.util.Scanner;

public class EditDistance {

	static int getEditDist(String s1, String s2) {
		int a[][] = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i <= s1.length(); i++)
			a[i][0] = i;
		for (int i = 0; i <= s2.length(); i++)
			a[0][i] = i;
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					a[i][j] = Integer.min(a[i - 1][j - 1], Integer.min(a[i][j - 1] + 1, a[i - 1][j] + 1));
				else
					a[i][j] = Integer.min(a[i - 1][j - 1] + 1, Integer.min(a[i][j - 1] + 1, a[i - 1][j] + 1));
			}
		}
		return a[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		System.out.println("Edit Distance for strings " + s1 + " and " + s2 + " is : " + getEditDist(s1, s2));
		sc.close();

	}

}
