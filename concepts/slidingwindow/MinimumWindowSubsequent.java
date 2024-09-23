package concepts.slidingwindow;

/*
    Given two strings, str1 and str2, find the shortest substring in str1 such that str2 is a subsequence of that substring.

    A substring is defined as a contiguous sequence of characters within a string. A subsequence is a sequence that can be derived 
    from another sequence by deleting zero or more elements without changing the order of the remaining elements.

    Let’s say you have the following two strings:
        - str1 = “abbcbabbcb”
        - str2 = “acac”

    In this example, “abbcabbc” is a substring of str1, from which we can derive str2 simply by deleting both the instances of the character bb. 
    Therefore, str2 is a subsequence of this substring. Since this substring is the shortest among all the substrings in which str2 is 
    present as a subsequence, the function should return this substring, that is, “abbcabbc”.

    > If there is no substring in str1 that covers all characters in str2, return an empty string.
    > If there are multiple minimum-length substrings that meet the subsequence requirement, return the one with the left-most starting index.

    Constraints:
        1) 1 ≤ str1.length ≤ 2 × 10^3
        2) 1 ≤ str2.length ≤ 100
        3) str1 and str2 consist of uppercase and lowercase English letters.
 */
public class MinimumWindowSubsequent {
    
    /*
     * Time Complexity: O(n x m)
     * Space Complexity: O(1)
     */
    public static String minWindow(String str1, String str2) {

        float length = Float.POSITIVE_INFINITY;
        int indexS1 = 0;
        int indexS2 = 0;
        int start = 0, end = 0;
        String minSubsequence = "";

        while (indexS1 < str1.length()) {
          if (str1.charAt(indexS1) == str2.charAt(indexS2)) {
            indexS2 += 1;

            if (indexS2 == str2.length()) {
              start = indexS1;
              end = indexS1;
              indexS2 -= 1;

              while (indexS2 >= 0) {
                if (str1.charAt(start) == str2.charAt(indexS2)) {
                  indexS2 -= 1;
                }
                start -= 1;
              }

              start += 1;
              if ((end - start + 1) < length) {
                length = end - start + 1;
                minSubsequence = str1.substring(start, end + 1);
              }

              indexS1 = start;
              indexS2 = 0;
            }
          }

          indexS1 += 1;
        }

        return minSubsequence;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        String[] str1 = {"abcdedeaqdweq", "fgrqsqsnodwmxzkzxwqegkndaa", "zxcvnhss", "alpha", "beta"};
        String[] str2 = {"adeq", "kzed", "css", "la", "ab"};

        for (int i = 0; i < str1.length; i++) {
            System.out.println("\tSubsequence string: " + minWindow(str1[i], str2[i]));
        }
    }
}
