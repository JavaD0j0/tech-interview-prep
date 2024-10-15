package concepts.linkedlist;

/*
    Given the linked list and an integer, k, return the head of the linked list after swapping the values of the kth
     node from the beginning and the kth node from the end of the linked list.

    Note: We’ll number the nodes of the linked list starting from 1 to n.

    Constraints:
        1) The linked list will have n number of nodes.
        2) 1 ≤ k ≤ n ≤ 500
        3) −5000 ≤ Node.value ≤ 5000
 */
public class SwappingNodesLinkedList {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static LinkedListNode swapNodes(LinkedListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        LinkedListNode current = head;
        LinkedListNode front = null;
        LinkedListNode end = null;
        int count = 0;

        while (current != null) {
            count++;
            if (end != null) {
                end = end.next;
            }

            if (count == k) {
                front = current;
                end = head;
            }

            current = current.next;
        }

        int temp = front.data;
        front.data = end.data;
        end.data = temp;

        return head;
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

        int k = 2;
        LinkedListNode result = swapNodes(head, k);
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
