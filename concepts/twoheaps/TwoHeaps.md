# Pattern: Two Heaps

The two heaps pattern is a versatile and efficient approach used to solve problems involving dynamic data processing, optimization, and real-time analysis. As the name suggests, this pattern maintains two heaps, which could be either two min heaps, two max heaps, or a min heap and a max heap. Exploiting the heap property, the two heaps pattern is a preferred technique for various problems to implement computationally efficient solutions. For a heap containing nn elements, inserting or removing an element takes O(logn) time, while accessing the element at the root is done in O(1) time. The root stores the smallest element in the case of a min heap and the largest element in the case of a max heap.

Let’s explore a few example scenarios to gain a better understanding. In some problems, we’re given a dataset and tasked to divide it into two parts to find the smallest value from one part and the largest value from the other part. To achieve this, we can build two heaps: one min heap and one max heap, from these two subsets of data. The root of the min heap will give us the smallest value from its corresponding dataset, while the root of the max heap will provide the largest value from its dataset. In cases where we need to find the two largest numbers from two different datasets, we’ll use two max heaps to store and manage these datasets. Similarly, to find the two smallest numbers from two different datasets, we would use two min heaps. These examples illustrate the versatility of using min heaps and max heaps to efficiently solve different types of problems by facilitating quick access to the smallest or largest values as required.

## Conditions

This pattern matches your problem if all these conditions are fulfilled:

- `Static or streaming data`: The input could either be:
    - `Linear data`: The input data is linear but not sorted. If the input data is sorted, this pattern wont apply.
    - `Stream of data`: The input data is a continous stream of data.
- `Maxima and minima calculation`: The input data can be categorized in two parts, and we need to repeatedly calculate two maxima, two minima, or one maximum and one minimum from the two sets, respectively.

## Examples

Problems that can be solved with this approach:

1. `Sliding Window Median`: Given an array of integers and a window size k, find the median of each sliding window of size k as it moves from the left to right through the array.
2. `Find median of a number stream`: Given a continous stream of numbers, find the median of the numbers seen so far after any insertion in constant time.
