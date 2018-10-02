package com.gt.dijkstras;

public class Edge {

	private int fromNodeIndex;
	private int toNodeIndex;
	private int length;

	public Edge() {
		// TODO Auto-generated constructor stub
	}

	public Edge(int fromNodeId, int toNodeId, int length) {
		this.fromNodeIndex = fromNodeId;
		this.toNodeIndex = toNodeId;
		this.length = length;
	}

	public int getFromNodeIndex() {
		return fromNodeIndex;
	}

	public int getToNodeIndex() {
		return toNodeIndex;
	}

	public int getLength() {
		return length;
	}
	
	// determine neighbour node of given node based on two node connected by this node
	public int getNeighbourIndex(int nodeId) {
		if(this.fromNodeIndex == nodeId) {
			return this.toNodeIndex;
		}else {
			return this.fromNodeIndex;
		}
	}
	
	@Override
	public String toString() {
		return "Edge [fromNodeId=" + fromNodeIndex + ", toNodeId=" + toNodeIndex + ", length=" + length + "]";
	}

}
