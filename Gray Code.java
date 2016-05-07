/*
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, find the sequence of gray code. A gray code sequence must begin with 0 and with cover all 2n integers.

 Notice

For a given n, a gray code sequence is not uniquely defined.

[0,2,3,1] is also a valid gray code sequence according to the above definition.

Have you met this question in a real interview? Yes
Example
Given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
*/
public class Solution {
    /**
     * @param n a number
     * @return Gray code
     */
    public ArrayList<Integer> grayCode(int n) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (n == 0) {
            result.add(0);
            return result;
        }
        long number = 0;
        result.add(0);
        while (number <= Integer.MAX_VALUE && (number < (1L << n))) {
            number ^= 1;
            result.add((int)number);
            number ^= (number - (number & (number - 1))) << 1;
            if (number <= Integer.MAX_VALUE && (number < (1L << n))) {
                result.add((int)number);
            }
            else {
                break;
            }
        }
        return result;
    }
}
