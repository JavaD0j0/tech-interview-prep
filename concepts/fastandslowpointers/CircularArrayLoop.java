package concepts.fastandslowpointers;

/*
    We are given a circular array of non-zero integers, nums, where each integer represents the number of steps to be taken 
    either forward or backward from its current index. Positive values indicate forward movement, while negative values 
    imply backward movement. When reaching either end of the array, the traversal wraps around to the opposite end.

    The input array may contain a cycle, which is a sequence of indexes characterized by the following:
        - The sequence starts and ends at the same index.
        - The length of the sequence is at least two.
        - The loop must be in a single direction, forward or backward.

        Note: A cycle in the array does not have to originate at the beginning. It may begin from any point in the array.

    Your task is to determine if nums has a cycle. Return TRUE if there is a cycle. Otherwise return FALSE.

    Constraints:
        1) 1 ≤ nums.length ≤103
        2) −5000 ≤ nums[i] ≤ 5000
        3) nums[i] != 0
 */
public class CircularArrayLoop {

    /*
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static boolean circularArrayLoop(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int slow = i;
            int fast = i;
            boolean forward = nums[i] > 0;

            while (true) {
                slow = nextStep(slow, nums[slow], nums.length);

                if (isNotCycle(nums, forward, slow))
                    break;

                fast = nextStep(fast, nums[fast], nums.length);

                if (isNotCycle(nums, forward, fast))
                    break;

                fast = nextStep(fast, nums[fast], nums.length);

                if (isNotCycle(nums, forward, fast))
                    break;

                if (slow == fast)
                    return true;
            }
        }

        return false;
    }

    // A function to calculate the next step
    public static int nextStep(int pointer, int value, int size) {
        int result = (pointer + value) % size;
        if (result < 0) {
            result += size;
        }
        return result;
    }
    
    // A function to detect a cycle doesn't exist
    public static boolean isNotCycle(int[] nums, boolean prevDirection, int pointer) {
        boolean currDirection = nums[pointer] >= 0;

        return prevDirection != currDirection || Math.abs(nums[pointer] % nums.length) == 0;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        int[] nums = { -2, -3, -9 };
        System.out.println(circularArrayLoop(nums));

        int[] nums2 = { 1, 2, -3, 3, 4, 7, 1 };
        System.out.println(circularArrayLoop(nums2));
    }
}
