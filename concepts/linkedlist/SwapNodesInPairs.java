package concepts.linkedlist;

/*
    Given a singly linked list, swap every two adjacent nodes of the linked list. After the swap, return the head of the linked list.

    Note: Solve the problem without modifying the values in the list’s nodes. In other words, only the nodes themselves can be changed.

    Constraints:
        1) The number of nodes in the list is in the range [0,100].
        2) 0 ≤ Node.value ≤ 100
 */
public class SwapNodesInPairs {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static LinkedListNode swapPairs(LinkedListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        
        // Recursive method
        // LinkedListNode next = head.next;
        // head.next = swapPairs(next.next);
        // next.next = head;
        // return next;

        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;
        LinkedListNode prev = dummy;
        LinkedListNode curr = head;

        while (curr != null && curr.next != null) {
            // Identify the nodes to be swapped
            LinkedListNode first = curr;
            LinkedListNode second = curr.next;

            // Perform the swap
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // Move the pointers for the next pair
            prev = first;
            curr = first.next;
        }

        return dummy.next;
    }

    public static class LinkedListNode {
        public int data;
        public LinkedListNode next;

        public LinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);

        LinkedListNode result = swapPairs(head);
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
