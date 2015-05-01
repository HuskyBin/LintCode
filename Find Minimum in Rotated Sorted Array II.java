/*
Medium Find Minimum in Rotated Sorted Array II Show result 

42% Accepted
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.

Example
Given [4,4,5,6,7,0,1,2] return 0
*/
public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if (num == null) {
            return Integer.MIN_VALUE;
        }
        int start = 0;
        int end = num.length - 1;
        while (start < end) {
            if (num[start] < num[end]) {
                return num[start];
            }
            int middle = start + (end - start) / 2;
            if (middle > 0 && num[middle] < num[middle - 1]) {
                return num[middle];
            }
            if (num[middle] < num[start]) {
                end = middle - 1;
            }
            else if (num[middle] > num[start]){
                start = middle + 1;
            }
            else {
                start++;
            }
        }
        return num[start];
    }
}
