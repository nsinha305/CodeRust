package arrays;

import java.util.Scanner;

public class LowHighIndex {

	static int getLowIndex(int ar[], int x) {
		int low = 0;
		int high = ar.length - 1;
		while (low <= high) {
			int mid = low + ((high - low) / 2);
			if (ar[mid] < x)
				low = mid + 1;
			else if (x <= ar[mid])
				high = mid - 1;
		}
		if (ar[low] == x)
			return low;
		return -1;
	}

	static int getHighIndex(int ar[], int x) {
		int low = 0;
		int high = ar.length - 1;
		while (low <= high) {
			int mid = low + ((high - low) / 2);
			if (ar[mid] <= x)
				low = mid + 1;
			else if (x < ar[mid])
				high = mid - 1;
		}
		if (ar[high] == x)
			return high;
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		int x = sc.nextInt();
		int low = getLowIndex(ar, x);
		int high = getHighIndex(ar, x);
		System.out.println("Low Index : " + low);
		System.out.println("High Index : " + high);
		sc.close();

	}

}
