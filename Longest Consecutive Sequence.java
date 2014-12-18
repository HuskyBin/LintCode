/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Example
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Clarification
Your algorithm should run in O(n) complexity.


*/
public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
        if (num == null) {
            return 0;
        }
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i : num) {
            if (!map.containsKey(i)) {
                map.put(i, true);
            }
        }
        int max = 0;
        for (int i : num) {
            if (!map.containsKey(i)) {
                continue;
            }
            int j = i + 1;
            int result = 0;
            while (map.containsKey(j)) {
                result++;
                map.remove(j);
                j++;
            }
            j = i - 1;
            while (map.containsKey(j)) {
                result++;
                map.remove(j);
                j--;
            }
            result++;
            map.remove(i);
            max = Math.max(max, result);
        }
        return max;
    }
}
