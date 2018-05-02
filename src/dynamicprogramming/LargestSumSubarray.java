package dynamicprogramming;

import java.util.Scanner;

class Pair {
	int start;
	int end;

	Pair(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class LargestSumSubarray {

	static Pair maxSubarray(int a[]) {
		int currStart = 0;
		int globalStart = 0;
		int currEnd = 0;
		int globalEnd = 0;
		int currMax = a[0];
		int globalMax = a[0];
		if (a.length < 1)
			return null;
		for (int i = 1; i < a.length; i++) {
			if (currMax < 0) {
				currStart = i;
				currEnd = i;
				currMax = a[i];
			} else {
				currEnd++;
				currMax += a[i];
			}
			if (globalMax < currMax) {
				globalStart = currStart;
				globalEnd = currEnd;
				globalMax = currMax;
			}
		}
		return new Pair(globalStart, globalEnd);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		System.out.print("\nThe contiguous subarray with the largest sum is : ");
		Pair p = maxSubarray(a);
		if (p != null)
			for (int i = p.start; i <= p.end; i++)
				System.out.print(a[i] + " ");
		sc.close();

	}

}
