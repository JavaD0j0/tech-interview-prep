/*
 * https://leetcode.com/problems/minimum-number-of-food-buckets-to-feed-the-hamsters/description/
 */
public class MinNumberOfBuckets {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int minimumBucketsBruteForce(String street) {
        char[] streetArray = street.toCharArray();
        int n = streetArray.length;
        int buckets = 0;

        for (int i = 0; i < n; i++) {
            // Check if the current position is a house ('H')
            if (streetArray[i] == 'H') {
                // Try placing a bucket to the left of the house
                if (i > 0 && streetArray[i - 1] == '.') {
                    streetArray[i - 1] = 'B';
                    buckets++;
                } 
                // If not possible, try placing a bucket to the right of the house
                else if (i < n - 1 && streetArray[i + 1] == '.') {
                    streetArray[i + 1] = 'B';
                    buckets++;
                } else {
                    // If no bucket can be placed, return -1 as its impossible
                    return -1;
                }
            }
        }

        return buckets;
    }

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int minimumBucketsOptimized(String street) {
        int n = street.length();
        int buckets = 0;
        int i = 0;

        while (i < n) {
            // Check if the current position is a house ('H')
            if (street.charAt(i) == 'H') {
                // Try placing a bucket to the right of the house
                if (i < n - 1 && street.charAt(i + 1) == '.') {
                    buckets++;
                    i += 2; // Skip the next house as its already fed
                } 
                // If not possible, check if a bucket can be placed to the left
                else if (i > 0 && street.charAt(i - 1) == '.') {
                    buckets++;
                } else {
                    // If no bucket can be placed, return -1 as its impossible
                    return -1;
                }
            }
            i++; // Move to the next position
        }

        return buckets;
    }
}
