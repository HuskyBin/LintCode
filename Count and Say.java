/*
The count-and-say sequence is the sequence of integers beginning as follows:

1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.

11 is read off as "two 1s" or 21.

21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth sequence.

 Notice

The sequence of integers will be represented as a string.

Have you met this question in a real interview? Yes
Example
Given n = 5, return "111221".
*/
public class Solution {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        if (n <= 0) {
            return sb.toString();
        }
        String number = "1";
        while(n > 1) {
            int start = 0;
            int end = 0;
            while (end < number.length()) {
                while (end < number.length() && number.charAt(end) == number.charAt(start)) {
                    end++;
                }
                sb.append(end - start);
                sb.append(number.charAt(start));
                start = end;
            }
            number = sb.toString();
            sb.setLength(0);
            n--;
        }
        return number;
    }
}
