public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if (head == null) {
            return head;
        }
        ListNode fastNode = head;
        
        while (n > 0 && fastNode != null) {
            n--;
            fastNode = fastNode.next;
        }
        if (fastNode == null) {
            if (n == 0) {
                ListNode newHead = head.next;
                head.next = null;
                head = newHead;
            }
        
            return head;
        }
        
        ListNode slowNode = head;
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;
        return head;
    }
}
