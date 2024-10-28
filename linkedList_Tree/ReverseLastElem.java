package a.linkedList_Tree;

class ListNodeCustom {
	int val;
	ListNodeCustom next;

	ListNodeCustom(int val) {
		this.val = val;
	}
}

public class ReverseLastElem {

	static ListNodeCustom dk(ListNodeCustom curr) {

		ListNodeCustom head= curr;
		ListNodeCustom lastNode = null;
		ListNodeCustom lastSecNode = null;	 
		while (curr.next != null) {

			lastSecNode = curr;
			lastNode = curr.next;
			curr= curr.next;

		}
		// 1 2 3 4 5
		lastSecNode.next = null;
		lastNode.next = head;
		return lastNode;
	}

	public static void main(String[] args) {

		ListNodeCustom head = new ListNodeCustom(1);
		head.next = new ListNodeCustom(2);
		head.next.next = new ListNodeCustom(3);
		head.next.next.next = new ListNodeCustom(4);
		head.next.next.next.next = new ListNodeCustom(5);

		ListNodeCustom moveToFront = moveToFront(head);
		System.out.println("move Last To Front list 1:");
		printList(moveToFront);

		
		ListNodeCustom headDk = new ListNodeCustom(1);
		headDk.next = new ListNodeCustom(2);
		headDk.next.next = new ListNodeCustom(3);
		headDk.next.next.next = new ListNodeCustom(4);
		headDk.next.next.next.next = new ListNodeCustom(5);
		ListNodeCustom moveToFront2 = dk(headDk);
		System.out.println("move Last To Front list 2:");
		printList(moveToFront2);

	}

	static ListNodeCustom moveToFront(ListNodeCustom head) {

		ListNodeCustom secLast = null;
		ListNodeCustom last = head;

		System.out.println(" WHILE IN ");
		while (last.next != null) {
			secLast = last;
			last = last.next;
		}
		System.out.println(" WHILE OUT ");
		// 1 2 3 4 5
		secLast.next = null;
		last.next = head;
		return last;
	}

	// Utility function to print the linked list
	public static void printList(ListNodeCustom head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
}
