package concepts.linkedlist;

/*
    Given a singly linked list with nn nodes and two positions, left and right, the objective is to reverse the nodes 
    of the list from left to right. Return the modified list.

    Constraints:
        1) 1 ≤ n ≤ 500
        2) −5000 ≤ node.data ≤ 5000
        3) 1 ≤ left ≤ right ≤ n
 */
public class ReverseLinkedListII {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static LinkedListNode reverseBetween(LinkedListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;
        LinkedListNode prev = dummy;

        // Move prev to the (left - 1)th node
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        LinkedListNode curr = prev.next;

        // Reverse the nodes between left and right
        for (int i = 0; i < right - left; i++) {
            LinkedListNode nextNode = curr.next;
            curr.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
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

        LinkedListNode result = reverseBetween(head, 2, 4);
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
