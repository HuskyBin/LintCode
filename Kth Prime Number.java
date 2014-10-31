/*
Fair Kth Prime Number Show Result My Submissions

13% Accepted
Design an algorithm to find the kth number such that the only prime factors are 3, 5, and 7.

The eligible numbers are like 3, 5, 7, 9, 15 ...

Example
If k=4, return 9.


*/
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    /**
     * @param k: The number k.
     * @return: The kth prime number as description.
     */
    public long kthPrimeNumber(int k) {
        // write your code here
        if (k <= 0) {
            return 0;
        }
        Queue<Long> qThree = new LinkedList<>();
        Queue<Long> qFive = new LinkedList<>();
        Queue<Long> qSeven = new LinkedList<>();
        
        qThree.add(3L);
        qFive.add(5L);
        qSeven.add(7L);
        long result = 1;
        while (k > 0) {
            long minThree = qThree.peek();
            long minFive = qFive.peek();
            long minSeven = qSeven.peek();
            
            if (minThree < minFive && minThree < minSeven) {
                result = minThree;
                qThree.poll();
                qThree.add(minThree * 3);
                qFive.add(minThree * 5);
                qSeven.add(minThree * 7);
            }
            else if (minFive < minThree && minFive < minSeven) {
                result = minFive;
                qFive.poll();
                qFive.add(minFive * 5);
                qSeven.add(minFive * 7);
            }
            else {
                qSeven.poll();
                result = minSeven;
                qSeven.add(minSeven * 7);
            }
            k--;
            if (k == 0) {
                return result;
            }
        }
        return Integer.MIN_VALUE;
    }
};

