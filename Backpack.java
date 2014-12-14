/**
Given n items with size A[i], an integer m denotes the size of a backpack. How full you can fill this backpack? 

Note
You can not divide any item into small pieces.

Example
If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select 2, 3 and 5, so that the max size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.

You function should return the max size we can fill in the given backpack.


*/
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     */
    public int backPack(int m, ArrayList<Integer> A) {
        // write your code here
        if (m <= 0 || A == null || A.size() == 0) {
            return 0;
        }
        int[] dp = new int[m + 1];
        for (int i = 0; i <= A.size(); i++) {
            for (int j = m; j >= 0; j--) {
                if (i > 0 && j >= A.get(i - 1)) {
                    dp[j] = Math.max(dp[j], dp[j - A.get(i - 1)] + A.get(i - 1));
                }
            }
        }
        return dp[m];
    }
}

//d(i, j)=max{ d(i-1, j), d(i-1,j-V[i-1]) + W[i-1] }

// 2-D array
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     */
    public int backPack(int m, int[] A) {
        // write your code here
        if (m <= 0 || A == null || A.length == 0) {
            return 0;
        }
        int[][] dp = new int[A.length + 1][m + 1];
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                if (i > 0) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= A[i - 1]) {
                        dp[i][j] = Math.max(dp[i][j], (dp[i - 1][j - A[i - 1]] + A[i - 1]));
                    }
                }
            }
        }
        return dp[A.length][m];
    }
}
