/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

Have you met this question in a real interview? Yes
Example
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/
public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return true;
        }
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curChar == '(' || curChar == '{' || curChar == '[') {
                stack.push(curChar);
            }
            else if (curChar == ')' || curChar == '}' || curChar == ']') {
                if (stack.size() == 0) {
                    return false;
                }
                char topChar = stack.pop();
                if (curChar == ')' && topChar != '(') {
                    return false;
                }
                else if (curChar == '}' && topChar != '{') {
                    return false;
                }
                else if (curChar == ']' && topChar != '[') {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
