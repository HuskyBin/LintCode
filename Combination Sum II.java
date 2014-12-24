/*
Fair Combination Sum II Show Result My Submissions

26% Accepted
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Example
For example, given candidate set 10,1,6,7,2,1,5 and target 8,

A solution set is: 

[1,7]

[1,2,5]

[2,6]

[1,1,6]
*/
public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> resultList = new ArrayList<>();
        if (num == null || num.length == 0) {
            return resultList;
        }
        Arrays.sort(num);
        List<Integer> singleList = new ArrayList<>();
        combinationSumHelper(num, target, 0, 0, resultList, singleList);
        return resultList;
    }
    
    private void combinationSumHelper(int[] num, int target, int index, int sum, List<List<Integer>> resultList, List<Integer> singleList) {
        if (sum == target) {
            resultList.add(new ArrayList<Integer>(singleList));
            return;
        }
        if (index == num.length) {
            return;
        }
        for (int i = index; i < num.length; i++) {
            if (target - sum < num[i]) {
                return;
            }
            singleList.add(num[i]);
            combinationSumHelper(num, target, i + 1, sum + num[i], resultList, singleList);
            singleList.remove(singleList.size() - 1);
            while (i < num.length - 1 && num[i] == num[i + 1]) {
                i++;
            }
        }
    }
}
