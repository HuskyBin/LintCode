/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

Example
Given [4, 5, 6, 7, 0, 1, 2] return 0

Note
You may assume no duplicate exists in the array.
*/
public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if (num == null) {
            //throws new Exception();
            return -1;
        }
        int start = 0;
        int end = num.length - 1;
        int min = Integer.MAX_VALUE;
        while (start < end - 1) {
            int middle = start + (end - start) / 2;
            if (num[middle] > num[start]) {
                if (min > num[start]) {
                    min = num[start];
                }
                start = middle;
            }
            else {
                end = middle;
            }
        }
        if (num[start] < num[end]) {
            if (min > num[start]) {
                min = num[start];
            }
            return min;
        }
        else {
            if (min > num[end]) {
                min = num[end];
            }
            return min;
        }
    }
}
