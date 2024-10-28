package a.linkedList_Tree;

class SortedListNode {
	int val;
	SortedListNode next;
	SortedListNode(int x) {
		val = x;
	}
}//https://leetcode.com/problems/merge-two-sorted-lists/description/ 
public class MergeSorted {
	public static SortedListNode mergeTwoLists(SortedListNode l1, SortedListNode l2) {

		SortedListNode current = new SortedListNode(0);

		// SortedListNode current = dummyHead; // DK OR below line
		SortedListNode dummyHead = current;
		// if not sorted then for loop and then compare
		// 1 3 5 // 2 4 6
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				current.next = l1;
				l1 = l1.next;
			} else {
				current.next = l2;
				l2 = l2.next;
			}
			current = current.next;
		}

		// Attach remaining elements
		if (l1 != null) {
			current.next = l1;
		} else {
			current.next = l2;
		}
		// DK - we have to ignore 0 value which we initialized
		return dummyHead.next;

	}

	// Helper method to print the list
	public static void printList(SortedListNode head) {
		SortedListNode current = head;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Create two sorted lists
		SortedListNode l1 = new SortedListNode(1);
		l1.next = new SortedListNode(3);
		l1.next.next = new SortedListNode(5);

		SortedListNode l2 = new SortedListNode(2);
		l2.next = new SortedListNode(4);
		l2.next.next = new SortedListNode(6);

		// Merge the lists
		SortedListNode mergedList = mergeTwoLists(l1, l2);

		// Print the merged list
		printList(mergedList);
	}
}
