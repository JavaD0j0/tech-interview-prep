/*
 * https://leetcode.com/problems/string-compression/?envType=study-plan-v2&envId=leetcode-75
 */
public class StringCompression {
    /*
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int compressBruteForce(char[] chars) {
        List<Character> compressed = new ArrayList<>();
        int read = 0; // Pointer to read the original array
        
        while (read < chars.length) {
            char currentChar = chars[read];
            int count = 0;

            // Count consecutive occurrences of the current character
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            compressed.add(currentChar);

            // If the count > 1, add the digits of the count to the compressed list
            if (count > 1) {
                for (char digit : Integer.toString(count).toCharArray()) {
                    compressed.add(digit);
                }
            }
        }

        // Overwrite the original array with the compressed data
        for (int i = 0; i < compressed.size(); i++) {
            chars[i] = compressed.get(i);
        }

        return compressed.size();
    }

    /*
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int compressOptimized(char[] chars) {
        int read = 0;
        int write = 0;

        while (read < chars.length) {
            char currentChar = chars[read];
            int count = 0;

            // Count consecutive occurrences of the current character
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            // Add the character to the compressed array
            chars[write++] = currentChar;

            // If the count > 1, add the digits of the count to the compressed array
            if (count > 1) {
                for (char digit : Integer.toString(count).toCharArray()) {
                    chars[write++] = digit;
                }
            }
        }

        return write;
    }
}
