package concepts.twopointers;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ValidWordAbbreviation {
    public static boolean validWordAbbreviation(String word, String abbr) {
        int wordIndex = 0;
        int abbrIndex = 0;

        while (abbrIndex < abbr.length()) {
            if (Character.isDigit(abbr.charAt(abbrIndex))) {
                if (abbr.charAt(abbrIndex) == '0') {
                    return false;
                }
                int num = 0;

                while (abbrIndex < abbr.length() && Character.isDigit(abbr.charAt(abbrIndex))) {
                    num = num + Character.getNumericValue(abbr.charAt(abbrIndex));
                    abbrIndex++;
                }
                wordIndex += num;
            } else {
                if (wordIndex >= word.length() || word.charAt(wordIndex) != abbr.charAt(abbrIndex)) {
                    return false;
                }
                wordIndex++;
                abbrIndex++;
            }
        }

        return wordIndex == word.length() && abbrIndex == abbr.length();
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        String word = "mario";
        String abbr = "m2io";
        System.out.println(validWordAbbreviation(word, abbr));

        String word2 = "melissa";
        String abbr2 = "me12";
        System.out.println(validWordAbbreviation(word2, abbr2));
    }
}
