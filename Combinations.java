/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example
For example,
If n = 4 and k = 2, a solution is:
[[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
*/
public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
		// write your code here
		List<List<Integer>> resultList = new ArrayList<>();
		if (n <= 0 || k <= 0 || k > n) {
		    return resultList;
		}
		List<Integer> singleList = new ArrayList<>();
		combineHelper(n, k, 1, 0, resultList, singleList);
		return resultList;
    }
    
    private void combineHelper(int n, int k, int index, int num, List<List<Integer>> resultList, List<Integer> singleList) {
        if (num == k) {
            resultList.add(new ArrayList<Integer>(singleList));
            return;
        }
        if (index == n + 1) {
            return;
        }
        for (int i = index; i <= n && (n - i + 1) >= (k - num); i++) {
            singleList.add(i);
            combineHelper(n, k, i + 1, num + 1, resultList, singleList);
            singleList.remove(singleList.size() - 1); 
        }
    }
}
