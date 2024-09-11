# Pattern: Two Pointers

The two pointers pattern is a versatile technique used in problem-solving to efficiently traverse or manipulate sequential data structures, such as arrays or linked lists. As the name suggests, it involves maintaining two pointers that traverse the data structure in a coordinated manner, typically starting from different positions or moving in opposite directions. These pointers dynamically adjust based on specific conditions or criteria, allowing for the efficient exploration of the data and enabling solutions with optimal time and space complexity. Whenever there’s a requirement to find two data elements in an array that satisfy a certain condition, the two pointers pattern should be the first strategy to come to mind.

The pointers can be used to iterate through the data structure in one or both directions, depending on the problem statement. For example, to identify whether a string is a palindrome, we can use one pointer to iterate the string from the beginning and the other to iterate it from the end. At each step, we can compare the values of the two pointers and see if they meet the palindrome properties.

Example:

    MADAM -> is palindrome 

The naive approach to solving this problem would be using nested loops, with a time complexity of O(n^2). However, by using two pointers moving toward the middle from either end, we exploit the symmetry property of palindromic strings. This allows us to compare the elements in a single loop, making the algorithm more efficient with a time complexity of O(n).

## Conditions

This pattern matches your problem if all these conditions are fulfilled:

- `Linear data structure`: The input data can be traversed in a linear fashion, such as an array, linked list, or string.
- `Process pair`: Process data elements at two different positions simultaneously.
- `Dynamic pointer movement`: Both pointers move independently of each other according to certain conditions or criteria. In addition,  both pointers might move along the same or two different data structures.

## Examples

Other problems that can be solved with this approach:

1. `Reversing an Array`: Given an array of Integers, reverse it in place.
2. `Pair with given Sum in a Sorted Array`: Given a sorted array of Integers, find a pair in the array that sums to a number T.
3. `Palindrome`: Given a String, check if its palindromic meaning word is spelled the same backwards.
4. `Palindrom II`: Given a String, check if can be a valid palindrome by removing at most one character from it.
5. `Sum of Three Values`: Given an array of Integers, and an integer value "target", determine if three integers whose sum is equal to the target.
6. `Remove nth Node from End of List`: Given a singly linked list, remove the nth node from the end of the list and return its head.
7. `Sort Colors`: Given an array, sort the array in place so that the elements of the same color are adjacent, with the colors in the order of 0 (red), 1 (white), 2 (blue).
8. `Reverse Words in a String`: Given a sentence, reverse the order of its words without affecting the order of letters within the given word.
9. `Valid Word Abbreviation`: Given a string and an abbreviation "abbr", return true if the abbreviation matches the given string.
