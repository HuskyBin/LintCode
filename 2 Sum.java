/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

Note
You may assume that each input would have exactly one solution

Example
numbers=[2, 7, 11, 15], target=9

return [1, 2]


*/
public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] result = new int[2];
        if (numbers == null || numbers.length == 0) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (!map.containsKey(num)) {
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                map.put(num, newList);
            }
            else {
                List<Integer> list = map.get(num);
                list.add(i);
                map.put(num, list);
            }
        }
        Arrays.sort(numbers);
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                List<Integer> startList = map.get(numbers[start]);
                List<Integer> endList = map.get(numbers[end]);
                int firstNum = startList.get(0);
                int secondNum = endList.get(0);
                result[0] = Math.min(firstNum, secondNum) + 1;
                result[1] = Math.max(firstNum, secondNum) + 1;
                return result;
            }
            else if (numbers[start] + numbers[end] > target) {
                end--;
            }
            else {
                start++;
            }
        }
        result[0] = -1;
        result[1] = -1;
        return result;
    }
}
