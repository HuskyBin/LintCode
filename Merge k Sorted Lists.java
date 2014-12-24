/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example
Tags Expand 
*/
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        ListNode dummyNode = new ListNode(-1);
        ListNode pNode = dummyNode;
        
        PriorityQueue<ListNode> heap = new PriorityQueue<>(20, new Comparator<ListNode>() {
            public int compare(ListNode pNode1, ListNode pNode2) {
                if (pNode1.val < pNode2.val) {
                    return -1;
                }
                else if (pNode1.val > pNode2.val) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
        });
        
        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);   
            }
        }
        while (heap.size() > 0) {
            ListNode topNode = heap.poll();
            pNode.next = topNode;
            if (topNode.next != null) {
                heap.offer(topNode.next);
            }
            pNode = pNode.next;
        }
        ListNode head = dummyNode.next;
        dummyNode.next = null;
        return head;
    }
}

