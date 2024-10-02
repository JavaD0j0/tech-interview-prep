# Table of Contents

1. [Introduction](#introduction)
2. [Easy Problems](#easy-example-problems)
3. [Medium Problems](#medium-example-problems)
4. [Practice Strategy](#practice-strategy)

## Introduction

This repository holds key concepts related to Algorithms and Data Structure concepts which are
great to review before any technical interview.

Solution to `Easy` and `Medium` LeetCode problems are provided as well (in Java).

## Easy Example Problems

| **Category**             | **Type of Problem**                                              | **Example Problems**                                                |
|--------------------------|------------------------------------------------------------------|---------------------------------------------------------------------|
| **Arrays and Strings**    | Basic Operations                                                | - Reverse a string or array<br>- Find the missing number<br>- Merge two sorted arrays |
|                          | Pattern Matching                                                | - Check if a string is a palindrome<br>- Longest common prefix      |
|                          | Subarray Problems                                               | - Maximum subarray sum<br>- Find the longest substring without repeating characters |
| **Hash Maps and Hash Sets**| Frequency Counting, Lookup                                      | - Two Sum<br>- Find the first non-repeating character<br>- Intersection of two arrays |
| **Stacks and Queues**     | Basic Stack Operations                                          | - Implement a stack using arrays or linked lists<br>- Valid parentheses |
|                          | Basic Queue Operations                                          | - Implement a queue using stacks<br>- Min stack                    |
| **Mathematical Problems** | Number Properties                                               | - Check if a number is a palindrome<br>- Count prime numbers<br>- Find the greatest common divisor (GCD) |
| **Two Pointers**          | Two Pointer Traversal                                           | - Move zeros to the end<br>- Two sum in a sorted array (find pairs with two pointers) |
| **Sorting and Searching** | Sorting                                                         | - Sort an array using merge sort or quicksort<br>- Merge sorted arrays |
|                          | Binary Search                                                   | - Find the index of a target element in a sorted array             |
|                          | Searching for Patterns                                          | - Search a 2D matrix<br>- Find the first bad version (binary search application) |
| **Prefix Sum**            | Cumulative Sum Techniques                                       | - Subarray sum equals K<br>- Range sum query                       |
| **Sliding Window**        | Fixed or Variable Window Sizes                                  | - Maximum subarray sum<br>- Longest substring with at most k distinct characters |
| **Bit Manipulation**      | Basic Bitwise Operations                                        | - Single number (find the number that appears only once using XOR)<br>- Count number of 1 bits |
| **Linked Lists**          | Basic Manipulation                                              | - Reverse a linked list<br>- Detect a cycle<br>- Find the middle node |
|                          | Deletion and Insertion                                          | - Delete a node in a singly linked list (given only access to that node) |
| **Greedy Algorithms**     | Simple Greedy Choices                                           | - Best time to buy and sell stock<br>- Assign cookies              |
| **Binary Trees**          | Basic Tree Traversal                                            | - Preorder, Inorder, Postorder traversals<br>- Find the maximum depth of a binary tree |
|                          | Tree Manipulation                                               | - Invert a binary tree<br>- Check if a tree is symmetric           |
|                          | Lowest Common Ancestor (LCA)                                    | - Find the LCA of two nodes in a binary tree                       |
| **Dynamic Programming**   | Basic Recurrence Relations                                      | - Fibonacci sequence<br>- Climbing stairs<br>- Min cost climbing stairs |

## Medium Example Problems

| **Category**             | **Type of Problem**                                              | **Example Problems**                                                |
|--------------------------|------------------------------------------------------------------|---------------------------------------------------------------------|
| **Arrays and Strings**    | Two-Pointer/Sliding Window Problems                             | - Longest substring without repeating characters<br>- Trapping Rain Water |
|                          | Subarray & Interval Problems                                    | - Maximum product subarray<br>- Merge intervals                    |
|                          | Pattern Matching                                                | - Longest palindromic substring<br>- Group anagrams                |
| **Hash Maps and Hash Sets**| Advanced Lookup and Grouping                                   | - Subarray sum equals K<br>- Top K frequent elements               |
|                          | Prefix and Suffix Arrays                                        | - Find all anagrams in a string<br>- Continuous subarray sum        |
| **Stacks and Queues**     | Advanced Stack Operations                                       | - Evaluate Reverse Polish Notation<br>- Largest rectangle in histogram |
|                          | Monotonic Stack/Queue                                           | - Daily temperatures<br>- Sliding window maximum                   |
| **Mathematical Problems** | Combinatorics and Probability                                   | - Combination sum<br>- Permutations<br>- Pow(x, n) (Implement power function) |
| **Two Pointers**          | More Complex Two Pointer Problems                              | - 3Sum problem<br>- Container with most water                      |
|                          | Fast and Slow Pointers                                          | - Linked list cycle II (find where cycle starts)<br>- Remove duplicates from sorted list II |
| **Sorting and Searching** | Sorting with Extra Conditions                                   | - Sort colors (Dutch National Flag problem)<br>- Kth largest element in an array |
|                          | Advanced Binary Search                                          | - Search in rotated sorted array<br>- Find peak element            |
| **Prefix Sum**            | Optimized Subarray Search                                      | - Maximum size subarray sum equals k<br>- Shortest subarray with sum >= s |
| **Sliding Window**        | Complex Window Problems                                        | - Minimum window substring<br>- Longest substring with at most two distinct characters |
| **Bit Manipulation**      | Advanced Bitwise Operations                                    | - Single number II (where every element appears three times except one)<br>- Reverse bits |
| **Linked Lists**          | Complex Manipulations                                          | - Add two numbers (linked list)<br>- Flatten a multilevel doubly linked list |
|                          | Splitting and Merging                                           | - Sort a linked list<br>- Reorder list                             |
| **Greedy Algorithms**     | Greedy with Constraints                                        | - Jump game<br>- Partition labels                                  |
| **Binary Trees**          | Tree Traversal with Conditions                                 | - Binary tree right side view<br>- Binary tree zigzag level order traversal |
|                          | Tree Construction and Manipulation                             | - Construct binary tree from preorder and inorder traversal<br>- Serialize and deserialize a binary tree |
|                          | Balanced and Binary Search Trees                               | - Validate binary search tree<br>- Lowest common ancestor in a binary search tree |
| **Dynamic Programming**   | Medium Recurrence Relations                                    | - Coin change<br>- Longest increasing subsequence<br>- House robber II |
|                          | 2D DP Problems                                                 | - Unique paths II<br>- Minimum path sum                            |

## Practice Strategy

### Week 1-2: Fundamentals of Data Structures

1) Arrays and Strings

        Basics: traversal, insertion, deletion
        Common problems: Two-pointer techniques, sliding window, palindrome checks
        Key algorithms: Reverse array/string, maximum subarray (Kadane’s algorithm)

2) Linked Lists

        Types: Singly, Doubly, Circular
        Operations: Insertion, deletion, reversing a list
        Common problems: Detect cycle, find middle element, merge two sorted lists

3) Stacks and Queues

        Implementation using arrays and linked lists
        Operations: Push, pop, enqueue, dequeue
        Common problems: Evaluate expressions, valid parentheses, stock span problem

### Week 3-4: Recursion and Backtracking

1) Recursion

        Basics: Recursive tree, base case, recursive case
        Problems: Factorial, Fibonacci, power of a number
        Key concepts: Tail recursion, memoization

2) Backtracking

        Common algorithms: N-Queens, permutations, combinations, Sudoku solver
        Problem-solving patterns: Exhaustive search, pruning search space

### Week 5-6: Trees

1) Binary Trees

        Traversals: Preorder, Inorder, Postorder, Level-order
        Common problems: Height, diameter of a tree, check for balanced tree

2) Binary Search Trees (BST)

        Operations: Insertion, deletion, search
        Common problems: Validate BST, find the k-th smallest/largest element

3) Advanced Trees

        Heaps (Max/Min): Heapify, extract max/min, priority queues
        Trie: Prefix-based search, autocomplete systems

### Week 7-8: Hashing and Searching

1) Hashing

        Hash maps: Implementations using chaining, open addressing
        Common problems: Two-sum, group anagrams, longest substring without repeating characters

2) Searching Algorithms

        Binary search (on sorted arrays)
        Search variations: Search in rotated arrays, search in matrix

### Week 9-10: Dynamic Programming

1) Dynamic Programming (DP)

        Memoization vs. tabulation
        Common problems: Fibonacci, coin change, longest common subsequence, knapsack problem

2) DP on Grids and Strings

        0/1 Knapsack, edit distance, unique paths
        Problem-solving patterns: Overlapping subproblems, optimal substructure

### Week 11-12: Graph Algorithms

1) Graph Representation and Traversals

        BFS and DFS: Search algorithms, detecting cycles
        Problems: Connected components, shortest path in unweighted graph

2) Advanced Graph Algorithms

        Dijkstra's, Bellman-Ford (shortest path)
        Topological sorting, minimum spanning tree (Kruskal, Prim)
        Problems: Word ladder, course schedule

### Week 13-14: Advanced Topics

1) Greedy Algorithms

        Problems: Activity selection, Huffman coding, minimum number of coins
        Greedy choice property, optimal substructure

2) Segment Trees and Fenwick Trees

        Problems: Range queries, point updates