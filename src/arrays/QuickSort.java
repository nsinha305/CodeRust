package arrays;

import java.util.Scanner;

public class QuickSort {

	static int partition1(int ar[], int low, int high) {
		int pivot = ar[low];
		int i = low;
		int j = high;
		while (i < j) {
			while (i <= high && ar[i] <= pivot)
				i++;
			while (ar[j] > pivot)
				j--;
			if (i < j) {
				int temp = ar[i];
				ar[i] = ar[j];
				ar[j] = temp;
			} else {
				break;
			}
		}
		ar[low] = ar[j];
		ar[j] = pivot;
		return j;
	}

	static void quickSortRec(int ar[], int low, int high) {
		if (low < high) {
			int partitionKey = partition1(ar, low, high);
			quickSortRec(ar, low, partitionKey - 1);
			quickSortRec(ar, partitionKey + 1, high);
		}

	}

	static void quickSort(int ar[]) {
		quickSortRec(ar, 0, ar.length - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		quickSort(ar);
		System.out.print("\nSorted Array : ");
		for (int i = 0; i < n; i++)
			System.out.print(ar[i] + " ");
		sc.close();

	}

}
