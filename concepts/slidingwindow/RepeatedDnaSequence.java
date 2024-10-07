package concepts.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
    Given a string, dna, that represents a DNA subsequence, and a number kk, return all the contiguous subsequences (substrings) of 
    length kk that occur more than once in the string. The order of the returned subsequences does not matter. If no repeated substring is found, 
    the function should return an empty set.

    The DNA sequence is composed of a series of nucleotides abbreviated as AA, CC, GG, and TT. For example, ACGAATTCCGACGAATTCCG is a DNA sequence. 
    When studying DNA, it is useful to identify repeated sequences in it.

    Constraints:
        1) 1 ≤ dna.length ≤ 10^3
        2) dna[i] is either A, C, G, or T.
        3) 1 ≤ k ≤ 10
 */
public class RepeatedDnaSequence {
    /*
     * Time Complexity: 
     *  - Average Case: O(n)
     *  - Worst Case: O((n - k) * k)
     * Space Complexity: O(n)
     */
   public static Set<String> findRepeatedSequences(String dna, int k) {
        int stringLength = dna.length();

        if (stringLength < k) {
            return new HashSet<>();
        }

        Map<Character, Integer> mapping = new HashMap<>();
        mapping.put('A', 1);
        mapping.put('C', 2);
        mapping.put('G', 3);
        mapping.put('T', 4);

        int baseValue = 4;

        List<Integer> numbers = new ArrayList<>(Arrays.asList(new Integer[stringLength]));
        Arrays.fill(numbers.toArray(), 0);
        for (int i = 0; i < stringLength; i++) {
            numbers.set(i, mapping.get(dna.charAt(i)));
        }

        int hashValue = 0;

        Set<Integer> hashSet = new HashSet<>();
        Set<String> output = new HashSet<>();

        for (int i = 0; i < stringLength - k + 1; i++) {

            if (i == 0) {
                for (int j = 0; j < k; j++) {
                    hashValue += numbers.get(j) * (int) Math.pow(baseValue, k - j - 1);
                }
            } else {
                int previousHashValue = hashValue;
                hashValue = ((previousHashValue - numbers.get(i - 1) * (int) Math.pow(baseValue, k - 1)) * baseValue) + numbers.get(i + k - 1);
            }

            if (hashSet.contains(hashValue)) {
                output.add(dna.substring(i, i + k));
            }

            hashSet.add(hashValue);
        }
        return output;
   }

   public static void main(String[] args) {
        System.out.println();
        System.out.println();

        String dna = "AGACCTAGAC";
        int k = 3;
        System.out.println(findRepeatedSequences(dna, k));

        dna = "ACGT";
        k = 3;
        System.out.println(findRepeatedSequences(dna, k));

        dna = "AAAAACCCCCAAAAACCCCCC";
        k = 8;
        System.out.println(findRepeatedSequences(dna, k));
   }
}
