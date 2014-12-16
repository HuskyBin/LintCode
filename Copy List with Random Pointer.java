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
