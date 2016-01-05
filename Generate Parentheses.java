/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Have you met this question in a real interview? Yes
Example
Given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/
public class Solution {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public ArrayList<String> generateParenthesis(int n) {
        // Write your code here
        ArrayList<String> resultList = new ArrayList<>();
        if (n <= 0) {
            return resultList;
        }
        StringBuilder sb = new StringBuilder();
        generateCore(n, n, sb, resultList);
        return resultList;
    }
    
    private void generateCore(int left, int right, StringBuilder sb, List<String> resultList) {
        if (left == 0 && right == 0) {
            resultList.add(sb.toString());
            return;
        }
        if (left == 0 && right > 0) {
            sb.append(')');
            generateCore(left, right - 1, sb, resultList);
            sb.setLength(sb.length() - 1);
            return;
        }
        
        if (left < right) {
            if (left > 0) {
                sb.append('(');
                generateCore(left - 1, right, sb, resultList);
                sb.setLength(sb.length() - 1);    
            }
            sb.append(')');
            generateCore(left, right - 1, sb, resultList);
            sb.setLength(sb.length() - 1);
        }
        else if (left == right) {
            sb.append('(');
            generateCore(left - 1, right, sb, resultList);
            sb.setLength(sb.length() - 1);
        }
    }
}
