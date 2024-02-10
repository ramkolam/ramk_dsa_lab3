package com.greatlearning.pathfinder.service;

import com.greatlearning.pathfinder.constant.NodeDirection;
import com.greatlearning.pathfinder.model.Node;
import com.greatlearning.pathfinder.model.NodeInsertionDetails;

public class BinarySearchTree {

    Node root;

    public Node getRoot() {
        return root;
    }

    public void insert(int value) {

        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
        } else {

            NodeInsertionDetails nodeDetails
                    = constructNodeDetails(value);

            Node parentNode = nodeDetails.getParentNode();

            String direction = nodeDetails.getDirection();

            if (direction.equals(NodeDirection.LEFT.name())) {
                parentNode.setLeft(newNode);
            } else if (direction.equals(NodeDirection.RIGHT.name())) {
                parentNode.setRight(newNode);
            }
        }

    }

    NodeInsertionDetails constructNodeDetails(Integer data) {

        NodeInsertionDetails nid = new NodeInsertionDetails();

        traverseTree(root, data, nid);

        return nid;
    }

    void traverseTree(Node aNode, Integer data,
                      NodeInsertionDetails details) {

        if (data <= aNode.getData()) {

            Node leftNode = aNode.getLeft();

            if (leftNode != null) {
                traverseTree(leftNode, data, details);
            } else {
                details.setParentNode(aNode);
                details.setDirection(NodeDirection.LEFT.name());
            }
        } else {

            Node rightNode = aNode.getRight();

            if (rightNode != null) {
                traverseTree(rightNode, data, details);
            } else {

                details.setParentNode(aNode);
                details.setDirection(NodeDirection.RIGHT.name());
            }
        }
    }

}