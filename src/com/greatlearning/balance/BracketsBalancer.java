package com.greatlearning.balance;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BracketsBalancer {

    String expression;

    public BracketsBalancer(String expression) {

        this.expression = expression;
    }

    public void check() {


        Stack<Character> stack = new Stack<>();

        int length = expression.length();

        if (length % 2 != 0) {
            System.out.println("Odd number of brackets found! Invalid Expression");
            return;
        }

        for (int index = 0; index < length; index++) {

            Character visitedChar = expression.charAt(index);

            if (getOpenBrackets().contains(visitedChar)) {

                stack.push(visitedChar);

            } else if (getClosedBrackets().contains(visitedChar)) {

                Character poppedItem = stack.pop();

                Character assumedOpenBracketChar = poppedItem;
                Character assumedClosedBracketChar = visitedChar;

                Character openBracketChar
                        = getOpenBracketChar(assumedClosedBracketChar);

                if (assumedOpenBracketChar != openBracketChar) {
                    System.out.println("Non-matching Bracket found!");
                    break;
                }
            } else {

                System.out.println("Invalid characters encountered :"
                        + visitedChar);
                break;
            }
        }

        if (stack.isEmpty()) {

            System.out.println("The entered String has Balanced Brackets");
        } else {
            System.out.println("The entered Strings do not contain Balanced Brackets");
        }

    }

    Set<Character> getOpenBrackets() {

        Set<Character> openBracketSet = new HashSet<>();

        openBracketSet.add('<');
        openBracketSet.add('{');
        openBracketSet.add('[');
        openBracketSet.add('(');

        return openBracketSet;
    }

    Set<Character> getClosedBrackets() {
        Set<Character> closeBracketSet = new HashSet<>();
        closeBracketSet.add('>');
        closeBracketSet.add('}');
        closeBracketSet.add(']');
        closeBracketSet.add(')');
        return closeBracketSet;
    }

    Character getOpenBracketChar(Character closedBracketChar) {


        if (closedBracketChar == '>') {
            return '<';
        } else if (closedBracketChar == '}') {
            return '{';
        } else if (closedBracketChar == ']') {
            return '[';
        } else if (closedBracketChar == ')') {
            return '(';
        }
        return ' ';
    }


    public static void main(String[] args) {

        BracketsBalancer balancer = new BracketsBalancer("(([[{}]]))");
        balancer.check();
    }
}