/*
Medium Letter Combinations of a Phone Number Show result 

23% Accepted
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Cellphone

Have you met this question in a real interview? Yes
Example
Given "23"

Return ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]

Note
*/
public class Solution {
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
    public ArrayList<String> letterCombinations(String digits) {
        // Write your code here
        ArrayList<String> resultList = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return resultList;
        }
        
        Map<Character, String> map = new HashMap<>();
        initialMap(map);
        StringBuilder sb = new StringBuilder();
        letterCombinationCore(digits, 0, map, resultList, sb);
        return resultList;
    }
    
    private void initialMap(Map<Character, String> map) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    
    private void letterCombinationCore(String digits, int index, Map<Character, String> map, ArrayList<String> resultList, StringBuilder sb) {
        if (index == digits.length()) {
            resultList.add(sb.toString());
            return;
        }
        
        String candidatesLetter = map.get(digits.charAt(index));
        for (int i = 0; i < candidatesLetter.length(); i++) {
            sb.append(candidatesLetter.charAt(i));
            letterCombinationCore(digits, index + 1, map, resultList, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}
