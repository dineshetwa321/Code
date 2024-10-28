package a.linkedList_Tree;

import java.util.HashSet;
import java.util.LinkedList;

class RemoveDuplicates_LinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // Method to insert a new node at the end
    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    // Method to print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to remove duplicates from an unsorted linked list
    public void removeDuplicates() {
        if (head == null) return;

        HashSet<Integer> seen = new HashSet<>();
        Node current = head;
        Node prev = null;
        while (current != null) {
            if (seen.contains(current.data)) {
                prev.next = current.next;
            } else {
                seen.add(current.data);
                prev = current;
            }
            current = current.next;
        }
    }

    LinkedList list = new LinkedList();
    
    public static void main(String[] args) {
    	RemoveDuplicates_LinkedList list = new RemoveDuplicates_LinkedList();
        list.append(10);
        list.append(20);
        list.append(10);
        list.append(30);
        list.append(40);
        list.append(20);
        
        System.out.println("Original list:");
        list.printList();
        
        list.removeDuplicates();
        
        System.out.println("List after removing duplicates:");
        list.printList();
    }
}
