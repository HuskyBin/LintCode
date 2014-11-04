/*
The code base version is an integer and start from 1 to n. One day, someone commit a bad version in the code case, so it caused itself and the following versions are all failed in the unittests.
You can determine whether a version is bad by the following interface: 
    boolean isBadVersion(int version);
Find the first bad version.
Note
You should call isBadVersion as few as possible. 

Example
Given n=5

Call isBadVersion(3), get false

Call isBadVersion(5), get true

Call isBadVersion(4), get true

return 4 is the first bad version


*/
/**
 * public class VersionControl {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use VersionControl.isBadVersion(k) to judge wether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        if (n <= 0) {
            return -1;
        }
        int start = 1;
        int end = n;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            boolean middleResult = VersionControl.isBadVersion(middle);
            if (middle > 1 && middleResult == true && 
                VersionControl.isBadVersion(middle - 1) == false) {
                return middle;        
            }
            if (middle == 1 && middleResult == true) {
                return middle;
            }
            if (middleResult == true) {
                end = middle - 1;
            }
            else {
                start = middle + 1;
            }
        }
        return - 1;
    }
}

