/*
Medium Intersection of Two Linked Lists Show result 

43% Accepted
Write a program to find the node at which the intersection of two singly linked lists begins.

Have you met this question in a real interview? Yes
Example
The following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.

Note
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Challenge
Your code should preferably run in O(n) time and use only O(1) me
*/
public class Solution {
    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Write your code here
        if (headA == null || headB == null) {
            return null;
        } 
        
        int ALength = getLength(headA);
        int BLength = getLength(headB);
        
        ListNode longerList = ALength > BLength ? headA : headB;
        ListNode lessList = ALength > BLength ? headB : headA;
        
        ListNode fastNode = longerList;
        
        ListNode slowNode = lessList;
        int diff = Math.abs(ALength - BLength);
        while (diff > 0) {
            fastNode = fastNode.next;
            diff--;
        }
        
        while (fastNode != null && slowNode != null) {
            if (fastNode == slowNode) {
                return fastNode;
            }
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        
        return null;
        
    }
    
    private int getLength(ListNode pNode) {
        int result = 0;
        while (pNode != null) {
            pNode = pNode.next;
            result++;
        }
        return result;
    }
}
