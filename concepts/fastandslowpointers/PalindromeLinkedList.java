package concepts.fastandslowpointers;

import concepts.fastandslowpointers.MiddleOfLinkedList.LinkedListNode;

/*
    Given the head of a linked list, your task is to check whether the linked list is a palindrome or not. Return TRUE if the 
    linked list is a palindrome; otherwise, return FALSE.

    Note: The input linked list prior to the checking process should be identical to the list after the checking process has been completed.

    Constraints:
        Let n be the number of nodes in a linked list.
            1) 1 ≤ n ≤ 500
            2_ 0 ≤ Node.value ≤ 9.
 */
public class PalindromeLinkedList {
    
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
        public static boolean palindrome(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        
        while (fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;
        }
        
        slow = reverse(slow); // Reverse the second half
        fast = head;
        
        while (slow != null && fast != null) {
          if (slow.data != fast.data) {
            return false;
          }
          slow = slow.next;
          fast = fast.next;
        }
        
        return true;
    }

    private static LinkedListNode reverse(LinkedListNode currPtr) {
        LinkedListNode prev = null;
        while (currPtr != null) {
          LinkedListNode next = currPtr.next;
          currPtr.next = prev;
          prev = currPtr;
          currPtr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(3);
        head.next.next = new LinkedListNode(2);
        head.next.next.next = new LinkedListNode(1);
        System.out.println(palindrome(head));

        head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next = new LinkedListNode(1);
        head.next.next.next = new LinkedListNode(1);
        System.out.println(palindrome(head));
    }
}
