/*
Medium Unique Binary Search Trees Show result 

33% Accepted
Given n, how many structurally unique BSTs (binary search trees) that store values 1...n?

Example
Given n = 3, there are a total of 5 unique BST's.

1           3    3       2      1
 \         /    /       / \      \
  3      2     1       1   3      2
 /      /       \                  \
2     1          2                  3
*/
public class Solution {
    /**
     * @paramn n: An integer
     * @return: An integer
     */
    public int numTrees(int n) {
        // write your code here
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        int[] bstNums = new int[n + 1];
        bstNums[1] = 1;
        bstNums[0] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += bstNums[j] * bstNums[i - 1 - j];
            }
            bstNums[i] = sum;
        }
        return bstNums[n];
    }
}
