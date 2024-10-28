package a.linkedList_Tree;

class ListNodeMiddle {
	int val;
	ListNodeMiddle next;

	ListNodeMiddle(int x) {
		val = x;
	}
}

public class MiddleElementSlowFastPtr {
	public ListNodeMiddle findMiddle(ListNodeMiddle head) {
		if (head == null)
			return null;

		ListNodeMiddle slow_1 = head;
		ListNodeMiddle fast_2ndElem = head;
		// 1 2 3 4 5 6 7 8 9
		while (fast_2ndElem != null && fast_2ndElem.next != null) {
			slow_1 = slow_1.next;
			fast_2ndElem = fast_2ndElem.next.next;

		}
		// System.out.println("i is :" + i);
		return slow_1;
	}

	public static void main(String[] args) {
		MiddleElementSlowFastPtr solution = new MiddleElementSlowFastPtr();

		// Example usage
		ListNodeMiddle head = new ListNodeMiddle(1);
		head.next = new ListNodeMiddle(2);
		head.next.next = new ListNodeMiddle(3);
		head.next.next.next = new ListNodeMiddle(4);
		head.next.next.next.next = new ListNodeMiddle(5);
		head.next.next.next.next.next = new ListNodeMiddle(6);

//		head.next.next.next.next.next = new ListNodeMiddle(7);
//		head.next.next.next.next.next = new ListNodeMiddle(8);
//		head.next.next.next.next.next = new ListNodeMiddle(9);

		ListNodeMiddle middle = solution.findMiddle(head);
		// System.out.println("Middle element: " + middle.val);

		ListNodeMiddle middle3 = solution.find3Middle(head);
		System.out.println("Middle 3 element: " + middle3.val);
	}

	public ListNodeMiddle find3Middle(ListNodeMiddle head) {
		if (head == null)
			return null;

		ListNodeMiddle slow_1 = head;
		ListNodeMiddle fast_2ndElem = head;
		int count = 0;

		// 1 2 3 4 5 6 7 8 9
		while (fast_2ndElem != null && fast_2ndElem.next != null && fast_2ndElem.next.next != null) {

			slow_1 = slow_1.next;
			fast_2ndElem = fast_2ndElem.next.next.next;
			count++;
			 System.out.println("slow_1 :" + slow_1.val);
			//System.out.println("fast_2ndElem :" + fast_2ndElem.val);
			//System.out.println("");
		}
		// System.out.println("i is :" + i);
		if (count % 3 == 0) {
			return slow_1;
		} else {
			return slow_1.next;
		}

	}
}