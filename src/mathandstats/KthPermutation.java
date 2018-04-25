package mathandstats;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KthPermutation {

	static int factorial(int n) {
		if (n == 0 || n == 1)
			return 1;
		return n * factorial(n - 1);
	}

	static void findKthPermutation(StringBuilder s, List<Character> set, int k) {
		int n = set.size();
		int blockSize = factorial(n - 1);
		int block = (k - 1) / blockSize;
		Character x = set.get(block);
		s.append(x);
		set.remove(block);
		k = k - (block * blockSize);
		if (k != 0 && !set.isEmpty())
			findKthPermutation(s, set, k);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Character> set = new ArrayList<Character>();
		for (int i = 0; i < n; i++)
			set.add(sc.next().charAt(0));
		int k = sc.nextInt();
		StringBuilder s = new StringBuilder();
		findKthPermutation(s, set, k);
		System.out.println("K-th Permutation is : " + s.toString());
		sc.close();
	}

}
