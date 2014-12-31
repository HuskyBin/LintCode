/*
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
*/
class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here
        if (n <= 0) {
            return 0;
        }
        long result = 0;
        for (long i = 5; n / i > 0; i = i * 5) {
            result += n / i;
        }
        return result;
    }
};

