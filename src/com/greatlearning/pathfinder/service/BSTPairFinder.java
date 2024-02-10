package com.greatlearning.pathfinder.service;

import com.greatlearning.pathfinder.model.Node;

import java.util.LinkedHashSet;
import java.util.Set;

public class BSTPairFinder {

    BinarySearchTree bst;
    Integer sum;
    Set<Integer> previouslyVisitedNodes;
    boolean pairFound = false;

    public BSTPairFinder(BinarySearchTree bst, Integer sum) {

        this.bst = bst;
        this.sum = sum;

        this.previouslyVisitedNodes =
                new LinkedHashSet<>();
    }

    public void findPairs() {

        preOrderTraversal(bst.getRoot());

        if(!pairFound)
            System.out.println("No node pairs were found!");
    }

    void preOrderTraversal(Node currentNode) {

        if (currentNode == null) {
            return;
        }

        Integer difference = (sum - currentNode.getData());
        if (previouslyVisitedNodes.contains(difference)) {

            System.out.print("Pair is ");
            System.out.printf("(%d, %d)",
                    currentNode.getData(), difference);
            System.out.println();
            pairFound = true;
        }

        this.previouslyVisitedNodes.add(currentNode.getData());


        preOrderTraversal(currentNode.getLeft());
        preOrderTraversal(currentNode.getRight());
    }

}