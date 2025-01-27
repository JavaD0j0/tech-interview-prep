/*
 *  https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {
    /*
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static int[] topKFrequentBruteForce(int[] arr, int k) {
        // Step 1: Create a frequency map of the elements in the array
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Sort the elements based on their frequency
        List<Integer> sortedElements = new ArrayList<>(frequencyMap.keySet());
        Collections.sort(sortedElements, (a, b) -> frequencyMap.get(b) - frequencyMap.get(a));

        // Step 3: Collect the top k frequent elements
        int[] topKElements = new int[k];
        for (int i = 0; i < k; i++) {
            topKElements[i] = sortedElements.get(i);
        }

        return topKElements;
    }

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int[] topKFrequentOptimized(int[] arr, int k) {
        // Step 1: Create a frequency map of the elements in the array
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a bucket to group elements by their frequency
        List<Integer>[] bucket = new List[arr.length + 1];
        for (int num : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(num);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(num);
        }

        // Step 3: Collect the top k frequent elements
        List<Integer> topKElements = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && topKElements.size() < k; i--) {
            if (bucket[i] != null) {
                topKElements.addAll(bucket[i]);
            }
        }

        return topKElements.stream().mapToInt(i -> i).toArray();
    }
}
