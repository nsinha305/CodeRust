package arrays;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaxSlidingWindow {

	static void getMaxSlidingWindow(int ar[], int w) {
		ArrayDeque<Integer> window = new ArrayDeque<Integer>();
		for (int i = 0; i < w; i++) {
			while (!window.isEmpty() && ar[i] >= ar[window.peekLast()]) {
				window.removeLast();
			}
			window.addLast(i);
		}

		System.out.print(ar[window.peekFirst()] + ", ");

		for (int i = w; i < ar.length; i++) {
			while (!window.isEmpty() && ar[i] >= ar[window.peekLast()]) {
				window.removeLast();
			}
			while (!window.isEmpty() && (window.peekFirst() <= i - w)) {
				window.removeFirst();
			}
			window.addLast(i);
			System.out.print(ar[window.peekFirst()] + ", ");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		int w = sc.nextInt();
		getMaxSlidingWindow(ar, w);
		sc.close();

	}

}
