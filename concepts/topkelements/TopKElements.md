# Pattern: Top K Elements

The top k elements pattern is an important technique in coding that helps us efficiently find a specific number of elements, known as k, from a set of data. This is particularly useful when we’re tasked with identifying the largest, smallest, or most/least frequent elements within an unsorted collection.

To solve tasks like these, one might think to sort the entire collection first, which takes O(nlog⁡(n)) time, and then select the top k elements, taking additional O(k) time. However, the top k elements pattern bypasses the need for full sorting, reducing the time complexity to O(nlog⁡k) by managing which elements we compare and keep track of.

Which data structure can we use to solve such problems? A heap is the best data structure to keep track of the smallest or largest k elements. With this pattern, we either use a max heap or a min heap to find the smallest or largest k elements, respectively, because they allow us to efficiently maintain a collection of elements ordered in a way that gives us quick access to the smallest (min heap) or largest (max heap) element.

For example, let’s look at how this pattern operates to solve the problem of finding the top k largest elements (by using min heap) or top k smallest elements (by using max heap):

    1. Insert the first k elements from the given set of elements into a heap. If we’re looking for the largest elements, use a min heap to keep the smallest of the large elements at the top. Conversely, for the smallest elements, use a max heap to keep the largest of the small elements at the top.

    2. Iterate through the remaining elements of the given set.
        2.1. For a min heap, if we find an element larger than the top, remove the top element (the smallest of the large elements) and insert the new, larger element. This ensures the heap always contains the largest elements seen so far.
        2.2 For a max heap, if we find an element smaller than the top, remove the top element (the largest of the small elements) and insert the new, smaller element, keeping the heap filled with the smallest elements seen so far.

The efficiency of this pattern comes from the ability of the heap to insert and remove elements in O(log⁡k) time. Because we only maintain k elements in the heap, these operations are quick, and we can process all nn elements in the given set in O(nlog⁡k) time.

> It’s important to note that while accessing the top element of the heap can be done in O(1) time, retrieving all k elements, if necessary, involves removing them one by one. This process takes O(klog⁡k) time because each removal necessitates reorganizing the heap.

## Conditions

This pattern matches your problem if all these conditions are fulfilled:

- `Sort characters by frequency`: Sort a string in increasing order based on the frequency of its characters.
- `Connect n ropes with minimum cost`: Connect n ropes into one rope with minimum cost, such that the cost to connect two ropes is equal to the sum of their lengths. 

## Examples

Problems that can be solved with this approach:

Yes, if both of these conditions are fulfilled:
    1. `Unsorted list analysis`: e need to extract a specific subset of elements based on their size (largest or smallest), frequency (most or least frequent), or other similar criteria from an unsorted list. This may be the requirement of the final solution, or it may be necessary as an intermediate step toward the final solution.
    2. `Identifying a specific subset`: The goal is to identify a subset rather than just a single extreme value. When phrases like top k, kth largest/smallest, k most frequent, k closest, or k highest/lowest describe our task, it suggests the top k elements pattern is ideal for efficiently identifying a specific subset.

No, if any of these conditions is fulfilles:
    1. `Presorted input`: The input data is already sorted according to the criteria relevant to solving the problem.
    2. `Single extreme value`: If only 11 extreme value (either the maximum or minimum) is required, that is, k=1, as that problem can be solved in O(n) with a simple linear scan through the input data.
