/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.



For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 

Note
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Example
given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/
public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> resultList = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return resultList;
        }
        Arrays.sort(candidates);
        List<Integer> singleList = new ArrayList<>();
        combinationSumHelper(candidates, target, 0, 0, singleList, resultList);
        return resultList;
    }
    
    private void combinationSumHelper(int[] candidates, 
                                      int target, 
                                      int sum,
                                      int index,
                                      List<Integer> singleList,
                                      List<List<Integer>> resultList) {
                                          
        if (sum > target) {
            return;
        }          
        if (sum == target) {
            resultList.add(new ArrayList<Integer>(singleList));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] <= target) {
                singleList.add(candidates[i]);
                sum = sum + candidates[i];
                combinationSumHelper(candidates, target, sum, i, singleList, resultList);
                sum -= candidates[i];
                singleList.remove(singleList.size() - 1);
            }
        }
    }
}
