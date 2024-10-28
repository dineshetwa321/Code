package a.linkedList_Tree;


public class ReverseLinkList {

	// Utility function to print the linked list
	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static ListNode reverseIterativeGoodDK(ListNode curnt) {

		ListNode temp;
		ListNode prev = null; 
		// linked list: 1 -> 2 -> 3 -> 4 -> 5
		while (curnt != null) {
			temp = curnt.next; // next node
			curnt.next = prev;
			prev = curnt;
			curnt = temp;
		}
		return prev;

	}

	public static void main(String[] args) {
		// Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ListNode dkhead = reverseIterativeGoodDK(head);
		printList(dkhead);

		System.out.println("Original list:");
		printList(head);

	}

}
