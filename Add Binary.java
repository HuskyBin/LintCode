/*
Given two binary strings, return their sum (also a binary string).

Have you met this question in a real interview? Yes
Example
a = 11

b = 1

Return 100
*/
public class Solution {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        // Write your code here
        if (a == null || b == null) {
            return (a == null) ? b : a;
        }
        StringBuilder sb = new StringBuilder();
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int carry = 0;
        while (aIndex >= 0 && bIndex >= 0) {
            int curADigit = a.charAt(aIndex) - '0';
            int curBDigit = b.charAt(bIndex) - '0';
            int sum = curADigit + curBDigit + carry;
            carry = sum / 2;
            sb.append(sum % 2);
            aIndex--;
            bIndex--;
        }
        String restStr = (aIndex >= 0) ? a : b;
        int index = (aIndex >= 0) ? aIndex: bIndex;
        
        while (index >= 0) {
            int curDigit = restStr.charAt(index) - '0';
            int sum = carry + curDigit;
            carry = sum / 2;
            sb.append(sum % 2);
            index--;
        }
        if (carry > 0) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
