/*
As the title described, you should only use two stacks to implement a queue's actions.

The queue should support push(element), pop() and top() where pop is pop the first(a.k.a front) element in the queue.

Both pop and top methods should return the value of first element.

Example
For push(1), pop(), push(2), push(3), top(), pop(), you should return 1, 2 and 2


*/
public class Solution {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Solution() {
       // do initialization if necessary
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    public int pop() {
        // write your code here
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            if (stack2.isEmpty()) {
                return Integer.MIN_VALUE;
            }
            return stack2.pop();
        }
        else {
            return stack2.pop();
        }
        
    }

    public int top() {
        // write your code here
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            if (stack2.isEmpty()) {
                return Integer.MIN_VALUE;
            }
            return stack2.peek();
        }
        else {
            return stack2.peek();
        }
    }
}

