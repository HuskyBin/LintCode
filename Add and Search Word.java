public class WordDictionary {
    
    class TrieNode {
        public Map<Character, TrieNode> children = new HashMap<>();
        public boolean hasWord = false;
    }
    
    private TrieNode root = new TrieNode();

    /*
    Design a data structure that supports the following two operations: addWord(word) and search(word)

search(word) can search a literal word or a regular expression string containing only letters a-z or ..

A . means it can represent any one letter.

Have you met this question in a real interview? Yes
Example
addWord("bad")
addWord("dad")
addWord("mad")
search("pad")  // return false
search("bad")  // return true
search(".ad")  // return true
search("b..")  // return true
Note
You may assume that all words are consist of lowercase letters a-z.


    */
    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
        if (word == null) return;
        TrieNode now = root;
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if (!now.children.containsKey(curChar)) {
                now.children.put(curChar, new TrieNode());
            }
            now = now.children.get(curChar);
        }
        now.hasWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    
    public boolean search(String word) {
        return search(word, root);
    }
    
    private boolean search(String word, TrieNode pNode) {
        // Write your code here
        if (word == null) {
            return false;
        }
        if (word.length() == 0) {
            return pNode.hasWord;
        }
        char curChar = word.charAt(0);
        if (curChar != '.') {
            if (pNode.children.containsKey(curChar)) {
                return search(word.substring(1, word.length()), pNode.children.get(curChar));
            }
            else {
                return false;
            }
        }
        else {
            Collection<TrieNode> subNodes = pNode.children.values();
            for (TrieNode node : subNodes) {
                boolean subSearch = search(word.substring(1, word.length()), node);
                if (subSearch == true) return true;
            }
            return false;
        }
        
    }
}
