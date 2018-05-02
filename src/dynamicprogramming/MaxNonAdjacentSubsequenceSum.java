package dynamicprogramming;

import java.util.Scanner;

public class MaxNonAdjacentSubsequenceSum {
	static int getMaxSum(int a[]) {
		int res[] = new int[a.length];
		res[0] = a[0];
		for (int i = 2; i < a.length; i++) {
			res[i] = Integer.max(a[i], res[i - 1]);
			if (i > 1)
				res[i] = Integer.max(res[i], a[i] + res[i - 2]);
		}
		return res[a.length - 1];
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		System.out.println("The max non adjacent subsequence sum is : " + getMaxSum(a));
		sc.close();
	}
}
