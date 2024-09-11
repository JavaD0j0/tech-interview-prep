package concepts.TwoPointers;

/*
 * Time Complexity: O(n), where n is the length of the linked list.
 * 
 * Space Complexity: O(1)
 */
public class RemoveNthNodeFromEnd {
    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
        LinkedListNode left = head;
        LinkedListNode right = head;

        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        if (right == null) {
            return head.next;
        }

        while (right.next != null) {
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;

        return head;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        int[] lst = { 1, 2, 3, 4, 5 };
        LinkedList<Integer> lstObj = new LinkedList<>();
        lstObj.createLinkedList(lst);
        removeNthLastNode(lstObj.head, 2);
        lstObj.printList();
    }
}

class LinkedListNode {
    public int data;
    public LinkedListNode next;
    
    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList<T> {
    public LinkedListNode head;

    public LinkedList() {
        this.head = null;
    }

    public void insertNodeAtHead(LinkedListNode node) {
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    public void createLinkedList(int[] lst) {
        for (int i = lst.length - 1; i >= 0; i--) {
            LinkedListNode newNode = new LinkedListNode(lst[i]);
            insertNodeAtHead(newNode);
        }
    }

    public void printList() {
        LinkedListNode current = this.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
