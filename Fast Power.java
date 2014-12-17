/*
Calculate the an % b where a, b and n are all 32bit integers.

Example
For 231 % 3 = 2

For 1001000 % 1000 = 0

Challenge
O(logn)
*/
class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here
        boolean isNegative = false;
        if (b < 0) {
            b = -b;
            isNegative = true;
        }
        long result = 0;
        
        result = fastPowerHelper((long)a, (long)n, (long)b);
        if (isNegative == true) {
            result = 1 / result;
        }
        return (int)(result % b);
    }
    
    private long fastPowerHelper(long a, long b, long n) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a % n;
        }
        long result = fastPowerHelper(a, b / 2, n) % n;
        if (b % 2 == 1) {
            return (((a % n * result) % n) * result) % n ;
        }
        return (result * result) % n;
    }
};

// for-loop method
class Solution {
public:
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    
    int mul(long long x,long long y, int b) {
        return x * y % b;
    }
    int fastPower(int a, int b, int n) {
        // write your code here
        int r = 1 % b;
        for (; n; n >>= 1) {
            if (n & 1) {
                r = mul(r, a, b);
            }
            a = mul(a, a, b);
        }
        return r;
    }
};
