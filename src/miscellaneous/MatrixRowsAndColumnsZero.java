package miscellaneous;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixRowsAndColumnsZero {

	static int[][] makeRowsAndColumnsZero(int a[][]) {
		List<Integer> rows = new ArrayList<Integer>();
		List<Integer> cols = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (rows.contains(i) || cols.contains(j)) {
					a[i][j] = 0;
				}
			}
		}
		return a;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a[][] = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				a[i][j] = sc.nextInt();
		a = makeRowsAndColumnsZero(a);
		System.out.println("New Array : ");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.print("\n");
		}
		sc.close();

	}

}
