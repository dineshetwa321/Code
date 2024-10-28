package a.linkedList_Tree;
//https://leetcode.com/problems/add-two-numbers-ii/description/
//https://leetcode.com/problems/add-two-numbers/description/	
class LinkedListAdd {
	static class Node {
		int data;Node next;
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	Node head;	// Method to append a new node at the end
	public void addNext(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		}
		Node current = head; // 1st time 1st element then move this current to last
		while (current.next != null) {
			current = current.next;
		}
		current.next = new Node(data);
	}
	// Method to add two numbers represented by linked lists
	public static LinkedListAdd addTwoNumbers(LinkedListAdd l1, LinkedListAdd l2) {
		Node n1 = l1.head;
		Node n2 = l2.head;

		LinkedListAdd result = new LinkedListAdd();
		int carry = 0;
		int sum = 0;
		while (n1 != null || n2 != null) { // OR operator this
			sum = carry;
			if (n1 != null) {
				sum += n1.data;
				n1 = n1.next;
			}
			if (n2 != null) {
				sum += n2.data;
				n2 = n2.next;
			}
			carry = sum / 10;
			int add = sum % 10;
			System.out.println("carry : remain :" + carry + ":" + add);
			result.addNext(add);
		}// this is for last element in th list in case any cary
		if (carry > 0) {
			result.addNext(carry);
		}
		return result;
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
}

public class AddTwoSorted {

	public static void main(String[] args) {
		LinkedListAdd l1 = new LinkedListAdd();
		l1.addNext(2);
		l1.addNext(4);
		l1.addNext(7);

		LinkedListAdd l2 = new LinkedListAdd();
		l2.addNext(5);
		l2.addNext(6);
		l2.addNext(4);

		System.out.println("List A:");
		l1.printList();
		System.out.println("List B:");
		l2.printList();

		LinkedListAdd result = new LinkedListAdd();
		result = LinkedListAdd.addTwoNumbers(l1, l2);
		System.out.println("Sum:");

		result.printList();
	}
}
