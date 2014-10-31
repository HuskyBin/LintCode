/*
Count the number of k's between 0 and n. k can be 0 - 9.
*/

class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        if (k < 0 || n < 0) {
            return 0;
        }
        int length = String.valueOf(n).length();
        int result = 0;
        for (int i = 0; i < length; i++) {
            result += countKByDigit(n, k, i);
        }
        return result;
    }
    
    private int countKByDigit(int num, int k, int digit) {
        int numOfPow = (int)Math.pow(10.0, digit);
        int nextNumOfPow = (int)Math.pow(10.0, digit + 1);
        int right = num % numOfPow;
        int digitNum = (num / numOfPow) % 10;
        
        int downNumber = num - (num % nextNumOfPow);
        int upNumber = downNumber + nextNumOfPow;
        if (digitNum < k) {
            return downNumber / 10;
        }
        else if (digitNum == k) {
            return downNumber / 10 + right + 1;
        }
        else {
            return upNumber / 10;
        }
    }
};

1
