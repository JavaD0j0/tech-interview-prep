package concepts.twopointers;

/*
    Given a string word and an abbreviation abbr, return TRUE if the abbreviation matches the given string. Otherwise, return FALSE.

    A certain word "calendar" can be abbreviated as follows:

        "cal3ar" ("cal end ar" skipping three characters "end" from the word "calendar" still matches the provided abbreviation)
        "c6r" ("c alenda r" skipping six characters "alenda" from the word "calendar" still matches the provided abbreviation)

    The following are not valid abbreviations:

        "c06r" (has leading zeroes)
        "cale0ndar" (replaces an empty string)
        "c24r" ("c al enda r" the replaced substrings are adjacent)

    Constraints:
        1) 1 ≤ word.length ≤ 20
        2) word consists of only lowercase English letters.
        3) 1 ≤ abbr.length ≤ 10
        4) abbr consists of lowercase English letters and digits.
        5)All the integers in abbr will fit in a 3232–bit integer.
 */
public class ValidWordAbbreviation {
    /*
    * Time Complexity: O(n)
    * Space Complexity: O(1)
    */
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
