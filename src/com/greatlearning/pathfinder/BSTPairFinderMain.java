package com.greatlearning.pathfinder;

import com.greatlearning.pathfinder.service.BSTPairFinder;
import com.greatlearning.pathfinder.service.BinarySearchTree;
import com.greatlearning.pathfinder.util.BSTUtils;

public class BSTPairFinderMain {

    public static void main(String[] args) {

        BinarySearchTree bst = BSTUtils.sampleBST();

        BSTPairFinder pairFinder =
                new BSTPairFinder(bst, 120);

        pairFinder.findPairs();


    }
}