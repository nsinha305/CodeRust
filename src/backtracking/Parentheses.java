package backtracking;

import java.util.Scanner;

public class Parentheses {

	static void generateAllParentheses(int n) {
		if (n == 0)
			return;
		if (n == 1) {
			System.out.println("()");
			return;
		}
		generateParenthesesRec(n, 0, 0, "");
	}

	static void generateParenthesesRec(int n, int open, int close, String s) {
		if (s.length() == 2 * n) {
			System.out.println(s);
			return;
		}
		if (open > close) {
			if (open == n)
				generateParenthesesRec(n, open, close + 1, s + ")");
			else {
				generateParenthesesRec(n, open, close + 1, s + ")");
				generateParenthesesRec(n, open + 1, close, s + "(");
			}
		}
		if (open == close) {
			generateParenthesesRec(n, open + 1, close, s + "(");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		generateAllParentheses(n);
		sc.close();
	}

}
