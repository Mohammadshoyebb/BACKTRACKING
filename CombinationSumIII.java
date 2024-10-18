/*
 216. Combination Sum III
Solved
Medium
Topics
Companies
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

 

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 

Constraints:

2 <= k <= 9
1 <= n <= 60
 */

 import java.util.ArrayList;
 import java.util.List;
 
 public class CombinationSumIII {
 
     // Approach 1: Recursive Backtracking
     // This approach explores all possible combinations by making two recursive calls:
     // 1. Include the current number and reduce k and n accordingly.
     // 2. Skip the current number and move to the next.
     private void solveApproach1(int i, int k, int n, List<Integer> curr, List<List<Integer>> ans) {
         // Base condition: If k and n are both zero, a valid combination is found.
         if (n == 0 && k == 0) {
             ans.add(new ArrayList<>(curr));
             return;
         }
         // If we've exceeded the number range or if n or k become negative, we backtrack.
         if (i > 9 || n < 0 || k < 0) {
             return;
         }
         // Create a new list including the current number i.
         List<Integer> temp = new ArrayList<>(curr);
         temp.add(i);
 
         // Recur by including the current number.
         solveApproach1(i + 1, k - 1, n - i, temp, ans);
 
         // Recur by excluding the current number.
         solveApproach1(i + 1, k, n, curr, ans);
     }
 
     // Approach 2: Optimized Recursive Backtracking with For Loop
     // This approach iterates over possible elements and reduces k and target accordingly.
     // It avoids unnecessary recursion by using a for loop to select the next element.
     private void solveApproach2(int element, int k, int target, List<Integer> curr, List<List<Integer>> ans) {
         // Base condition: If the current list size equals k, check if the target is zero.
         if (curr.size() == k) {
             if (target == 0) {
                 ans.add(new ArrayList<>(curr));
             }
             return;
         }
 
         // Iterate through possible elements from 'element' to 9.
         for (int i = element; i <= 9; i++) {
             if (i <= target) { // Proceed only if the current element can be part of the solution.
                 curr.add(i); // Add the current element.
                 solveApproach2(i + 1, k, target - i, curr, ans); // Recur for the next element.
                 curr.remove(curr.size() - 1); // Backtrack by removing the last added element.
             }
         }
     }
 
     public List<List<Integer>> combinationSum3(int k, int n) {
         List<List<Integer>> ans = new ArrayList<>();
         List<Integer> curr = new ArrayList<>();
 
         // Using Approach 1
         solveApproach1(1, k, n, curr, ans);
 
         // Optionally, if you want to use Approach 2 instead, uncomment the following lines:
         // ans.clear(); // Clear previous results if running both approaches separately.
         // solveApproach2(1, k, n, curr, ans);
 
         return ans;
     }
 
     public static void main(String[] args) {
         CombinationSumIII combinationSumIII = new CombinationSumIII();
         
         // Test with k = 3, n = 7
         System.out.println("Approach 1 and Approach 2 result for k = 3, n = 7: " + combinationSumIII.combinationSum3(3, 7));
         
         // Test with k = 3, n = 9
         System.out.println("Approach 1 and Approach 2 result for k = 3, n = 9: " + combinationSumIII.combinationSum3(3, 9));
         
         // Test with k = 4, n = 1
         System.out.println("Approach 1 and Approach 2 result for k = 4, n = 1: " + combinationSumIII.combinationSum3(4, 1));
     }
 }