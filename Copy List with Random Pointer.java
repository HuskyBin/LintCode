/*
Fair Copy List with Random Pointer Show Result My Submissions

32% Accepted
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.


*/
// Hashmap Solution
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }
        Map<Integer, RandomListNode> map = new HashMap<>();
        RandomListNode pNode = head;
        RandomListNode preCopyNode = null;
        while (pNode != null) {
            RandomListNode newNode = new RandomListNode(pNode.label);
            map.put(pNode.label, newNode);
            pNode = pNode.next;
            if (preCopyNode != null) {
                preCopyNode.next = newNode;
            }
            preCopyNode = newNode;
        }
        
        pNode = head;
        while (pNode != null) {
            RandomListNode copyNode = map.get(pNode.label);
            RandomListNode randomNode = pNode.random;
            if (randomNode != null) {
                copyNode.random = map.get(randomNode.label);
            }
            pNode = pNode.next;
        }
        return map.get(head.label);
    }
}


// Space Complexity O(1)
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }
       RandomListNode pNode = head;
       insertCopyNode(pNode);
       updateRandomPointer(pNode);
       RandomListNode copyRoot = splitList(pNode);
       return copyRoot;
    }
    
    private void insertCopyNode(RandomListNode pNode) {
        while (pNode != null) {
           RandomListNode nextNode = pNode.next;
           RandomListNode copyNode = new RandomListNode(pNode.label);
           pNode.next = copyNode;
           copyNode.next = nextNode;
           pNode = nextNode;
       }
    }
    
    private void updateRandomPointer(RandomListNode pNode) {
        while (pNode != null) {
            RandomListNode nextNode = pNode.next.next;
            RandomListNode copyNode = pNode.next;
            if (pNode.random != null) {
                copyNode.random = pNode.random.next;
            }
            pNode = nextNode;
        }
    }
    
    private RandomListNode splitList(RandomListNode pNode) {
        RandomListNode nodeOne = pNode;
        RandomListNode nodeTwo = pNode.next;
        pNode = pNode.next.next;
        nodeOne.next = null;
        RandomListNode copyRoot = nodeTwo;
        while (pNode != null) {
            nodeOne.next = pNode;
            nodeTwo.next = pNode.next;
            pNode = pNode.next.next;
            nodeOne = nodeOne.next;
            nodeTwo = nodeTwo.next;
        }
        return copyRoot;
    }
}
