package arrays;

import java.util.Scanner;

public class ZeroesLeft {

	static void moveZeroes(int ar[]) {
		int read = ar.length - 1;
		int write = ar.length - 1;
		while (read >= 0) {
			if (ar[read] != 0) {
				ar[write] = ar[read];
				write--;
			}
			read--;
		}
		while (write >= 0) {
			ar[write--] = 0;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		moveZeroes(ar);
		System.out.print("\nArray with shifted zeroes : ");
		for (int i = 0; i < n; i++)
			System.out.print(ar[i] + " ");
		sc.close();

	}

}
