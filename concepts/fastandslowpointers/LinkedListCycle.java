package concepts.fastandslowpointers;

/*
    Check whether or not a linked list contains a cycle. If a cycle exists, return TRUE. Otherwise, return FALSE. 
    The cycle means that at least one node can be reached again by traversing the `next` pointer.

    Constraints:
    Let n be the number of nodes in a linked list.

        1) 0 ≤ n ≤ 500
        2) −10^5 ≤ Node.data ≤ 10^5
 */
public class LinkedListCycle {
    
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static boolean detectCycle(LinkedListNode head) {

        if (head == null) {
            return false;
        }

        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = head.next;
        System.out.println(detectCycle(head));
    }

    public static class LinkedListNode {
        public int data;
        public LinkedListNode next;

        public LinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
