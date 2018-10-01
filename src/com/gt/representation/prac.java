package com.gt.representation;

import java.util.LinkedList;

import com.gt.representation.GraphRepresentation.Graph;

public class prac {

	static class Graph {
		int V;
		LinkedList<Student>[] adjListArray;

		Graph(int V) {
			this.V = V;
			adjListArray = new LinkedList[V];
			for(int i=0;i<V;i++) {
				adjListArray[i] = new LinkedList<>();
			}
		}
	}
	
	public static void addEdge(Graph graph, int src, int dest, Student student) {
		if(!graph.adjListArray[src].contains(student)) {
			graph.adjListArray[src].addLast(student);
		}
		if(!graph.adjListArray[dest].contains(student)) {
			graph.adjListArray[dest].addLast(student);
		}
	}
	
	static void printGraph(Graph graph) {
		for (int i = 0; i < graph.V; i++) {
			for (Student li : graph.adjListArray[i]) {
				System.out.print("->" + li);
			}
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		int V = 5;
		Graph graph = new Graph(V);
		Student s1 = new Student("amit", "singhal");
		Student s2 = new Student("rahul", "singhal");
		Student s3 = new Student("ud", "singhal");
		Student s4 = new Student("pm", "singhal");
		Student s5 = new Student("cm", "singhal");
		
		addEdge(graph, 0, 1, s1);
		addEdge(graph, 0, 4, s1);
		
		addEdge(graph, 1, 0, s2);
		addEdge(graph, 1, 4, s2);
		addEdge(graph, 1, 2, s2);
		addEdge(graph, 1, 3, s2);
		
		
		
		addEdge(graph, 2, 3, s3);
		addEdge(graph, 2, 1, s3);
		
		addEdge(graph, 3, 4, s4);
		addEdge(graph, 3, 2, s4);
		addEdge(graph, 3, 1, s4);
		
		addEdge(graph, 4, 3, s5);
		addEdge(graph, 4, 1, s5);
		addEdge(graph, 4, 0, s5);
		
		addEdge(graph, 3, 4, new Student("amit", "singhal"));
		
		printGraph(graph);

	}
}
