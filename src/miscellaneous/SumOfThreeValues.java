package miscellaneous;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfThreeValues {

	static boolean findTriplet(int a[], int sum) {
		Arrays.sort(a);
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newSum = sum - a[i];
			int j = i + 1;
			int k = n - 1;
			while (j < n && k > i) {
				if (a[j] + a[k] == newSum && j != k) {
					// System.out.println(a[i] + " " + a[j] + " " + a[k]);
					return true;
				} else if (a[j] + a[k] < newSum)
					j++;
				else
					k--;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		int sum = sc.nextInt();
		boolean found = findTriplet(a, sum);
		System.out.println("Triplet Found : " + found);
		sc.close();

	}

}
