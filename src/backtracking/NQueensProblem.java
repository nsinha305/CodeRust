package backtracking;

import java.util.Scanner;

public class NQueensProblem {

	static boolean isSafe(int board[][], int row, int col) {
		for (int i = 0; i < col; i++) {
			if (board[row][i] == 1)
				return false;
		}
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;

		for (int i = row, j = col; j >= 0 && i < board.length; i++, j--)
			if (board[i][j] == 1)
				return false;

		return true;
	}

	static boolean solveBoardUtil(int board[][], int col) {
		if (col >= board.length)
			return true;
		for (int i = 0; i < board.length; i++) {
			if (isSafe(board, i, col)) {
				board[i][col] = 1;
				if (solveBoardUtil(board, col + 1))
					return true;
				board[i][col] = 0;
			}
		}
		return false;
	}

	static void printBoard(int board[][]) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	static boolean solveBoard(int board[][]) {
		if (solveBoardUtil(board, 0) == false)
			return false;
		printBoard(board);
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int board[][] = new int[n][n];
		boolean nQueens = solveBoard(board);
		if (nQueens == false)
			System.out.println("Solution does not exist");
		sc.close();

	}

}
