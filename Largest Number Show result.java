/*
Given a list of non negative integers, arrange them such that they form the largest number.

Have you met this question in a real interview? Yes
Example
Given [1, 20, 23, 4, 8], the largest formed number is 8423201.

Note
The result may be very large, so you need to return a string instead of an integer.

Tags Expand  
*/
import java.util.*;
public class Solution {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    public String largestNumber(int[] num) {
        // write your code here
        if (num == null) {
            return null;
        }
        List<String> list = new ArrayList<>();
        for (Integer a : num) {
            list.add(String.valueOf(a));
        }
        Collections.sort(list, new Comparator<String>() {
            public int compare(String a, String b) {
                return (a + b).compareTo(b + a);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        boolean isZero = true;
        for (int i = num.length - 1; i >= 0; i--) {
            if (list.get(i).equals("0") && !isZero) {
                sb.append(list.get(i));
            }
            else if (!list.get(i).equals("0")) {
                sb.append(list.get(i));
                isZero = false;
            }
        }
        if (sb.length() == 0) sb.append("0");
        return sb.toString();
    }
}
