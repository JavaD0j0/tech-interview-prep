package concepts.kwaymerge;

import java.util.List;

/*
    Given an array of k sorted linked lists, your task is to merge them into a single sorted linked list and return the head of this linked list.

    Constraints:
        1) k = lists.length
        2) 0 ≤ k ≤ 10^3
        3) 0 ≤ lists[i].length ≤ 500
        4) −10^3 ≤ lists[i][j] ≤ 10^3
        5) Each lists[i] is sorted in ascending order.
        6) The sum of all lists[i].length will not exceed 10^3.
 */
public class MergeKLinkedLists {
    /*
     * Time Complexity: O(n log k)
     * Space Complexity: O(1)
     */
    public static LinkedListNode mergeKLists(List<LinkedList> lists) {
        if (lists.isEmpty()) {
            return null;
        } else {
            int step = 1;
            while(step < lists.size()) {
                // The loop merges lists that are 'step' apart.For example, if we have 4 lists (L1, L2, L3, L4), with step = 1, 
                // we'll first merge L1 with L2, and L3 with L4 etc. After each iteration, the step size doubles (step *= 2). 
                // This merges the results of previous merges, for example, after the first iteration with step = 1, we merge the 
                // results of L1 + L2 with L3 + L4 in the next iteration when step = 2.
                for(int i = 0; i < lists.size() - step;  i += step * 2) {
                    lists.get(i).head =  merge2Lists(lists.get(i).head, lists.get(i + step).head);
                }
                step *= 2;
            }

			return lists.get(0).head;
        }
	}

    // Helper function
  	public static LinkedListNode merge2Lists(LinkedListNode head1, LinkedListNode head2) {
		LinkedListNode dummy = new LinkedListNode(-1);
		LinkedListNode prev = dummy; 

        // Add the nodes in sorted order
		while (head1 != null && head2 != null) {
			if (head1.data <= head2.data) {
				prev.next = head1;
				head1 = head1.next;
			} else {
				prev.next = head2;
				head2 = head2.next;
			}
			prev = prev.next;
		}

        // Add the remaining nodes
		if (head1 == null) {
			prev.next = head2;
        } else {
			prev.next = head1;
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

    public static class LinkedList {
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

        public void createLinkedList(List<Integer> lst) {
            for (int i = lst.size() - 1; i >= 0; i--) {
                LinkedListNode newNode = new LinkedListNode(lst.get(i));
                insertNodeAtHead(newNode);
            }
        }
    }

    public static void printListWithForwardArrow(LinkedListNode head) {
        LinkedListNode temp = head;
        
        while (temp != null) {
            System.out.print(temp.data); // print node value
            temp = temp.next;
            if (temp != null) {
                System.out.print(" -> ");
            }
        }
        // if this is the last node, print null at the end
        System.out.print(" -> null ");
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        LinkedList list1 = new LinkedList();
        list1.createLinkedList(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        LinkedList list2 = new LinkedList();
        list2.createLinkedList(List.of(11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
        LinkedList list3 = new LinkedList();
        list3.createLinkedList(List.of(21, 22, 23, 24, 25, 26, 27, 28, 29, 30));
        LinkedList list4 = new LinkedList();
        list4.createLinkedList(List.of(31, 32, 33, 34, 35, 36, 37, 38, 39, 40));
        LinkedList list5 = new LinkedList();

        List<LinkedList> lists = List.of(list1, list2, list3, list4, list5);
        LinkedListNode mergedList = mergeKLists(lists);
        MergeKLinkedLists.printListWithForwardArrow(mergedList);
    }
}
