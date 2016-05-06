/*
Print numbers from 1 to the largest number with N digits by recursion.

 Notice

It's pretty easy to do recursion like:

recursion(i) {
    if i > largest number:
        return
    results.add(i)
    recursion(i + 1)
}
however this cost a lot of recursion memory as the recursion depth maybe very large. Can you do it in another way to recursive with at most N depth?

Have you met this question in a real interview? Yes
Example
Given N = 1, return [1,2,3,4,5,6,7,8,9].

Given N = 2, return [1,2,3,4,5,6,7,8,9,10,11,12,...,99].
*/
public class Solution {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        List<Integer> lastLevel = new ArrayList<>();
        if (n < 1) {
            return result;
        }
        recursion(1, n, result, lastLevel);
        return result;
    }
    
    private void recursion(int level, int n, List<Integer> result, List<Integer> lastLevel) {
        if (level == n + 1) {
            return;
        }
        List<Integer> curLevel = new ArrayList<>();
        if (level == 1) {
            for (int i = 1; i < 10; i++) {
                curLevel.add(i);
            }
            result.addAll(curLevel);
            recursion(level + 1, n, result, curLevel);
            return;
        }
        
        for (int number : lastLevel) {
            for (int i = 0; i < 10; i++) {
                curLevel.add(number * 10 + i);    
            }
        }
        result.addAll(curLevel);
        recursion(level + 1, n, result, curLevel);
        
    }
}
