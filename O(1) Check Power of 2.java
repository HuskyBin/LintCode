/*
Using O(1) time to check whether an integer n is a power of 2.
Example
For n=4, return true

For n=5, return false

Challenge
O(1) time


*/
class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        // write your code here
        if (n <= 0) {
            return false;
        }
        int oneDigit = 0;
        while (n > 0) {
            n = n & (n - 1);
            oneDigit++;
            if (oneDigit == 2) {
                return false;
            }
        }
        return true;
    }
};
