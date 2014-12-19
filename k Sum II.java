/*
Given n unique integers, number k (1<=k<=n)  and target. Find all possible k integers where their sum is target.

Example
Given [1,2,3,4], k=2, target=5, [1,4] and [2,3] are possible solutions.
*/
public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public ArrayList<ArrayList<Integer>> kSumII(int A[], int k, int target) {
        // write your code here
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        if (A == null || k < 0 || target < 0 || A.length == 0) {
            return resultList;
        }
        ArrayList<Integer> singleList = new ArrayList<>();
        kSumIICore(A, k, target, 0, 0, 0, resultList, singleList);
        return resultList;
    }
    
    private void kSumIICore(int[] A,
                            int k,
                            int target,
                            int number,
                            int sum,
                            int index,
                            List<ArrayList<Integer>> resultList,
                            ArrayList<Integer> singleList) {
        if (sum == target && number == k) {
            resultList.add(new ArrayList<Integer>(singleList));
            return ;
        }
        if (sum >= target || number >= k) {
            return;
        }
        for (int i = index; i < A.length; i++) {
            singleList.add(A[i]);
            kSumIICore(A, k, target, number + 1, sum + A[i], i + 1, resultList, singleList);
            singleList.remove(singleList.size() - 1);
        }
    }
}
