package com.gt.detect.cycle;

import java.util.Arrays;

public class Graph {

	int v, e;
	Edge[] edges;

	class Edge {
		int src, dest;
	}

	public Graph(int v, int e) {
		this.v = v;
		this.e = e;

		edges = new Edge[e];

		for (int i = 0; i < e; i++) {
			edges[i] = new Edge();
		}
	}

	public int find(int[] parent, int i) {
		if (parent[i] == -1) {
			return i;
		} else {
			return find(parent, parent[i]);
		}
	}

	public void union(int[] parent, int x, int y) {
		int setx = find(parent, x);
		int sety = find(parent, y);
		parent[setx] = sety;
	}

	public boolean isCycle(Graph graph) {
		int[] parent = new int[graph.v];
		Arrays.fill(parent, -1);

		for (int i = 0; i < graph.e; i++) {
			int x = graph.find(parent, graph.edges[i].src);
			int y = graph.find(parent, graph.edges[i].dest);
			if (x == y) {
				return true;
			}
			graph.union(parent, x, y);
		}

		return false;
	}

	public static void main(String[] args) {
		/*
		 * Let us create following graph 0 | \ | \ 1-----2
		 */
		int V = 3, E = 3;
		Graph graph = new Graph(V, E);

		// add edge 0-1
		graph.edges[0].src = 0;
		graph.edges[0].dest = 1;

		// add edge 1-2
		graph.edges[1].src = 1;
		graph.edges[1].dest = 2;

		// add edge 0-2
		graph.edges[2].src = 0;
		graph.edges[2].dest = 2;

		if (graph.isCycle(graph))
			System.out.println("graph contains cycle");
		else
			System.out.println("graph doesn't contain cycle");
	}
}
