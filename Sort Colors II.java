/*
Easy Sort Colors II Show Result My Submissions

26% Accepted
Given an array of n objects with k different colors (numbered from 1 to k), sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.

Note
You are not suppose to use the library's sort function for this problem.

Example
GIven colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4]. 

Challenge
A rather straight forward solution is a two-pass algorithm using counting sort. That will cost O(k) extra memory.

Can you do it without using extra memory?


*/


// quick sort
class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if (colors == null || colors.length == 0) {
            return;
        }
        quickSort(colors, 0, colors.length - 1);
    }
    
    private void quickSort(int[] colors, int start, int end) {
        if (start > end) {
            return;
        }
        int index = partition(colors, start, end);
        quickSort(colors, start, index - 1);
        quickSort(colors, index + 1, end);
    }
    
    private int partition(int[] colors, int start, int end) {
        int small = start - 1;
        int pivot = new Random().nextInt(end - start + 1) + start;
        swap(colors, pivot, end);
        for (int i = start; i < end; i++) {
            if (colors[i] <= colors[end]) {
                small++;
                swap(colors, small, i);
            }
        }
        small++;
        swap(colors, small, end);
        return small;
    }
    
    private void swap(int[] colors, int i, int j) {
        int temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }
}
