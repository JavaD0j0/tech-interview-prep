# Pattern: K-way Merge

The K-way merge pattern is an essential algorithmic strategy for merging K sorted data structures, such as arrays and linked lists, into a single sorted data structure. This technique is an expansion of the standard merge sort algorithm, which traditionally merges two sorted data structures into one.

> Note: For simplicity, we’ll use the term lists to refer to arrays and linked lists in our discussion.

To understand the basics of this algorithm, first, we need to know the basic idea behind the K-way merge algorithm. The K-way merge algorithm works by repeatedly selecting the smallest (or largest, if we’re sorting in descending order) element from among the first elements of the K input lists and adding this element to a new output list (with the same data type as the inputs). This process is repeated until all elements from all input lists have been merged into the output list, maintaining the sorted order.

Now, let’s take a closer look at how the algorithm works. The K-way merge algorithm comprises two main approaches to achieve its goal, both leading to the same result.

Here, we’ll discuss one of the approaches, which uses a minheap:

- Using a min heap

    1. Insert the first element of each list into a min heap. This sets up our starting point, with the heap helping us efficiently track the smallest current element among the lists.

    2. Remove the smallest element from the heap (which is always at the top) and add it to the output list. This ensures that our output list is being assembled in sorted order.

    3. Keep track of which list each element in the heap came from. This is for knowing where to find the next element to add to the heap.

    4. After removing the smallest element from the heap and adding it to the output list, replace it with the next element from the same list the removed element belonged to.

    5. Repeat steps 2–4 until all elements from all input lists have been merged into the output list.

Besides using a min heap, another effective approach for performing a K-way merge involves grouping and merging pairs of lists. This technique simplifies the merging process by reducing it to a series of two-way merges.

- Making groups of two and repeatedly merging them

    1. Start by dividing the K sorted lists into pairs, making groups of two. This organizes our lists into manageable units for merging.

    2. For each pair of lists, perform a standard two-way merge operation. This is similar to the merge step in merge sort, where two sorted lists are combined into a single sorted list. This step results in k/2k/2 merged lists.

    3. If there are an odd number of lists in a group at any point, simply leave one list unmerged in that round. This ensures that no list is left out of the merging process.

    4. Repeat the process of pairing up the resulting lists from the previous merge and merging them again until only one sorted list remains, which is the final result.


## Conditions

This pattern matches your problem if all these conditions are fulfilled:

- `Involves merging sorted arrays or a matrix`: The problem involves a collection of sorted arrays or a matrix with rows or columns sorted in a specific order that needs to be merges. This could be the core of the problem or a step toward the solution.
- `Seeking the kth smallest/largest across sorted collections`: The problem involves indentifying the kth smallest or largest element across multiple sorted arrays or linked lists.  

## Examples

Problems that can be solved with this approach:

1. `Median of k sorted arrays`: Find the median of the k sorted arrays.
2. `The kth smallest element in multiple sorted arrays`: Find the kth smalles element of multiple sorted arrays.
