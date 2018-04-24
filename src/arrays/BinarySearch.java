package arrays;

import java.util.Scanner;

public class BinarySearch {
	static int binarySearch(int ar[], int x) {
		int low = 0;
		int high = ar.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			//System.out.println(ar[mid]);
			if (ar[mid] == x)
				return mid;
			if (x > ar[mid])
				low = mid + 1;
			if (x < ar[mid])
				high = mid - 1;
		}
		return -1;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = sc.nextInt();
		}
		int x = sc.nextInt();
		int pos = binarySearch(ar, x);
		System.out.println("Position found at : " + pos);
		sc.close();
	}
}
