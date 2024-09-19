package concepts.twopointers;

/*
 * Time Complexity: O(n), since we traverse the entire array once.
 * Space Complexity: O(1)
 */
public class SortColors {
    public static int[] sortColors(int[] colors) {
        int curr = 0;
        int start = 0;
        int end = colors.length - 1;

        while (curr <= end) {
            if (colors[curr] == 0) {
                int temp = colors[start];
                colors[start] = colors[curr];
                colors[curr] = temp;
                start++;
                curr++;
            
            } else if (colors[curr] == 1) {
                curr++;
            } else {
                int temp = colors[end];
                colors[end] = colors[curr];
                colors[curr] = temp;
                end--;
            }
        }

        return colors;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();


        int[] colors = { 2, 0, 2, 1, 1, 0 };
        int[] sortedColors = sortColors(colors);
        for (int color : sortedColors) {
            System.out.print(color + " ");
        }
    }
}
