package a.linkedList_Tree;

public class PalindromeLinkList {
	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}

		// Step 1: Find the middle of the linked list using the slow and fast pointer
		// technique
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// Step 2: Reverse the second half of the list
		ListNode secondHalf = reverseList(slow);
		ListNode firstHalf = head;

		// Step 3: Compare the first half and the reversed second half
		while (secondHalf != null) {
			if (firstHalf.val != secondHalf.val) {
				return false;
			}
			firstHalf = firstHalf.next;
			secondHalf = secondHalf.next;
		}

		return true;
	}

	// Helper function to reverse a linked list (same as before)
	private static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
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

		head.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next.next.next.next = new ListNode(1);

		boolean isPalin = isPalindrome(head);

		System.out.print("isPalin : " + isPalin);

	}

}
