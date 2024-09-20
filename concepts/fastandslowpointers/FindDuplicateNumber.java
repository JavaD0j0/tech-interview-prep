package concepts.fastandslowpointers;

/*
   Given an array of positive numbers, `nums`, such that the values lie in the range [1,n], inclusive, and that there are 
   `n + 1` numbers in the array, find and return the duplicate number present in `nums`. There is only one repeated number in `nums`.

   Note: You cannot modify the given array nums. You have to solve the problem using only constant extra space.

   Constraints:
        1) 1 ≤ n ≤ 10^3
        2) nums.length = n + 1
        3)1 ≤ nums[i] ≤ n
        4) All the integers in `nums` are unique, except for one integer that will appear more than once.
 */
public class FindDuplicateNumber {
    
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int findDuplicate(int[] nums) {
      
        int slow = 0;
        int fast = 0;
        
        do {
          slow = nums[slow];
          fast = nums[nums[fast]];
        } while (slow != fast);
        
        slow = 0;
        while (slow != fast) {
          slow = nums[slow];
          fast = nums[fast];
        }
        
        return fast;
     }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();
        
        int[] nums = { 1, 3, 4, 2, 2 };
        System.out.println(findDuplicate(nums));

        int[] nums2 = { 3, 1, 3, 4, 2 };
        System.out.println(findDuplicate(nums2));
    }
}
