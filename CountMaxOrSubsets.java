/**
 * 2044. Count Number of Maximum Bitwise-OR Subsets
 * 
 * Given an integer array nums, find the maximum possible bitwise OR of a subset of nums 
 * and return the number of different non-empty subsets with the maximum bitwise OR.
 * 
 * An array a is a subset of an array b if a can be obtained from b by deleting some 
 * (possibly zero) elements of b. Two subsets are considered different if the indices 
 * of the elements chosen are different.
 * 
 * Example 1:
 * Input: nums = [3,1]
 * Output: 2
 * Explanation: The maximum possible bitwise OR of a subset is 3. 
 * There are 2 subsets with a bitwise OR of 3: [3] and [3,1].
 * 
 * Example 2:
 * Input: nums = [2,2,2]
 * Output: 7
 * Explanation: All non-empty subsets of [2,2,2] have a bitwise OR of 2. 
 * There are 2^3 - 1 = 7 total subsets.
 * 
 * Example 3:
 * Input: nums = [3,2,1,5]
 * Output: 6
 * Explanation: The maximum possible bitwise OR of a subset is 7. 
 * There are 6 subsets with a bitwise OR of 7.
 * 
 * Constraints:
 * 1 <= nums.length <= 16
 * 1 <= nums[i] <= 10^5
 */

 public class CountMaxOrSubsets {

    /**
     * Simplified approach.
     * 
     * Step 1: Calculate the maximum bitwise OR for all subsets.
     * Step 2: Use backtracking to count subsets that yield the maximum bitwise OR.
     */
    public int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;
        // Step 1: Calculate the maximum OR possible by OR-ing all elements in the array
        for (int num : nums) {
            maxOR |= num;
        }
        
        // Step 2: Use backtracking to count subsets that yield the maximum OR
        return backtrack(nums, maxOR, 0, 0);
    }

    // Helper function to use backtracking to find the number of subsets matching the max OR
    private int backtrack(int[] nums, int maxOR, int index, int currentOR) {
        // Base case: if we've considered all elements, check if the current OR equals the max OR
        if (index == nums.length) {
            return currentOR == maxOR ? 1 : 0;
        }

        // Optimization: If the current OR is already equal to max OR, count remaining subsets
        if (currentOR == maxOR) {
            return 1 << (nums.length - index);
        }

        // Recursive case: include or exclude the current element from the subset
        return backtrack(nums, maxOR, index + 1, currentOR | nums[index]) + 
               backtrack(nums, maxOR, index + 1, currentOR);
    }

    /**
     * Original approach (backtracking without optimization).
     * 
     * Same concept as the simplified version but without the optimization of early exit.
     */
    public int countMaxOrSubsetsOriginal(int[] nums) {
        int maxOR = 0;
        // Calculate the maximum OR by OR-ing all elements in the array
        for (int num : nums) {
            maxOR |= num;
        }
        
        // Backtrack to find how many subsets have the max OR
        return backtrackOriginal(nums, maxOR, 0, 0);
    }

    // Backtracking method without optimization
    private int backtrackOriginal(int[] nums, int maxOR, int index, int currentOR) {
        // Base case: if we've considered all elements, check if the current OR equals the max OR
        if (index == nums.length) {
            return currentOR == maxOR ? 1 : 0;
        }

        // Recursive case: include or exclude the current element from the subset
        return backtrackOriginal(nums, maxOR, index + 1, currentOR | nums[index]) + 
               backtrackOriginal(nums, maxOR, index + 1, currentOR);
    }

    // Main method for testing both approaches
    public static void main(String[] args) {
        CountMaxOrSubsets solution = new CountMaxOrSubsets();
        
        // Example 1
        int[] nums1 = {3, 1};
        System.out.println("Simplified Output for nums1: " + solution.countMaxOrSubsets(nums1)); // Output: 2
        System.out.println("Original Output for nums1: " + solution.countMaxOrSubsetsOriginal(nums1)); // Output: 2

        // Example 2
        int[] nums2 = {2, 2, 2};
        System.out.println("Simplified Output for nums2: " + solution.countMaxOrSubsets(nums2));  // Output: 7
        System.out.println("Original Output for nums2: " + solution.countMaxOrSubsetsOriginal(nums2));  // Output: 7

        // Example 3
        int[] nums3 = {3, 2, 1, 5};
        System.out.println("Simplified Output for nums3: " + solution.countMaxOrSubsets(nums3));  // Output: 6
        System.out.println("Original Output for nums3: " + solution.countMaxOrSubsetsOriginal(nums3));  // Output: 6
    }
}
