
/*
Given a non-overlapping interval list which is sorted by start point.

Insert a new interval into it, make sure the list is still in order and non-overlapping (merge intervals if necessary).

Example
Insert [2, 5] into [[1,2], [5,9]], we get [[1,9]].

Insert [3, 4] into [[1,2], [5,9]], we get [[1,2], [3,4], [5,9]].
*/

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        // write your code here
        if (intervals == null || newInterval == null) {
            return result;
        }
        int index = 0;
        for (int i = 0; i < intervals.size(); i++) {
            Interval curInt = intervals.get(i);
            if (curInt.end < newInterval.start) {
                result.add(curInt);
                index++;
            }
            else if (curInt.start > newInterval.end) {
                result.add(curInt);
            }
            else {
                newInterval.start = Math.min(curInt.start, newInterval.start);
                newInterval.end = Math.max(curInt.end, newInterval.end);
            }
        }
        result.add(index, newInterval);
        return result;
    }
}
