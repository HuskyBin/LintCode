/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

Have you met this question in a real interview? Yes
Example
Given encoded message 12, it could be decoded as AB (1 2) or L (12).
The number of ways decoding 12 is 2.
*/
public class Solution {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // Write your code hereo
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        return decodingCore(s, 0, map);
    }
    
    private int decodingCore(String s, int index, Map<Integer, Integer> map) {
        if (index == s.length()) {
            return 1;
        }
        if (map.containsKey(index)) {
            return map.get(index);
        }
        if (s.charAt(index) == '0') {
            map.put(index, 0);
            return 0;
        }
        if (index == s.length() - 1) {
            map.put(index, 1);
            return 1;
        }
        if (s.charAt(index) > '2' || ((s.charAt(index) == '2') && (s.charAt(index + 1) >= '7'))) {
            int result =  decodingCore(s, index + 1, map);
            map.put(index, result);
            return result;
        }
        else if (s.charAt(index + 1) == '0') {
            int result =  decodingCore(s, index + 2, map);
            map.put(index, result);
            return result;
        }
        else {
            
            int result = decodingCore(s, index + 1, map) + decodingCore(s, index + 2, map);
            map.put(index, result);
            return result;
        }
    }
}
