package concepts.linkedlist;

/*
    Given the head of a singly linked list, reverse the linked list and return its updated head.

    Constraints:

    Let n be the number of nodes in a linked list.
        1) 1 ≤ n ≤ 500
        2) −5000 ≤ Node.value ≤ 5000
 */
public class ReverseLinkedList {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public LinkedListNode reverse(LinkedListNode head) {
     
        LinkedListNode prev = null;
        LinkedListNode next = null;
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

        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        LinkedListNode reversed = reverseLinkedList.reverse(head);
        // Print the reversed linked list
        while (reversed != null) {
            System.out.print(reversed.data + " ");
            reversed = reversed.next;
        }
    }
}
