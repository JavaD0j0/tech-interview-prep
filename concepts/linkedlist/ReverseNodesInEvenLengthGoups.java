package concepts.linkedlist;

/*
    Given the head of a linked list, the nodes in it are assigned to each group in a sequential manner. The length of these 
    groups follows the sequence of natural numbers. Natural numbers are positive whole numbers denoted by (1,2,3,4...).

    In other words:
        - The 1st node is assigned to the first group.
        - The 2nd and 3rd3rd nodes are assigned to the second group.
        - The 4th, 5th, and 6th nodes are assigned to the third group, and so on.

    Your task is to reverse the nodes in each group with an even number of nodes and return the head of the modified linked list.

    Note: The length of the last group may be less than or equal to 1 + the length of the second to the last group.

    Constraints:
        1) 1 ≤ Number of nodes ≤ 500
        2) 0 ≤ LinkedListNode.data ≤ 10^3
 */
public class ReverseNodesInEvenLengthGoups {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static LinkedListNode reverseEvenLengthGroups(LinkedListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

		LinkedListNode prev = head;
        LinkedListNode prevNext = null;
		LinkedListNode node, reverse, currNext, curr;
		int groupLen = 2; // head is part of the 1st group and is odd, so we start with 2nd group
		int numNodes;

		while (prev.next != null) {
			node = prev;
			numNodes = 0;

			for (int i = 0; i < groupLen; i ++) {
				if (node.next == null) {
                    break;
                }

				numNodes++;
				node = node.next;
			}

			if (numNodes % 2 != 0) {
			   prev = node; // odd length group so skip
			} else {
				reverse = node.next;
				curr = prev.next;

                // reverse the nodes in the group
                for (int j = 0; j < numNodes; j++) {
                    currNext = curr.next;
				    curr.next = reverse;
				    reverse = curr;
				    curr = currNext;
                }

                // connect the reversed group to the rest of the list
                prevNext = prev.next;
				prev.next = node;
			    prev = prevNext;
			}
            
			groupLen++;
		}

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
        head.next.next.next.next = new LinkedListNode(5);

        LinkedListNode result = reverseEvenLengthGroups(head);
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
