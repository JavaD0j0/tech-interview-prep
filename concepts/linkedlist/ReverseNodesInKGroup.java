package concepts.linkedlist;

/*
    The task is to reverse the nodes in groups of k in a given linked list, where k is a positive integer, and at most the 
    length of the linked list. If any remaining nodes are not part of a group of k, they should remain in their original order.

    It is not allowed to change the values of the nodes in the linked list. Only the order of the nodes can be modified.

    Note: Use only O(1) extra memory space.

    Constraints:
    Let n be the number of nodes in a linked list.
        1) 1 ≤ k ≤ n ≤ 500
        2) 0 ≤ Node.value ≤ 1000
 */
public class ReverseNodesInKGroup {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static LinkedListNode reverseKGroup(LinkedListNode head, int k) {
        
        if (head == null || k == 1) {
            return head;
        }

        // Dummy node to help handle edge cases
        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;

        LinkedListNode curr = dummy;
        LinkedListNode prev = dummy; 
        LinkedListNode next = dummy;
        int count = 0;

        // First, count the number of nodes in the linked list
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }

        // While there are at least k nodes to reverse
        while (count >= k) {
            curr = prev.next;  // curr will point to the start of the current group
            next = curr.next;  // next will point to the node following curr

            // Reverse the k nodes
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            
            // Move prev to curr, which is now the end of the reversed group
            prev = curr;
            count -= k;
        }

        return dummy.next;  // Return the new head of the reversed list
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
        
        head = reverseKGroup(head, 2);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
