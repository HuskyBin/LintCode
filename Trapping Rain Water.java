/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

Trapping Rain Water

Have you met this question in a real interview? Yes
Example
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/

//Better Solution
public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        if (heights == null || heights.length <= 2) {
            return 0;
        }
        int startIndex = 0;
        int endIndex = heights.length - 1;
        int sum = 0;
        while (startIndex < endIndex) {
            if (heights[startIndex]< heights[endIndex]) {
                int smaller = heights[startIndex];
                while (startIndex < endIndex && heights[startIndex] <= smaller) {
                    sum += smaller - heights[startIndex];
                    startIndex++;
                }
            }
            else {
                int smaller = heights[endIndex];
                while (startIndex < endIndex && heights[endIndex] <= smaller) {
                    sum += smaller - heights[endIndex];
                    endIndex--;
                }
            }
        }
        return sum;
    }
}


// Second Solution
public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        if (heights == null || heights.length <= 2) {
            return 0;
        }
        int startIndex = 0;
        int endIndex = 1;
        int sum = 0;
        while (endIndex < heights.length) {
            while (endIndex < heights.length && heights[endIndex] <= heights[startIndex]) {
                endIndex++;
            }
            if (endIndex < heights.length) {
                int tempIndex = startIndex + 1;
                int tempSum = 0;
                while (tempIndex < endIndex) {
                    tempSum += heights[tempIndex];
                    tempIndex++;
                }
                sum += (heights[startIndex]) * (endIndex - startIndex - 1) - tempSum;
            }
            startIndex = endIndex;
            endIndex++;
        }
        startIndex = heights.length - 1;
        endIndex = heights.length - 2;
        while (endIndex >= 0) {
            while (endIndex >= 0 && heights[endIndex] < heights[startIndex]) {
                endIndex--;
            }
            if (endIndex >= 0) {
                int tempIndex = startIndex - 1;
                int tempSum = 0;
                while (tempIndex > endIndex) {
                    tempSum += heights[tempIndex];
                    tempIndex--;
                }
                sum += (heights[startIndex]) * (startIndex - endIndex - 1) - tempSum;
            }
            
            startIndex = endIndex;
            endIndex--;
            
        }
        return sum;
    }
}
