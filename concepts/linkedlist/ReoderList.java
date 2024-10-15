package concepts.linkedlist;

/*
    Given the head of a singly linked list, reorder the list as if it were folded on itself. For example, if the list is represented as follows:

    L0 → L1​ → L2​ → … → Ln−2 → Ln−1 → Ln

    This is how you’ll reorder it:

    L0 → Ln → L1 → Ln−1 → L2 → Ln−2​ → …

    You don’t need to modify the values in the list’s nodes; only the links between nodes need to be changed.

    Constraints:
        1) The range of number of nodes in the list is [1,500].
        2) −5000 ≤ Node.value ≤ 5000
 */
public class ReoderList {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static LinkedListNode reorderList(LinkedListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        LinkedListNode second = slow.next;
        slow.next = null;
        second = reverse(second);

        LinkedListNode first = head;
        while (second != null) {
            LinkedListNode temp = first.next;
            first.next = second;
            second = second.next;
            first.next.next = temp;
            first = temp;
        }

        return head;
    }

    public static LinkedListNode reverse(LinkedListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        LinkedListNode next = null;
        LinkedListNode prev = null;
        LinkedListNode curr = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
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

        LinkedListNode head = new LinkedListNode(3);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(1);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);

        LinkedListNode result = reorderList(head);
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
