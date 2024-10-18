/**
 * 40. Combination Sum II
 * 
 * Given a collection of candidate numbers (candidates) and a target number (target), 
 * find all unique combinations in candidates where the candidate numbers sum to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note: The solution set must not contain duplicate combinations.
 * 
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output: 
 * [
 *   [1,1,6],
 *   [1,2,5],
 *   [1,7],
 *   [2,6]
 * ]
 * 
 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output: 
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * 
 * Constraints:
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */

 import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.List;
 
 public class CombinationSumII {
 
     // Function to find all unique combinations that sum up to the target
     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         List<List<Integer>> result = new ArrayList<>();
         Arrays.sort(candidates);  // Sort candidates to handle duplicates
         backtrack(candidates, target, 0, new ArrayList<>(), result);
         return result;
     }
 
     // Helper function to perform backtracking
     private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
         if (target == 0) {
             result.add(new ArrayList<>(current));
             return;
         }
 
         for (int i = start; i < candidates.length; i++) {
             // Skip duplicates
             if (i > start && candidates[i] == candidates[i - 1]) continue;
 
             if (candidates[i] > target) break;
 
             current.add(candidates[i]);
             backtrack(candidates, target - candidates[i], i + 1, current, result);
             current.remove(current.size() - 1);
         }
     }
 
     // Main method to test the combinationSum2 method
     public static void main(String[] args) {
         CombinationSumII obj = new CombinationSumII();
 
         int[] candidates1 = {10, 1, 2, 7, 6, 1, 5};
         int target1 = 8;
         System.out.println(obj.combinationSum2(candidates1, target1));
 
         int[] candidates2 = {2, 5, 2, 1, 2};
         int target2 = 5;
         System.out.println(obj.combinationSum2(candidates2, target2));
     }
 }
 