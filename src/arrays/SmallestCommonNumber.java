package arrays;

import java.util.Scanner;

public class SmallestCommonNumber {
	static int getSmallestCommonNumber(int a1[], int a2[], int a3[]) {
		int x = 0;
		int y = 0;
		int z = 0;
		while (x < a1.length && y < a2.length && z < a3.length) {
			if (a1[x] == a2[y] && a2[y] == a3[z])
				return a1[x];
			else {
				if (a1[x] <= a2[y] && a1[x] <= a3[z])
					x++;
				else if (a2[y] <= a1[x] && a2[y] <= a3[z])
					y++;
				else if (a3[z] <= a1[x] && a3[z] <= a2[y])
					z++;
			}
		}
		return -1;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int ar1[] = new int[n1];
		for (int i = 0; i < n1; i++)
			ar1[i] = sc.nextInt();
		int n2 = sc.nextInt();
		int ar2[] = new int[n2];
		for (int i = 0; i < n2; i++)
			ar2[i] = sc.nextInt();
		int n3 = sc.nextInt();
		int ar3[] = new int[n3];
		for (int i = 0; i < n3; i++)
			ar3[i] = sc.nextInt();
		int smallest = getSmallestCommonNumber(ar1, ar2, ar3);
		System.out.println("Smallest : " + smallest);
		sc.close();
	}
}
