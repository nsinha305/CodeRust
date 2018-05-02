package dynamicprogramming;

import java.util.Scanner;

public class GameScoring {
	static int getScoresRec(int n, int result[]) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		if (result[n] > 0)
			return result[n];
		result[n] = getScoresRec(n - 1, result) + getScoresRec(n - 2, result) + getScoresRec(n - 4, result);
		return result[n];
	}

	static int getNumScore(int n) {
		if (n < 1)
			return 0;
		int result[] = new int[n + 1];
		result[0] = 1;
		getScoresRec(n, result);
		return result[n];
	}

	static int dpGetNumScore(int n) {
		int result[] = new int[4];
		// base case
		result[3] = 1;
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum = result[0] + result[2] + result[3];
			result[0] = result[1];
			result[1] = result[2];
			result[2] = result[3];
			result[3] = sum;
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		// int numScore = getNumScore(score);
		int numScore = dpGetNumScore(score);
		System.out.println("The number of ways a score of " + score + " can be achieved is : " + numScore);
		sc.close();

	}

}
