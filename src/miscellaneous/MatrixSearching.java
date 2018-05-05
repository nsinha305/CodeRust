package miscellaneous;

import java.util.Scanner;

public class MatrixSearching {

	static void findKey(int a[][], int key) {
		int n = a.length;
		int m = a[0].length;
		int i = n - 1;
		int j = 0;
		boolean flag = false;
		while (j < m && i >= 0) {
			if (key == a[i][j]) {
				System.out.println("Key " + key + " found at (" + i + "," + j + ")");
				flag = true;
				break;
			} else if (key < a[i][j]) {
				i--;
			} else if (key > a[i][j]) {
				j++;
			}
		}
		if (flag == false)
			System.out.println("Key " + key + " not found.");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a[][] = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				a[i][j] = sc.nextInt();
		int key = sc.nextInt();
		findKey(a, key);
		sc.close();

	}

}
