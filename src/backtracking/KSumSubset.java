package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class KSumSubset {

	static void getSubSetsRec(List<Integer> partial, List<Integer> list, int k, List<List<Integer>> result) {
		int sum = 0;
		for (int x : partial)
			sum += x;
		if (sum == k && partial.size() > 0) {
			result.add(new ArrayList<Integer>(partial));
		} else if (sum > k)
			return;
		else {
			for (int i = 0; i < list.size(); i++) {
				List<Integer> newPartial = new ArrayList<Integer>(partial);
				newPartial.add(list.get(i));
				List<Integer> newList = list.subList(i + 1, list.size());
				getSubSetsRec(newPartial, newList, k, result);
			}
		}

	}

	static List<List<Integer>> getAllSubsets(List<Integer> list, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> partial = new ArrayList<Integer>();
		getSubSetsRec(partial, list, k, result);
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			list.add(sc.nextInt());
		int k = sc.nextInt();
		List<List<Integer>> allSubsets = getAllSubsets(list, k);
		for (int i = 0; i < allSubsets.size(); i++) {
			System.out.print("[");
			for (int j = 0; j < allSubsets.get(i).size() - 1; j++) {
				System.out.print(allSubsets.get(i).get(j) + ", ");
			}
			System.out.print(allSubsets.get(i).get(allSubsets.get(i).size() - 1) + "]\n");
		}
		sc.close();

	}

}
