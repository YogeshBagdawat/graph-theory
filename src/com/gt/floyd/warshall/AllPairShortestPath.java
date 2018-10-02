package com.gt.floyd.warshall;

public class AllPairShortestPath {

	public static final int INF = 99999;
	public static final int V = 4;
	public static int[][] p;

	public void floydWarshall(int graph[][]) {
		p = new int[V][V];
		int[][] dist = new int[V][V];
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				dist[i][j] = graph[i][j];
			}
		}

		for (int k = 0; k < V; k++) {
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					if (dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
						p[i][j] = k;
					}
				}
			}
		}
		printSolution(dist);
	}

	private void printSolution(int[][] p) {
		System.out.println("print all pair shortestPath");
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (p[i][j] == INF) {
					System.out.print("INF ");
				} else {
					System.out.print(p[i][j]+" ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int graph[][] = { { 0, 5, INF, 10 }, { INF, 0, 3, INF }, { INF, INF, 0, 1 }, { INF, INF, INF, 0 } };
		AllPairShortestPath a = new AllPairShortestPath();

		// Print the solution
		a.floydWarshall(graph);
	}

}
