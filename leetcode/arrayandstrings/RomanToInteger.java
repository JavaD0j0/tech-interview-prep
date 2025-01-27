/*
 * https://leetcode.com/problems/roman-to-integer/description/
 */
public class RomanToInteger {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int romanToInt(String s) {
        char charArray[] = s.toCharArray();
        int count = 0;

        for (int i = 0; i < charArray.length - 1; i++) {
            int current = getRomanValue(charArray[i]);
            int next = getRomanValue(charArray[i + 1]);
            
            if (current < next) {
                count -= current;
            } else {
                count += current;
            }
        }

        // Add the value of the last character
        count += getRomanValue(charArray[charArray.length - 1]);
        return count;
  }

  private int getRomanValue(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
  }
}
