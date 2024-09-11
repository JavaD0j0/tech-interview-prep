package concepts.twopointers;

/*
 * Time Complexity: O(n)
 * 
 * Space Complexity: O(n)
 */
public class ReverseWordsInString {
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
