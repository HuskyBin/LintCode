/*
Easy Flip Bits Show result 

29% Accepted
Determine the number of bits required to flip if you want to convert integer n to integer m.

Have you met this question in a real interview? Yes
Example
Given n = 31 (11111), m = 14 (01110), return 2.

Note
*/
class Solution {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        // write your code here
        int temp = a ^ b;
        int num = 0;
        while (temp != 0) {
            temp &= temp - 1;
            num++;
        }
        return num;
    }
};

