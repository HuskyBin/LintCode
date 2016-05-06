/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Notice

You may not slant the container.

Have you met this question in a real interview? Yes
Example
Given [1,3,2], the max area of the container is 2.
*/
public class Solution {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        if (heights == null || heights.length < 2) {
            return 0;
        }
        int start = 0;
        int end = heights.length - 1;
        int sum = 0;
        while (start < end) {
            sum = Math.max(sum, Math.min(heights[start], heights[end]) * (end - start));
            if (heights[start] < heights[end]) {
                start++;
            }
            else {
                end--;
            }
        }
        return sum;
    }
}
