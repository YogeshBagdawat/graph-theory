package com.gt.dijkstras;

import java.util.ArrayList;

public class Graph {

	private Node[] nodes;
	private int numberOfNodes;
	private Edge[] edges;
	private int numberOfEdges;

	public Graph(Edge[] edges) {
		this.edges = edges;

		this.numberOfNodes = claculateNumberOfNode(edges);

		this.nodes = new Node[this.numberOfNodes];

		for (int i = 0; i < this.numberOfNodes; i++) {
			nodes[i] = new Node();
		}

		this.numberOfEdges = edges.length;

		// add edge to node
		for (int i = 0; i < this.numberOfEdges; i++) {
			this.nodes[edges[i].getFromNodeIndex()].getEdges().add(edges[i]);
			this.nodes[edges[i].getToNodeIndex()].getEdges().add(edges[i]);
		}
	}

	private int claculateNumberOfNode(Edge[] edges) {
		int noOfNodes = 0;
		for (Edge e : edges) {
			if (e.getFromNodeIndex() > noOfNodes) {
				noOfNodes = e.getFromNodeIndex();
			}
			if (e.getToNodeIndex() > noOfNodes) {
				noOfNodes = e.getToNodeIndex();
			}
		}
		noOfNodes++;

		return noOfNodes;
	}

	public void calculateShortestDistances() {

		this.nodes[0].setDistanceFromSorce(0);
		int nextNode = 0;
		for (int i = 0; i < this.nodes.length; i++) {
			ArrayList<Edge> currentNodeEdges = this.nodes[i].getEdges();

			for (int joindEgde = 0; joindEgde < currentNodeEdges.size(); joindEgde++) {
				int neighbourIndex = currentNodeEdges.get(joindEgde).getNeighbourIndex(nextNode);

				if (!this.nodes[neighbourIndex].isVisited()) {
					int tentive = this.nodes[nextNode].getDistanceFromSorce()
							+ currentNodeEdges.get(joindEgde).getLength();
					if (tentive < this.nodes[neighbourIndex].getDistanceFromSorce()) {
						this.nodes[neighbourIndex].setDistanceFromSorce(tentive);
					}
				}
			}
			nodes[nextNode].setVisited(true);
			nextNode = getNodeShortestDistanced();
		}
	}

	private int getNodeShortestDistanced() {
		int storeNodeIndex = 0;
		int storedNodeDist = Integer.MAX_VALUE;

		for (int i = 0; i < this.nodes.length; i++) {
			int currentDist = this.nodes[i].getDistanceFromSorce();
			if (currentDist < storedNodeDist) {
				storedNodeDist = i;
				storedNodeDist = currentDist;
			}
		}
		return storeNodeIndex;
	}

	public void display() {
		String output = "Number of nodes = " + this.numberOfNodes;
		output += "\nNumber of edges = " + this.numberOfEdges;
		for (int i = 0; i < this.nodes.length; i++) {
			output += ("\nThe shortest distance from node 0 to node " + i + " is " + nodes[i].getDistanceFromSorce());
		}
		System.out.println(output);
	}

	public Node[] getNodes() {
		return nodes;
	}

	public int getNumberOfNodes() {
		return numberOfNodes;
	}

	public Edge[] getEdges() {
		return edges;
	}

	public int getNumberOfEdges() {
		return numberOfEdges;
	}

}
