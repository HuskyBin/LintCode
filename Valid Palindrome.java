public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    /*
    Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 Notice

Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

Have you met this question in a real interview? Yes
Example
"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.
    */
    public boolean isPalindrome(String s) {
        // Write your code here
        if (s == null) {
            return false;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char startChar = Character.toLowerCase(s.charAt(start));
            if (!((startChar >= 'a' && startChar <= 'z') || (startChar >= '0' && startChar <= '9'))) {
                start++;
                continue;
            }
            char endChar = Character.toLowerCase(s.charAt(end));
            if (!((endChar >= 'a' && endChar <= 'z') || (endChar >= '0' && endChar <= '9'))) {
                end--;
                continue;
            }
            if (startChar != endChar) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
