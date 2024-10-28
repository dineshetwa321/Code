package a.linkedList_Tree;

class ListNodeDup {
	int data;
	ListNodeDup next;

	ListNodeDup(int d) {
		data = d;
		next = null;
	}
}

class GfG {
	// Function to remove duplicates from sorted linked list.
	static ListNodeDup removeDuplicates(ListNodeDup head) {
		// Your code here
		ListNodeDup current = head;
		while (current.next != null) {
			if (current.data == current.next.data) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}

		}
		return head;
	}

	public static void main(String[] args) {

		ListNodeDup head = new ListNodeDup(1);
		head.next = new ListNodeDup(2);
		head.next.next = new ListNodeDup(3);
		head.next.next.next = new ListNodeDup(4);
		head.next.next.next.next = new ListNodeDup(5);

		System.out.println("Longest recurring subsequence: " + removeDuplicates(head));
	}
}