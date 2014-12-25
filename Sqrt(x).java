/*
Easy Sqrt(x) Show Result My Submissions

25% Accepted
Implement int sqrt(int x).

Compute and return the square root of x.

Example
sqrt(3) = 1

sqrt(4) = 2

sqrt(5) = 2

sqrt(10) = 3
Challenge
O(log(x))
*/
class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if (x <= 1) {
            return x;
        }
        long start = 1;
        long end = x / 2;
        long value = x;
        while (start <= end) {
            long middle = (end - start) / 2 + start;
            long square = middle * middle;
            if (square == value) {
                return (int)middle;
            }
            else if (square > value) {
                end = middle - 1;
            }
            else {
                start = middle + 1;
            }
        }
        return (int)end;
    }
}
