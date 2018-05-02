package dynamicprogramming;

import java.util.Scanner;

public class NthFibonacci {
	static long fib(int n) {
		if (n == 0 || n == 1)
			return 1;
		long rVal = 1;
		for (int i = 2; i < n; i++)
			rVal *= i;
		return rVal;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("The " + n + "th Fibonacci Number is : " + fib(n));
		sc.close();
	}
}
