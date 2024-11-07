package concepts.fastandslowpointers;

/*
    Given the head of a singly linked list, return the middle node of the linked list. If the number of nodes in the linked list is even, 
    there will be two middle nodes, so return the second one.

    Constraints:
    Let n be the number of nodes in a linked list.
        1) 1 ≤ n ≤ 100
        2) 1 ≤ node.data ≤ 100
        3) head != NULL
 */
public class MiddleOfLinkedList {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public LinkedListNode middleNode(LinkedListNode head) {
     
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);

        MiddleOfLinkedList middleOfLinkedList = new MiddleOfLinkedList();
        LinkedListNode middle = middleOfLinkedList.middleNode(head);
        System.out.println(middle.data);
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
