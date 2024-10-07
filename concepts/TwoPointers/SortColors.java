package concepts.twopointers;

/*
    Given an array, colors, which contains a combination of the following three elements:
    - 0 (representing red)
    - 1 (representing white)
    - 2 (representing blue)

    Sort the array in place so that the elements of the same color are adjacent, with the colors in the order of red, white, and blue. 
    To improve your problem-solving skills, do not utilize the built-in sort function.

    Constraints:
        1) 1 ≤ colors.length ≤ 300
        2) colors[i] can only contain 0s, 1s, or 2s.
 */
public class SortColors {
    /*
    * Time Complexity: O(n), since we traverse the entire array once.
    * Space Complexity: O(1)
    */
    public static int[] sortColors(int[] colors) {
        int curr = 0;
        int start = 0;
        int end = colors.length - 1;

        while (curr <= end) {
            switch (colors[curr]) {
                case 0 ->                     {
                        int temp = colors[start];
                        colors[start] = colors[curr];
                        colors[curr] = temp;
                        start++;
                        curr++;
                    }
                case 1 -> curr++;
                default ->                     {
                        int temp = colors[end];
                        colors[end] = colors[curr];
                        colors[curr] = temp;
                        end--;
                    }
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
