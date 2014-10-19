/*
For given numbers a and b in function aplusb, return the sum of them.

Note
You don't need to parse the input and output. Just calculate and return.

Example
If a=1 and b=2 return 3

Challenge Expand 
Can you do it with out + operation?
*/
class Solution {
    /*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // Click submit, you will get Accepted!
        if (b == 0) {
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return aplusb(sum, carry);
    }
};
