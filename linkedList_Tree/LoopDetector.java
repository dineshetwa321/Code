package a.linkedList_Tree;

public class LoopDetector {

	// Method to detect loop using Floyd’s Cycle-Finding Algorithm
	/*
	 * Floyd’s Cycle-Finding Algorithm (also known as the Tortoise and Hare
	 * algorithm). This approach uses two pointers:   The slow pointer moves one step at a time, while the fast
	 * pointer moves two steps. If there is a cycle, the fast pointer will
	 * eventually meet the slow pointer inside the loop.
	 */
	public static boolean hasLoopFloyd(ListNode head) {
		if (head == null)
			return false;

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next; // Move slow pointer by one
			fast = fast.next.next; // Move fast pointer by two

			if (slow == fast) {
				return true; // Loop detected
			}
		}

		return false; // No loop
	}

	// Helper method to create a loop for testing
	public static void createLoop(ListNode head, int position) {
		if (position == -1)
			return;

		ListNode loopNode = head;
		ListNode tail = head;

		for (int i = 1; i < position; i++) {
			if (loopNode.next != null) {
				loopNode = loopNode.next;
			}
		}

		while (tail.next != null) {
			tail = tail.next;
		}

		tail.next = loopNode;
		int a = 0;// DK
	}

	public static void main(String[] args) {
		// Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		// head.next.next.next.next.next = new ListNode(3);

		// Creating a loop: connecting node 5 to node 3
		createLoop(head, 6); // DK check that with linklise with new node value 3 in last , have loop
								// detected or not

		boolean hasLoop = hasLoopFloyd(head);
		System.out.println("Loop detected using Floyd’s Algorithm: " + hasLoop);
	}
}
