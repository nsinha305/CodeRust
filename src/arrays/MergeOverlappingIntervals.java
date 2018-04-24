package arrays;

import java.util.ArrayList;
import java.util.Scanner;

class Pair {
	int start;
	int end;

	Pair(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class MergeOverlappingIntervals {

	static ArrayList<Pair> consolidateTimes(int ar[][]) {
		ArrayList<Pair> times = new ArrayList<Pair>();
		int n = ar.length;
		int start = ar[0][0];
		int end = ar[0][1];
		for (int i = 1; i < n; i++) {
			if (ar[i][0] >= start && ar[i][0] <= end) {
				if (ar[i][1] > end)
					end = ar[i][1];
			} else {
				times.add(new Pair(start, end));
				start = ar[i][0];
				end = ar[i][1];
			}
		}
		times.add(new Pair(start, end));
		return times;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[][] = new int[n][2];
		for (int i = 0; i < n; i++) {
			ar[i][0] = sc.nextInt();
			ar[i][1] = sc.nextInt();
		}
		ArrayList<Pair> times = consolidateTimes(ar);
		System.out.print("\nOverlapping intervals : ");
		for (int i = 0; i < times.size(); i++) {
			System.out.print(times.get(i).start + " : " + times.get(i).end + "\n");
		}
		sc.close();

	}

}
