/*
 * https://leetcode.com/problems/group-anagrams/description/
 */
public class GroupAnagram {
    /*
     * Time Complexity: O(m * n * log(n)) where m is the length of the input array and n is the length of the longest string in the array
     * Space Complexity: O(m * n)
     */
    public List<List<String>> groupAnagramsBruteForce(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }

            map.get(sortedStr).add(str);
        }

        return new ArrayList<>(map.values());
    }

    /*
     * Time Complexity: O(m * n) where m is the length of the input array and n is the length of the longest string in the array
     * Space Complexity: O(m * n)
     */
    public List<List<String>> groupAnagramsOptimized(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] count = new int[26];

            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
