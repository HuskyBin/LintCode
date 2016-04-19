/*
Given an absolute path for a file (Unix-style), simplify it.

Have you met this question in a real interview? Yes
Example
"/home/", => "/home"

"/a/./b/../../c/", => "/c"


*/
public class Solution {
    /**
     * @param path the original path
     * @return the simplified path
     */
    public String simplifyPath(String path) {
        // Write your code here
        if (path == null) {
            return path;
        }
        Stack<String> stack = new Stack<>();
        int index = 0;
        while (index < path.length()) {
            int nextCursor = index;
            while (nextCursor < path.length() && path.charAt(nextCursor) != '/') {
                nextCursor++;
            }
            String subString = path.substring(index, nextCursor);
            if (subString.length() > 0) {
                if (subString.equals(".")) {
                    index = nextCursor + 1;
                    continue;
                }
                else if (subString.equals("..")) {
                    if (stack.size() > 0) {
                        stack.pop();
                    }
                }
                else {
                    stack.push(subString);
                }
            }
            index = nextCursor + 1;
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.insert(0, stack.pop());
            sb.insert(0, '/');
        }
        if (sb.length() == 0) {
            sb.append('/');
        }
        return sb.toString();
    }
}
