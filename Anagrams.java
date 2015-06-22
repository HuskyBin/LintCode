/*
Given an array of strings, return all groups of strings that are anagrams.

Have you met this question in a real interview? Yes
Example
Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].

Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].

Note
All inputs will be in lower-case
*/
public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> resultList = new ArrayList();
        if (strs == null || strs.length == 0) {
            return resultList;
        }
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (anagramMap.containsKey(key)) {
                List<String> curList = anagramMap.get(key);
                curList.add(str);
                anagramMap.put(key, curList);
            }
            else {
                List<String> newList = new ArrayList();
                newList.add(str);
                anagramMap.put(key, newList);
            }
        }
        for (String key : anagramMap.keySet()) {
            List<String> curList = anagramMap.get(key);
            if (curList.size() > 1) {
                resultList.addAll(curList);
            }
        }
        return resultList;
    }
}
