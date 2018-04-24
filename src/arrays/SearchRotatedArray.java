package arrays;

import java.util.Scanner;

public class SearchRotatedArray {

	static int searchRotatedArray(int ar[], int x) {
		int start = 0;
		int end = ar.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (x == ar[mid])
				return mid;
			if (ar[start] < ar[mid] && x < ar[mid] && x >= ar[start])
				end = mid - 1;
			else if (ar[end] > ar[mid] && x <= ar[end] && x > ar[mid])
				start = mid + 1;
			else if (ar[start] > ar[mid])
				end = mid - 1;
			else if (ar[end] < ar[mid])
				start = mid + 1;
			else
				return -1;
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		int x = sc.nextInt();
		int pos = searchRotatedArray(ar, x);
		System.out.println("Position : " + pos);
		sc.close();
	}

}
