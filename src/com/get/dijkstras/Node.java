package com.get.dijkstras;

import java.util.ArrayList;

public class Node {

	private int distanceFromSorce = Integer.MAX_VALUE;
	private boolean isVisited;
	private ArrayList<Edge> edges = new ArrayList<>();

	public Node() {
		super();
	}

	public int getDistanceFromSorce() {
		return distanceFromSorce;
	}

	public void setDistanceFromSorce(int distanceFromSorce) {
		this.distanceFromSorce = distanceFromSorce;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}

	@Override
	public String toString() {
		return "Node [distanceFromSorce : " + distanceFromSorce + ", isVisited :" + isVisited + ", edges : " + edges
				+ "]";
	}

}
