 class TrieNode {
        
        public char content;
        public boolean isEnd;
        public int count;
        public List<TrieNode> subNode;
        
        public TrieNode(char c) {
            this.content = c;
            isEnd = false;
            count = 1;
            subNode = new LinkedList<TrieNode>();
        }
        
        public TrieNode findSubNode(char c) {
            if (subNode != null) {
                for (TrieNode t : subNode) {
                    if (t.content == c) {
                        return t;
                    }
                }
            }
            return null;
        }
    }
    
    
    
 class Trie {
        public TrieNode root;
        
        public Trie() {
            root = new TrieNode(' ');
        }
        
        public boolean search(String str) {
            if (str == null || str.length() == 0) {
                return false;
            }
            TrieNode current = root;
            for (char ch : str.toCharArray()) {
                if (current.findSubNode(ch) == null) {
                    return false;
                }
                else {
                    current = current.findSubNode(ch);
                }
            }
            if (current.isEnd == true) {
                return true;
            }
            return false;
        }
        
        public void insert(String str) {
            if (str == null || str.length() == 0) {
                return;
            }
            if (search(str) == true) {
                return;
            }
            TrieNode current = root;
            for (char ch : str.toCharArray()) {
                if (current.findSubNode(ch) == null) {
                    TrieNode newNode = new TrieNode(ch);
                    current.subNode.add(newNode);
                    current = newNode;
                }
                else {
                    current.count += 1;
                    current = current.findSubNode(ch);
                }
            }
            current.isEnd = true;
        }
        
        public void remove(String str) {
            if (str == null || str.length() == 0) {
                return;
            }
            TrieNode current = root;
            if (search(str) == false) {
                return;
            }
            for (char ch : str.toCharArray()) {
                TrieNode child = current.findSubNode(ch);
                if (child.count == 1) {
                    current.subNode.remove(child);
                }
                else {
                    child.count -= 1;
                    current = child;
                }
            }
            current.isEnd = false;
        }
    }
