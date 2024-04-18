package com.example;

/**
 * Task here is to write a list. Each element must know the element before and
 * after it. Print out your list and them remove the element in the middle of
 * the list. Print out again.
 *
 */


public class TASK2 {

    public static void main(String[] args) {
        LinkedListNode myList = new LinkedListNode();
        myList.addNode(1);
        myList.addNode(2);
        myList.addNode(3);
        myList.addNode(4);
        myList.addNode(5);
        myList.addNode(6);
        myList.addNode(7);
        myList.addNode(8);
        myList.addNode(9);

        System.out.println("List:");
        myList.printNodeList();

        myList.removeNodeAtMid();
        System.out.println("List after removed node at mid:");
        myList.printNodeList();
    }
}
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListNode {
    Node head;

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void removeNodeAtMid() {
        if (head == null || head.next == null) {
            return;
        }

        Node secondToLast = head;
        Node advancedNode = head;
        Node nodeToDelete = null;

        while (advancedNode != null && advancedNode.next != null) {
            advancedNode = advancedNode.next.next;
            nodeToDelete = secondToLast;
            secondToLast = secondToLast.next;
        }

        nodeToDelete.next = secondToLast.next;
    }

    public void printNodeList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}