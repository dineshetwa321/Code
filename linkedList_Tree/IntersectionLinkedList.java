package a.linkedList_Tree;

public class IntersectionLinkedList {
	 
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	    if (headA == null || headB == null) {
	        return null;
	    }

	    ListNode pointerA = headA;
	    ListNode pointerB = headB;

	    // Traverse both lists
	    while (pointerA.val != pointerB.val) {
	        // Move to next node or reset to the head of the other list
	        pointerA = (pointerA == null) ? headB : pointerA.next;
	        pointerB = (pointerB == null) ? headA : pointerB.next;
	        System.out.println("pointerA : "+pointerA.val);
	    }

	    // Either they meet at the intersection or both are null (no intersection)
	    return pointerA;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(3);
		l1.next.next = new ListNode(5);
		 
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(5);
	 
		 
		ListNode result = IntersectionLinkedList.getIntersectionNode(l1, l2);
		System.out.println("Sum:"+result.val);

	 
	}
}
