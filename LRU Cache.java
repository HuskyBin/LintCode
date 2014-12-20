/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.


*/
public class Solution {

    // @param capacity, an integer
    private ListNode head = new ListNode(-1, -1);
    private ListNode end = new ListNode(-1, 1);
    private int capacity = 0;
    private int curSize = 0;
    private Map<Integer, ListNode> map;
    
    public Solution(int capacity) {
        // write your code here
        this.capacity = capacity;
        head.next = end;
        end.pre = head;
        map = new HashMap<>();
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        ListNode result = null;
        if (map.containsKey(key)) {
            result = map.get(key);
            /*ListNode preNode = result.pre;
            ListNode nextNode = result.next;
            preNode.next = nextNode;
            nextNode.pre = preNode;

            result.pre = start;
            ListNode firstNode = start.next;
            result.next = firstNode;
            start.next = result;
            firstNode.pre = result;*/
            deleteNode(result);
            addNode(result);
            return result.val;
        }
        return -1;
    }
    
    private void deleteNode(ListNode pNode) {
        ListNode preNode = pNode.pre;
        ListNode nextNode = pNode.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
    }
    
    private void addNode(ListNode pNode) {
        pNode.pre = head;
        ListNode firstNode = head.next;
        pNode.next = firstNode;
        head.next = pNode;
        firstNode.pre = pNode;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        if (map.containsKey(key)) {
            ListNode pNode = map.get(key);
            pNode.val = value;
            deleteNode(pNode);
            addNode(pNode);
        }
        else {
            if (curSize < capacity) {
                ListNode newNode = new ListNode(key, value);
                map.put(key, newNode);
                addNode(newNode);
                curSize++;
            }
            else {
                ListNode lastNode = end.pre;
                int lastNodeKey = lastNode.key;
                map.remove(lastNodeKey);
                deleteNode(lastNode);
                ListNode newNode = new ListNode(key, value);
                addNode(newNode);
                map.put(key, newNode);
            }
        }
    }
    
    private class ListNode {
        public int val;
        public ListNode next;
        public ListNode pre;
        public int key;
        public ListNode(int key, int val) {
            this.val = val;
            next = null;
            pre = null;
            this.key = key;
        }
    }
}
