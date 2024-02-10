package com.greatlearning.pathfinder.model;

import com.greatlearning.pathfinder.model.Node;

public class NodeInsertionDetails {

	Node parentNode;
	
	String direction;
	
	public Node getParentNode() {
		return parentNode;
	}
	public void setParentNode(Node parentNode) {
		this.parentNode = parentNode;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
}