package arrays;

import java.util.Scanner;

public class RotateArray {

	static int ar[];

	static void reverse(int start, int end) {
		while (start < end) {
			int swap = ar[start];
			ar[start] = ar[end];
			ar[end] = swap;
			start++;
			end--;
		}
	}

	static void rotateArrayMethod1(int d) {
		d = d % ar.length;
		if (d < 0)
			d = ar.length + d;
		reverse(0, ar.length - 1);
		reverse(0, d - 1);
		reverse(d, ar.length - 1);
	}

	static void rotateArrayMethod2(int d) {
		d = d % ar.length;
		if (d < 0)
			d = ar.length + d;
		int temp[] = new int[d];
		for (int i = 0; i < d; i++) {
			temp[i] = ar[ar.length - d + i];
		}
		for (int i = 0; i < (ar.length - d); i++) {
			ar[i + d] = ar[i];
		}
		for (int i = 0; i < d; i++) {
			ar[i] = temp[i];
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ar = new int[n];
		for (int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		int d = sc.nextInt();
		//rotateArrayMethod1(d);
		rotateArrayMethod2(d);
		System.out.print("\nRotation by " + d + " : ");
		for (int i = 0; i < n; i++) {
			System.out.print(ar[i] + " ");
		}
		sc.close();

	}

}
