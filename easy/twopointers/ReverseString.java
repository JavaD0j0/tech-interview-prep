package easy.twopointers;

/*
    https://leetcode.com/problems/reverse-string/description/
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
