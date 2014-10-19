/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)

The solution set must not contain duplicate quadruplets.

Example
For example, given array S = {1 0 -1 0 -2 2}, and target = 0. A solution set is:

(-1, 0, 0, 1)

(-2, -1, 1, 2)

(-2, 0, 0, 2)


*/
public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {     
        //write your code here
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        if (numbers == null || numbers.length < 4) {
            return resultList;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            int firstNum = numbers[i];
            findThreeSum(numbers, resultList, target - firstNum, firstNum, i + 1);
            while (i < numbers.length - 1 && numbers[i] == numbers[i + 1]) {
                i++;
            }
        }
        return resultList;
    }
    
    private void findThreeSum(int[] numbers,
                              ArrayList<ArrayList<Integer>> resultList,
                              int target,
                              int firstNum,
                              int index) {
        for (int i = index; i < numbers.length; i++) {
            int secondNum = numbers[i];
            findTwoSum(numbers, resultList, target - secondNum, firstNum, secondNum, i + 1);
            while (i < numbers.length - 1 && numbers[i] == numbers[i + 1]) {
                i++;
            }
        }                              
    }
    
    private void findTwoSum(int[] numbers,
                            ArrayList<ArrayList<Integer>> resultList,
                            int target,
                            int firstNum,
                            int secondNum,
                            int index) {
        int start = index;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                ArrayList<Integer> singleList = new ArrayList<>();
                singleList.add(firstNum);
                singleList.add(secondNum);
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
