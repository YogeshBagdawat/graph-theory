package com.gt.travers;

import java.util.LinkedList;
import java.util.ListIterator;

public class Graph {

	int v;
	LinkedList<Integer>[] adj;

	public Graph(int v) {
		this.v = v;
		adj = new LinkedList[v];

		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int src, int dest) {
		adj[src].add(dest);
	}

	public void BFS(int s) {

		boolean[] visited = new boolean[v];
		LinkedList<Integer> queue = new LinkedList<>();

		visited[s] = true;
		queue.add(s);
		while (!queue.isEmpty()) {
			s = queue.poll();
			System.out.print(s + " ");
			ListIterator<Integer> itr = adj[s].listIterator();

			while (itr.hasNext()) {
				s = itr.next();
				if (!visited[s]) {
					visited[s] = true;
					queue.add(s);
				}
			}
		}

	}

	public void DFS(int s) {

		boolean[] visited = new boolean[v];
		DFSUtil(s, visited);

	}

	private void DFSUtil(int s, boolean[] visited) {
		visited[s] = true;
		System.out.print(s + " ");
		ListIterator<Integer> itr = adj[s].listIterator();
		while (itr.hasNext()) {
			s = itr.next();
			if (!visited[s]) {
				DFSUtil(s, visited);
			}
		}
	}

	public static void main(String args[]) {
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		g.BFS(2);
	}

}
