# Big O

Big O notation is a mathematical notation used to describe the upper bound of an algorithm's running time or space requirements in terms of input size (usually denoted as n). It provides a high-level understanding of the algorithm's efficiency and how it scales with larger inputs.

Reference: https://www.bigocheatsheet.com/

## Time Complexity Classes

Here are common Big O time complexities you'll encounter:

    O(1) – Constant Time:
        Description: Execution time remains constant regardless of input size.
        Example: Accessing an element in an array by index.

    O(log n) – Logarithmic Time:
        Description: Execution time grows logarithmically as input size increases.
        Example: Binary search in a sorted array.

    O(n) – Linear Time:
        Description: Execution time grows linearly with input size.
        Example: Iterating through all elements in a list.

    O(n log n) – Linearithmic Time:
        Description: Combination of linear and logarithmic growth.
        Example: Efficient sorting algorithms like mergesort and heapsort.

    O(n²) – Quadratic Time:
        Description: Execution time grows quadratically with input size.
        Example: Nested loops over the same dataset, like bubble sort.

    O(2ⁿ) – Exponential Time:
        Description: Execution time doubles with each additional input.
        Example: Recursive algorithms solving the Tower of Hanoi.

    O(n!) – Factorial Time:
        Description: Execution time grows factorially.
        Example: Generating all permutations of a set.

## Space Complexity Classes

Space complexity refers to the amount of memory an algorithm uses relative to the input size.

    O(1) Space: Uses a constant amount of additional space.
    O(n) Space: Uses space proportional to the input size.

## Analyzing Algorithms

To determine an algorithm's Big O complexity:

1) Identify the Basic Operations: Focus on the most significant operations that contribute to the total running time.

2) Count the Number of Operations:
    - Loops:
        Single loop over n elements → O(n).
        Nested loops over n elements → O(n²).
    - Recursive Calls: Analyze the depth and number of recursive calls.

3) Drop Constants and Lower Order Terms:
    - Big O notation describes asymptotic behavior; constants and less significant terms are ignored.

4) Consider Worst-Case Scenarios:
    - Big O usually describes the worst-case complexity.

## Tim and Space Complexity Examples

### O(1) - Constant

Regardless of the input size, this algorithm performs a single operation.

```java
public class ConstantTimeExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println(numbers[0]);  // Accessing the first element is O(1)
    }
}
```

An algorithm that uses a fixed amount of extra space, regardless of the input size.

```java
public class ConstantSpaceExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int sum = 0;  // This variable takes constant space (O(1))
        for (int number : numbers) {
            sum += number;  // We aren't using any extra space, just the 'sum' variable
        }
        System.out.println(sum);
    }
}
```

- Explanation: The space complexity is O(1) because we only need space for the `sum` variable, regardless of the input size.

### O(n) - Linear

The time taken grows linearly with the size of the input.

```java
public class LinearTimeExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        for (int number : numbers) {  // Looping through n elements is O(n)
            System.out.println(number);
        }
    }
}
```

An algorithm where the space grows linearly with the size of the input.

```java
public class LinearSpaceExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int[] squaredNumbers = new int[numbers.length];  // This array takes O(n) space
        for (int i = 0; i < numbers.length; i++) {
            squaredNumbers[i] = numbers[i] * numbers[i];
        }
        for (int squared : squaredNumbers) {
            System.out.println(squared);
        }
    }
}
```

- Explanation: The space complexity is O(n) because we are creating an additional array (`squaredNumbrs`) of the same size as the input array.

### O(n^2) - Quadratic

Nested loops result in the time complexity increasing quadratically with the size of the input.

```java
public class QuadraticTimeExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {  // Nested loop causes O(n^2)
                System.out.println(numbers[i] + ", " + numbers[j]);
            }
        }
    }
}
```

This space complexity often arises when dealing with matrices or 2D arrays, where the space requirement grows quadratically with the input size.

```java
public class QuadraticSpaceExample {
    public static void main(String[] args) {
        int n = 3;
        int[][] matrix = new int[n][n];  // A 2D array of size n x n, which is O(n^2)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = i + j;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

- Explanation: The space complexity is O(n^2) because we are creating a 2D array (or matrix) of size `n x n`.

### O(log n) - Logarithmic

Efficient algorithms like binary search have logarithmic time complexity.

```java
import java.util.Arrays;

public class LogarithmicTimeExample {
    public static void main(String[] args) {
        int[] sortedNumbers = {1, 2, 3, 4, 5};
        int key = 3;
        int result = Arrays.binarySearch(sortedNumbers, key);  // Binary search is O(log n)
        System.out.println(result);
    }
}
```

Certain algorithms, such as recursive divide-and-conquer algorithms (like binary search), use logarithmic space because the recursion depth is O(log n).

```java
public class LogarithmicSpaceExample {
    public static void main(String[] args) {
        int[] sortedNumbers = {1, 2, 3, 4, 5};
        int key = 3;
        System.out.println(binarySearch(sortedNumbers, key, 0, sortedNumbers.length - 1));
    }

    public static int binarySearch(int[] arr, int key, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] > key) {
            return binarySearch(arr, key, low, mid - 1);  // Each recursive call reduces search space by half (O(log n))
        } else {
            return binarySearch(arr, key, mid + 1, high);
        }
    }
}
```

- Explanation: The space complexity is O(log n) due to the recursive call stack, which grows logarithmically with the size of the array.

### O(n log n) - Linearithmic

Merge sort is a common algorithm with this time complexity.

```java
import java.util.Arrays;

public class LinearithmicTimeExample {
    public static void main(String[] args) {
        int[] numbers = {3, 5, 1, 4, 2};
        Arrays.sort(numbers);  // Sorting in Java uses TimSort which is O(n log n)
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
```

Sorting algorithms like Merge Sort often have O(n log n) time complexity but can also require O(n) additional space for the temporary arrays used during the merge process.

```java
import java.util.Arrays;

public class LinearithmicSpaceExample {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];  // O(n) space for temporary arrays
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
```

- Explanation: Merge Sort uses O(n log n) time complexity, but its space complexity is O(n) because we need additional space for temporary arrays during the merging process.

### O(2^n) - Exponential

This time complexity typically arises in algorithms with recursion, such as solving the Fibonacci sequence.

```java
public class ExponentialTimeExample {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fibonacci(n));  // Fibonacci with recursion is O(2^n)
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
```

### O(n!) - Factorial

An example of factorial complexity is the traveling salesman problem, where every possible permutation is checked.

```java
public class FactorialTimeExample {
    public static void main(String[] args) {
        int n = 4;
        permutation("", "ABCD");  // Finding all permutations is O(n!)
    }

    public static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
            }
        }
    }
}
```

A typical example of O(n!) space complexity arises in algorithms that generate all permutations of a set.

```java
public class FactorialSpaceExample {
    public static void main(String[] args) {
        int n = 3;
        String[] set = {"A", "B", "C"};
        permute(set, 0, n - 1);
    }

    public static void permute(String[] arr, int left, int right) {
        if (left == right) {
            for (String s : arr) {
                System.out.print(s + " ");
            }
            System.out.println();
        } else {
            for (int i = left; i <= right; i++) {
                swap(arr, left, i);
                permute(arr, left + 1, right);  // Each recursive call generates new arrangements
                swap(arr, left, i);
            }
        }
    }

    public static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

- Explanation: The space complexity is O(n!) because we are generating every possible permutation of the input set, and the number of recursive calls and the storage needed for intermediate results grow factorially with the size of the input.
