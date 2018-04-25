package mathandstats;

import java.util.Scanner;

public class IntegerDivision {
	static int divide(int x, int y) {
		if (y == 0)
			return -1;
		if (y > x)
			return 0;
		if (x == y)
			return 1;
		if (y == 1)
			return x;
		int q = 1;
		int temp = y;
		while (x > temp) {
			temp = temp << 1;
			q = q << 1;
		}
		if (temp > x) {
			temp = temp >> 1;
			q = q >> 1;
			return q + divide(x - temp, y);
		}
		return q;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int q = divide(x, y);
		System.out.println(x + " divided by " + y + " is : " + q);
		sc.close();
	}
}
