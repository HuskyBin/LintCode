/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example
given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/
public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> resultList = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return resultList;
        }
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for (int len = 2; len <= s.length(); len++) {
            for (int start = 0; start + len - 1 < s.length(); start++) {
                int end = start + len - 1;
                if (len == 2) {
                    if (s.charAt(start) == s.charAt(end)) {
                        isPalindrome[start][end] = true;
                    }
                }
                else {
                    if (s.charAt(start) == s.charAt(end) && isPalindrome[start + 1][end - 1] == true) {
                        isPalindrome[start][end] = true;
                    }
                }
            }
        }
        
        List<String> singleList = new ArrayList<>();
        partitionList(s, resultList, singleList, isPalindrome, 0);
        return resultList;
    }
    
    private void partitionList(String s, List<List<String>> resultList, List<String> singleList, boolean[][] isPalindrome, int index) {
        if (index == s.length()) {
            resultList.add(new ArrayList<String>(singleList));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome[index][i]) {
                singleList.add(s.substring(index, i + 1));
                partitionList(s, resultList,singleList, isPalindrome, i + 1);
                singleList.remove(singleList.size() - 1);
            }
        }
    }
}
