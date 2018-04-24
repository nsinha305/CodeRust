package arrays;

import java.util.Scanner;

public class MaxSingleSellProfit {

	static void getMaxSingleSellProfit(int ar[]) {
		int currentProfit = Integer.MIN_VALUE;
		int currentBuy = ar[0];
		int globalSell = ar[1];
		int globalProfit = globalSell - currentBuy;
		for (int i = 1; i < ar.length; i++) {
			currentProfit = ar[i] - currentBuy;
			if (currentProfit > globalProfit) {
				globalProfit = currentProfit;
				globalSell = ar[i];
			}
			if (ar[i] < currentBuy) {
				currentBuy = ar[i];
			}
		}
		System.out.println("Buy at : " + (globalSell - globalProfit));
		System.out.println("Sell at : " + globalSell);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		getMaxSingleSellProfit(ar);
		sc.close();

	}

}
