package a.linkedList_Tree;

class LinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node head;

    public boolean detectLoop() {
        Node slow = head;
        Node fast = head;
        
        // Step 1: Detect Loop using Floyd’s Cycle-Finding Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow by one
            fast = fast.next.next;    // Move fast by two
            
            if (slow == fast) {       // If slow and fast meet, there is a loop
               return true;
            }
        }
		return false;
    }
    // Function to detect and remove loop in the linked list
    public void removeLoop() {
        Node slow = head;
        Node fast = head;
        
        // Step 1: Detect Loop using Floyd’s Cycle-Finding Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow by one
            fast = fast.next.next;    // Move fast by two
            
            if (slow == fast) {       // If slow and fast meet, there is a loop
                break;
            }
        }
        
        // If loop doesn't exist, return
        if (slow != fast) {
            return;
        }

        // Step 2: Find the start of the loop
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Now `slow` (or `fast`) is at the start of the loop
        
        // Step 3: Find the last node in the loop and disconnect it
        Node prev = null;
        while (fast.next != slow) {
            fast = fast.next;
        }
        fast.next = null;  // Remove the loop
    }

    // Utility function to add a new node at the end
    public void addToEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Utility function to create a loop for testing
    public void createLoop(int n) {
        Node temp = head;
        Node loopNode = head;
        int count = 1;
        while (count < n) {
            loopNode = loopNode.next;
            count++;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = loopNode;  // Create loop here
    }
}

/*
Explanation:
detectLoop() (same as in the previous code): Detects if a loop exists in the linked list.
removeLoop():
Uses the two-pointer method to detect the loop.
If a loop is found, both pointers (slow and fast) will eventually meet.
Reset one pointer (slow) to the head of the list and move both pointers one step at a time. They will meet at the starting node of the loop.
To remove the loop, traverse the loop with one pointer until you find the node whose next pointer points back to the starting node of the loop. Set this node’s next pointer to null, effectively removing the loop.
createLoop(): Manually creates a loop in the linked list for testing purposes.
The Main class tests the loop detection and removal methods by creating a linked list, adding elements, creating a loop, and then removing the loop.

 */
// Test the linked list for loop removal
public class LoopRemover {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        // Adding elements to the linked list
        list.addToEnd(10);
        list.addToEnd(20);
        list.addToEnd(30);
        list.addToEnd(40);
        list.addToEnd(50);
        
        // Creating a loop (for testing, loop at node 2)
        list.createLoop(2);

        if (list.detectLoop()) {
            System.out.println("Yes Loop exists in the linked list.");
        } 
        // Remove the loop
        list.removeLoop();
        
     //   System.out.println("Loop successfully removed from the linked list.");
        if (list.detectLoop()) {
            System.out.println("Loop still exists in the linked list.");
        } else {
            System.out.println("Loop successfully removed from the linked list.");
        }
    }
}
