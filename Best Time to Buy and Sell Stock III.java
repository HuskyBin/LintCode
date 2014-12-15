/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/
class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] leftToRight = new int[prices.length];
        int[] rightToLeft = new int[prices.length];
        
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            else {
                max = Math.max(max, prices[i] - min);
            }
            leftToRight[i] = max;
        }
        max = 0;
        int curMax = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] > curMax) {
                curMax = prices[i];
            }
            else {
                max = Math.max(max, curMax - prices[i]);
                rightToLeft[i] = max;
            }
        }
        max = 0;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(leftToRight[i] + rightToLeft[i], max);
        }
        return max;
        
    }
};
