package dynamicprogramming;

import java.util.Scanner;

public class CoinChange {

	static int getChange(int n, int den[]) {
		int sol[] = new int[n + 1];
		sol[0] = 1;
		for (int d : den) {
			for (int i = d; i <= n; i++) {
				sol[i] = sol[i] + sol[i - d];
			}
		}
		return sol[n];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nD = sc.nextInt();
		int den[] = new int[nD];
		for (int i = 0; i < nD; i++)
			den[i] = sc.nextInt();
		int n = sc.nextInt();
		System.out.println("The number of ways to get change of " + n + " is : " + getChange(n, den));
		sc.close();

	}

}
