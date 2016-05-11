/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Have you met this question in a real interview? Yes
Example
["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/
public class Solution {
    /**
     * @param tokens The Reverse Polish Notation
     * @return the value
     */
    public int evalRPN(String[] tokens) {
        // Write your code here
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                int secondNumber = stack.pop();
                int firstNumber = stack.pop();
                int sum = 0;
                if (str.equals("+")) {
                    sum = firstNumber + secondNumber;
                }
                else if (str.equals("-")) {
                    sum = firstNumber - secondNumber;
                }
                else if (str.equals("*")) {
                    sum = firstNumber * secondNumber;
                }
                else {
                    sum = firstNumber / secondNumber;
                }
                stack.push(sum);
            }
            else {
                stack.push(Integer.valueOf(str));
            }
        }
        return stack.pop();
    }
}
