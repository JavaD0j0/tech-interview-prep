package concepts.kwaymerge;

/*
    Given two sorted integer arrays, nums1nums1 and nums2nums2, and the number of data elements in each array, mm and nn, 
    implement a function that merges the second array into the first one. You have to modify nums1nums1 in place.

    Note: Assume that nums1nums1 has a size equal to m+nm+n, meaning it has enough space to hold additional elements from nums2nums2.

Constraints:
    1) nums1.length = m + n
    2) nums2.length = n
    3) 0 ≤ m, n ≤ 200
    4) 1 ≤ m + n ≤ 200
    5) −10^3 ≤ nums1[i], nums2[j] ≤ 10^3
 */
public class MergeSortedArray {
    /*
     * Time Complexity: O(m + n)
     * Space Complexity: O(1)
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;     // index of last element in nums1
        int p2 = n - 1;     // index of last element in nums2

        for (int p = m + n - 1; p >= 0; p--) {
            if (p2 < 0) {
                break;
            }

            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = { 2, 6, 9 };
        merge(nums1, 3, nums2, 3);

        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
    }
}
