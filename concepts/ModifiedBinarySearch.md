# Pattern: Modified Binary Search

The modified binary search pattern is an extension of the traditional binary search algorithm and can be applied to a wide range of problems. Before we delve into the modified version, let’s first recap the classic binary search algorithm.

## Classic Binary Search

Binary search is an efficient search algorithm for searching a target value in sorted arrays or sorted lists that support direct addressing (also known as random access). It follows a divide-and-conquer approach, significantly reducing the search space with each iteration. The algorithm uses three indexes—start, end, and middle—and proceeds as follows:

    1. Set the start and end indexes to the first and last elements of the array, respectively.

    2. Calculate the position of the middle index by taking the average of the start and end indexes. For example, if start=0 and end=7, then middle=⌊(0+7)/2⌋=3.

    3. Compare the target value with the element at the middle index.

    4. If the target value is equal to the middle index element, we have found the target, and the search terminates.

    5. If the target value is less than the middle index element, update the end index to middle−1 and repeat from step 2 onwards. Because the array is sorted, all the values between the middle and the end indexes will also be greater than the target value. Therefore, there’s no reason to consider that half of the search space.

    6. If the target value is greater than the middle index element, update the start index to middle+1middle+1 and repeat from step 2. Again, because the array is sorted, all the values between the start and the middle indexes will also be less than the target value. Therefore, there’s no reason to consider that half of the search space.

    7. Continue the process until the target value is found or if the search space is exhausted, that is, if the start index has crossed the end index. This means that the algorithm has explored all possible values, which implies that the search space is now empty and the target value is not present.

    > Note: We’re assuming the array is sorted in ascending order. If it’s sorted in descending order, we’ll do the opposite when changing the positions of the start and end pointers. Also, to avoid integer overflow when calculating the middle index, especially in languages with limited integer ranges, we can use start + (end - start) / 2 instead of (start + end) / 2.

Binary search reaches the target value in O(log⁡(n)) time because we divide the array into two halves at each step and then focus on only one of these halves. If we had opted for the brute-force approach, we would have had to traverse the entire array without any partitioning to search for the target value, which would take O(n) in the worst case.

## Modified Binary Search

The modified binary search pattern builds upon the basic binary search algorithm discussed above. It involves adapting the traditional binary search approach by applying certain conditions or transformations, allowing us to solve problems in which input data are modified in a certain way.

A few common variations of the modified binary search pattern are:

    1. Binary search on a modified array: Sometimes, the array may be modified in a certain way, which affects the search process. For example, the array might be sorted and then rotated around some unknown pivot. Alternatively, some elements in a sorted array might be modified based on a specific condition. To handle such scenarios, we can modify the basic binary search technique to detect anomalies in the sorted order.

    2. Binary search with multiple requirements: When searching for a target satisfying multiple requirements, a modified binary search can be used. It involves adapting the comparison logic within the binary search to accommodate multiple specifications. Examples include finding a target range rather than a single target or finding the leftmost or the rightmost occurrence of a target value.

## Conditions

This pattern matches your problem if all these conditions are fulfilled:

- Yes, if either of these conditions is fulfilled:

    1. `Target value in sorted data`: The problem involves locating a specific target value—or identifying its first or last occurrence—within a sorted array or list. This pattern applies to data structures that support direct addressing.

    2. `Partially sorted segments`: We may use this pattern when segments of an input array are sorted.

- No, if either of these conditions is fulfilled:

    1. `Lack of direct addressing`: The input data structure does not support direct addressing.

    2. `Unsorted or inappropriately sorted data`: The data to search is not sorted according to criteria relevant to the search. For example, if we’re looking for a particular date in a list of dates, but the list is sorted in alphabetical order (and not chronologically), we cannot use binary search.

    3. `Non-value-based solutions`: The problem does not require identifying a specific value or range of values. For example, if we have a list of student names only and we want to search for a student, modified binary search won’t be a correct choice.

## Examples

Problems that can be solved with this approach:

1. `First and last position of an element in a sorted array`: For a given integer array sorted in increasing order, find the starting and ending position of a given target value.
2. `Sqrt(x)`: Find the integer square root of a positive number, x.
