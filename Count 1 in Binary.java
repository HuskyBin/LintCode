/*
Count how many 1 in binary representation of a 32-bit integer.

Have you met this question in a real interview? Yes
Example
Given 32, return 1

Given 5, return 2

Given 1023, return 9
*/
public class Solution {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    public int countOnes(int num) {
        // write your code here
        int sum = 0;
        while (num != 0) {
            num &= num - 1;
            sum++;
        }
        return sum;
    }
};
