package com.gt.representation;

import java.util.LinkedList;

public class GraphRepresentation {

	static class Graph {
		int V;
		LinkedList<Integer>[] adjListArray;

		Graph(int V) {
			this.V = V;
			adjListArray = new LinkedList[V];

			for (int i = 0; i < V; i++) {
				adjListArray[i] = new LinkedList<>();
			}
		}
	}

	static void addEdge(Graph graph, int src, int dest) {
		// Add an edge from src to dest.
		graph.adjListArray[src].addLast(dest);

		// Since graph is undirected, add an edge from dest
		// to src also
		graph.adjListArray[dest].addLast(src);
	}

	static void printGraph(Graph graph) {
		for (int i = 0; i < graph.V; i++) {
			for (Integer li : graph.adjListArray[i]) {
				System.out.print("->" + li);
			}
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		int V = 5;
		Graph graph = new Graph(V);
		addEdge(graph, 0, 1);
		addEdge(graph, 0, 4);
		addEdge(graph, 1, 2);
		addEdge(graph, 1, 3);
		addEdge(graph, 1, 4);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 4);
		
		printGraph(graph);

	}
}
