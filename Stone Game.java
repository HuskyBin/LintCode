/*
There is a stone game.At the beginning of the game the player picks n piles of stones in a line.

The goal is to merge the stones in one pile observing the following rules:

At each step of the game,the player can merge two adjacent piles to a new pile.
The score is the number of stones in the new pile.
You are to determine the minimum of the total score.

Have you met this question in a real interview? Yes
Example
For [4, 1, 1, 4], in the best solution, the total score is 18:

1. Merge second and third piles => [4, 2, 4], score +2
2. Merge the first two piles => [6, 4]，score +6
3. Merge the last two piles => [10], score +10
Other two examples:
[1, 1, 1, 1] return 8
[4, 4, 5, 9] return 43
*/
public class Solution {
    /**
     * @param A an integer array
     * @return an integer
     */
    public int stoneGame(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int[][] dp = new int[A.length][A.length];
        int[] sum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            dp[i][i] = 0;
            sum[i + 1] = sum[i] + A[i];
        }
        for (int len = 2; len <= A.length; len++) {
            for (int i = 0; i + len - 1 < A.length; i++) {
                int j = i + len - 1;
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    min = Math.min(min, dp[i][k] + dp[k + 1][j] + sum[j + 1] - sum[i]);
                }
                dp[i][j] = min;
            }
        }
        return dp[0][A.length - 1];
    }
}
