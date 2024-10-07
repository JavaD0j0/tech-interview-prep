package concepts.twopointers;

/*
    Given a sentence, reverse the order of its words without affecting the order of letters within the given word.

    Constraints:
        1) The sentence contains English uppercase and lowercase letters, digits, and spaces.
        2) 1 ≤ sentence.length ≤ 10^4
        3) The order of the letters within a word is not to be reversed.

        Note: The input string may contain leading or trailing spaces or multiple spaces between words. The returned string, however, 
        should only have a single space separating each word. Do not include any extra spaces.
 */
public class ReverseWordsInString {
    /*
    * Time Complexity: O(n)
    * Space Complexity: O(n)
    */
    public static String reverseWords(String s) {
        s = s.replaceAll("\\s+", " ").trim();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        for (int start = 0, end = 0; end <= sb.length() - 1; ++end) {
            if (sb.charAt(end) == ' ' || end == sb.length() - 1) {
                int startRev = start;
                int endRev = (end == sb.length() - 1) ? end : end - 1;

                while (startRev < endRev) {
                    char temp = sb.charAt(startRev);
                    sb.setCharAt(startRev, sb.charAt(endRev));
                    sb.setCharAt(endRev, temp);
                    startRev++;
                    endRev--;
                }

                start = end + 1;
                end = start;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        String test = "hello world";
        System.out.println(reverseWords(test));

        String test2 = "a good   example";
        System.out.println(reverseWords(test2));
    }
}
