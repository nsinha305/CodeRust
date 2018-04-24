package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class SumInArray {

	static boolean method1(int ar[], int d) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < ar.length; i++) {
			if (set.contains(d - ar[i]))
				return true;
			else
				set.add(ar[i]);
		}
		return false;
	}

	static boolean method2(int ar[], int d) {
		Arrays.sort(ar);
		int low = 0;
		int high = ar.length - 1;
		while (low < high) {
			if ((ar[low] + ar[high]) == d)
				return true;
			else if ((ar[low] + ar[high]) < d)
				low++;
			else
				high--;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = sc.nextInt();
		}
		int d = sc.nextInt();
		// boolean flag = method1(ar, d);
		boolean flag = method2(ar, d);
		System.out.print("\nSum Found : " + flag);
		sc.close();

	}

}
