/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)

The solution set must not contain duplicate triplets.

Example
For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:

(-1, 0, 1)

(-1, -1, 2)


*/

public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        if (numbers == null || numbers.length < 3) {
            return resultList;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            int firstNum = numbers[i];
            findTwoSum(numbers, resultList, -firstNum, firstNum, i + 1);
            while (i < numbers.length - 1 && numbers[i] == numbers[i + 1]) {
                i++;
            }
        }
        return resultList;
    }
    
    private void findTwoSum(int[] numbers, 
                            ArrayList<ArrayList<Integer>> resultList,
                            int target,
                            int firstNum,
                            int index) {
        int start = index;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                ArrayList<Integer> singleList = new ArrayList<>();
                singleList.add(firstNum);
                singleList.add(numbers[start]);
                singleList.add(numbers[end]);
                resultList.add(singleList);
                start++;
                while (start < numbers.length && numbers[start] == numbers[start - 1]) {
                    start++;
                }
                end--;
                while (end >= 0 && numbers[end] == numbers[end + 1]) {
                    end--;
                }
            }
            else if (numbers[start] + numbers[end] > target) {
                end--;
            }
            else {
                start++;
            }
        }
    }
}
