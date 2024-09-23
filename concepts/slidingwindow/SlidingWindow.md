# Pattern: Sliding Window

The sliding window pattern is used to process sequential data, arrays, and strings, for example, to efficiently solve subarray or substring problems. It involves maintaining a dynamic window that slides through the array or string, adjusting its boundaries as needed to track relevant elements or characters. The window is used to slide over the data in chunks corresponding to the window size, and this can be set according to the problem’s requirements. It may be viewed as a variation of the two pointers pattern, with the pointers being used to set the window bounds.

Imagine you’re in a long hallway lined with paintings, and you’re looking through a narrow frame that only reveals a portion of this hallway at any time. As you move the frame along the hallway, new paintings come into view while others leave the frame. This process of moving and adjusting what’s visible through the frame is akin to how the sliding window technique operates over data.

Why is this method more efficient? Consider we need to find kk consecutive integers with the largest sum in an array. The time complexity of the naive solution to this problem would be O(kn)O(kn) , because we need to compute sums of all subarrays of size kk. On the other hand, if we employ the sliding window pattern, instead of computing the sum of all elements in the window, we can just subtract the element exiting the window, add the element entering the window, and update the maximum sum accordingly. In this way, we can update the sums in constant time, yielding an overall time complexity of O(n)O(n). To summarize, generally, the computations performed every time the window moves should take O(1)O(1) time or a slow-growing function, such as the log of a small variable.

## Conditions

This pattern matches your problem if all these conditions are fulfilled:

- `Contiguous data`: The input data is stored in a contiguous manner, such as an array or string.
- `Processing subsets of elements`: The problem requires repeated computations on a contiguous susbtet of data elements (a subrarray of a substring), such that the window moves across the input array from one end to the other. The size of the window may be fixed or variable, depending the requirement of the problem.
- `Efficient computation time complexity`: The computations performed every time the window moves take constant or very small time.

## Examples

Problems that can be solved with this approach:

1) `Maximum sum subarray of size K`: Given an array of intergers and a positive interger k, find the maximum sum of any contiguous subarray of size k.
2) `Longest substring without repeating characters`: Given a string, find the length of the longest substring without repeating characters.
