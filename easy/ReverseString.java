package easy;

/*
    Write a function that reverses a string. The input string is given as an array of characters s.
    You must do this by modifying the input array in-place with O(1) extra memory.

    Example 1:
        Input: s = ["h","e","l","l","o"]
        Output: ["o","l","l","e","h"]

    Constraints:
        1) 1 <= s.length <= 105
        2) s[i] is a printable ascii character.
 */
public class ReverseString {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        ReverseString.reverseString(chars);
        for (char c : chars) {
            System.out.println(c);
        }
    }
}
