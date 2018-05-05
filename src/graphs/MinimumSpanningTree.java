package graphs;

import java.util.Scanner;

public class MinimumSpanningTree {

	static int minKey(int key[], boolean visited[]) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i = 0; i < key.length; i++) {
			if (key[i] < min && visited[i] == false) {
				min = key[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	static void printMST(int parent[], int g[][]) {
		int v = parent.length;
		System.out.println("Edge   Weight");
        for (int i = 1; i < v; i++)
            System.out.println(parent[i]+" - "+ i+"    "+
                               g[i][parent[i]]);
	}

	static void primMST(int g[][]) {
		int v = g.length;
		int parent[] = new int[v];
		boolean visited[] = new boolean[v];
		int key[] = new int[v];
		for (int i = 0; i < v; i++) {
			visited[i] = false;
			key[i] = Integer.MAX_VALUE;
		}
		key[0] = 0;
		parent[0] = -1;

		for (int count = 0; count < v - 1; count++) {
			int u = minKey(key, visited);
			visited[u] = true;
			for (int i = 0; i < v; i++) {
				if (g[u][i] != 0 && visited[i] == false && g[u][i] < key[i]) {
					parent[i] = u;
					key[i] = g[u][i];
				}
			}
		}
		printMST(parent, g);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int g[][] = new int[v][v];
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				g[i][j] = sc.nextInt();
			}
		}
		primMST(g);
		sc.close();

	}

}
