/**
 * 39. Combination Sum
 * 
 * Given an array of distinct integers candidates and a target integer target, 
 * return a list of all unique combinations of candidates where the chosen numbers sum to target. 
 * You may return the combinations in any order.
 * 
 * The same number may be chosen from candidates an unlimited number of times. 
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * 
 * The test cases are generated such that the number of unique combinations 
 * that sum up to target is less than 150 combinations for the given input.
 * 
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation: 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7. These are the only two combinations.
 * 
 * Example 2:
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * 
 * Example 3:
 * Input: candidates = [2], target = 1
 * Output: []
 * 
 * Constraints:
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * All elements of candidates are distinct.
 * 1 <= target <= 40
 */

 import java.util.ArrayList;
 import java.util.List;
 
 public class CombinationSum1 {
 
     // Function to find all unique combinations that sum up to the target
     public List<List<Integer>> combinationSum(int[] candidates, int target) {
         List<List<Integer>> result = new ArrayList<>();
         backtrack(candidates, target, 0, new ArrayList<>(), result);
         return result;
     }
 
     // Helper function to perform backtracking
     private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
         if (target == 0) {
             result.add(new ArrayList<>(current));
             return;
         }
         if (target < 0) return;
 
         for (int i = start; i < candidates.length; i++) {
             current.add(candidates[i]);
             backtrack(candidates, target - candidates[i], i, current, result);
             current.remove(current.size() - 1);
         }
     }
 
     // Main method to test the combinationSum method
     public static void main(String[] args) {
         CombinationSum1 obj = new CombinationSum1();
         int[] candidates1 = {2, 3, 6, 7};
         int target1 = 7;
         System.out.println(obj.combinationSum(candidates1, target1));
 
         int[] candidates2 = {2, 3, 5};
         int target2 = 8;
         System.out.println(obj.combinationSum(candidates2, target2));
 
         int[] candidates3 = {2};
         int target3 = 1;
         System.out.println(obj.combinationSum(candidates3, target3));
     }
 }
 
