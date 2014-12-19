/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.



Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].



The largest rectangle is shown in the shaded area, which has area = 10 unit.
*/
public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < h.length; i++) {
            if (stack.size() == 0 || h[i] >= h[stack.peek()]) {
                stack.push(i);
            }
            else {
                int curHeight = h[stack.peek()];
                stack.pop();
                max = Math.max(max, curHeight * (stack.isEmpty() ? i : (i - stack.peek() - 1)));
                i--;
            }
        }
        return max;
    }
}


// naive solution
public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        if (height == null || height.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            if (i < height.length -1 && height[i] <= height[i + 1]) {
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int j = i; j >= 0; j--) {
                min = Math.min(min, height[j]);
                max = Math.max(max, min * (i - j + 1));
            }
        }
        return max;
    }
}
