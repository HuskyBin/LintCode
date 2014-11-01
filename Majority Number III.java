/*
Given an array of integers and a number k, the majority number is the number that occurs more than 1/k of the size of the array. Find it.

Note
There is only one majority number in the array.

Example
For [3,1,2,3,2,3,3,4,4,4] and k = 3, return 3


*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return Integer.MIN_VALUE;
        }
        return findKMajority(nums, k);
    }
    
    
    private int findKMajority(List<Integer> nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            if (!map.containsKey(num)) {
                map.put(num, 1);
            }
            else {
                map.put(num, map.get(num) + 1);   
            }
            if (map.size() >= k) {
                removeKey(map, k);
            }
        }
        if (map.size() == 0) {
            return Integer.MIN_VALUE;
        }
        else {
            int result = 0;
            int max = 0;
            Set<Integer> keySet = map.keySet();
            for (int i : keySet) {
                int number = 0;
                for (int j : nums) {
                    if (i == j) {
                        number++;
                    }
                }
                if (number > max) {
                    max = number;
                    result = i;
                }
            }
            return result;
        }
    }
    
    private void removeKey(Map<Integer, Integer> map, int k) {
        Set<Integer> keySet = map.keySet();
        int num = k;
        List<Integer> removeList = new ArrayList<>();
        for (int key : keySet) {
            if (map.get(key) == 1) {
                removeList.add(key);
            }
            else {
                map.put(key, map.get(key) - 1);
            }
            num--;
            if (num == 0) {
                break;
            }
        }
        for (int key : removeList) {
            map.remove(key);
        }
    }
}

