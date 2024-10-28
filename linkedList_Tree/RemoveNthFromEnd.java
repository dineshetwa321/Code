
package a.linkedList_Tree;

public class RemoveNthFromEnd {

	public static void main(String[] args) {
		// Example: Given a linked list [1, 2, 3, 4, 5] and n = 2
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ListNode dummy = head; // Dummy node to handle edge cases
		ListNode first = dummy.next;
		ListNode second = dummy;

		int count = 1;

		// int n = 4;
		int n = 2;
		while (first != null && count < n - 1) {
			first = first.next;
			second = second.next;
			count++;
			// System.out.println(first.val + ":" + second.val);
		}

		second.next = first.next;
		// dummy = second;

		printList(dummy);
		// The resulting linked list is [1, 2, 3, 5]

	}

	static public void printList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		System.out.println();
	}
}
