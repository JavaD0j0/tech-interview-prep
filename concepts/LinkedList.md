# Pattern: In-Place Manipulation of a Linked List

The in-place manipulation of a linked list pattern allows us to modify a linked list without using any additional memory. In-place refers to an algorithm that processes or modifies a data structure using only the existing memory space, without requiring additional memory proportional to the input size. This pattern is best suited for problems where we need to modify the structure of the linked list, i.e., the order in which nodes are linked together. For example, some problems require a reversal of a set of nodes in a linked list which can extend to reversing the whole linked list. Instead of making a new linked list with reversed links, we can do it in place without using additional memory.

The naive approach to reverse a linked list is to traverse it and produce a new linked list with every link reversed. The time complexity of this algorithm is O(n) while consuming O(n) extra space. How can we implement the in-place reversal of nodes so that no extra space is used? We iterate over the linked list while keeping track of three nodes: the current node, the next node, and the previous node. Keeping track of these three nodes enables us to efficiently reverse the links between every pair of nodes. This in-place reversal of a linked list works in O(n) time and consumes only O(1) space.

## Conditions

This pattern matches your problem if all these conditions are fulfilled:

- `Linked list restructuring` : The input data is given as a linked list, and the task is to modify its structure without modifying the data of the individual nodes.
- `In-place modification` : The modifications to the linked list must be made in place, that is, we're not allowed to use more than O(1) additional space. 

## Examples

Problems that can be solved with this approach:

1. `Reverse the second half of a linked list`: Given a singly linked list, reverse the second half of the list.
2. `Rotate a linked list clockwise k times` : Given a singly linked list and an integer k, rotate the linked list clockwise k times.
