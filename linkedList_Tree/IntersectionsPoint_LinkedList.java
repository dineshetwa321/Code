package a.linkedList_Tree;


public class IntersectionsPoint_LinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        // Find the lengths of both linked lists
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        // Calculate the difference in lengths
        int diff = Math.abs(lengthA - lengthB);

        // Align the start of both lists
        if (lengthA > lengthB) {
            headA = advanceListBy(headA, diff);
        } else {
            headB = advanceListBy(headB, diff);
        }

        // Traverse both lists together to find the intersection point
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null; // No intersection
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    private ListNode advanceListBy(ListNode head, int steps) {
        while (steps > 0 && head != null) {
            head = head.next;
            steps--;
        }
        return head;
    }

    public static void main(String[] args) {
        // Example to test the intersection function
    	IntersectionsPoint_LinkedList solution = new IntersectionsPoint_LinkedList();

        ListNode common = new ListNode(8);
        common.next = new ListNode(10);

        ListNode headA = new ListNode(3);
        headA.next = new ListNode(6);
        headA.next.next = new ListNode(9);
        headA.next.next.next = common;

        
        ListNode headB = new ListNode(4);
        headB.next = common;

        ListNode intersection = solution.getIntersectionNode(headA, headB);

        if (intersection != null) {
            System.out.println("Intersection at node with value: " + intersection.val);
        } else {
            System.out.println("No intersection found.");
        }
    }
}
