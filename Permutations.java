/*
Fair Permutations Show Result My Submissions

13% Accepted
Given a list of numbers, return all possible permutations.

Example
For nums [1,2,3], the permutaions are: 

[

    [1,2,3],

    [1,3,2],

    [2,1,3],

    [2,3,1],

    [3,1,2],

    [3,2,1]

]
*/
class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        if (nums == null || nums.size() == 0) {
            return resultList;
        }
        Collections.sort(nums);
        List<Integer> singleList = new ArrayList<>();
        boolean[] visited = new boolean[nums.size()];
        permuteCore(nums, resultList, singleList, visited);
        return resultList;
    }
    
    private void permuteCore(ArrayList<Integer> nums,
                             ArrayList<ArrayList<Integer>> resultList,
                             List<Integer> singleList,
                             boolean[] visited) {
        if (singleList.size() == nums.size()) {
            resultList.add(new ArrayList<Integer>(singleList));
            return;
        }          
        for (int i = 0; i < nums.size(); i++) {
            if (visited[i] == false) {
                visited[i] = true;
                singleList.add(nums.get(i));
                permuteCore(nums, resultList, singleList, visited);
                visited[i] = false;
                singleList.remove(singleList.size() - 1);
            }
        }
    } 
}

