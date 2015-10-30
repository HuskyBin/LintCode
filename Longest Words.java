/*
Easy Longest Words Show result 

36% Accepted
Given a dictionary, find all of the longest words in the dictionary.

Have you met this question in a real interview? Yes
Example
Given

{
  "dog",
  "google",
  "facebook",
  "internationalization",
  "blabla"
}
the longest words are(is) ["internationalization"].

Given

{
  "like",
  "love",
  "hate",
  "yes"
}
the longest words are ["like", "love", "hate"].
*/
class Solution {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        // write your code here
        ArrayList<String> result = new ArrayList<>();
        if (dictionary == null) {
            return result;
        }
        
         result.add(dictionary[0]);
        for(int i = 1; i < dictionary.length; i++) {
            if (dictionary[i].length() > result.get(0).length()) {
                result = new ArrayList<>();
                result.add(dictionary[i]);
            }
            else if (dictionary[i].length() == result.get(0).length()) {
                result.add(dictionary[i]);
            }
        }
        return result;
    }
};
