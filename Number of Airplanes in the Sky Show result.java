/*
Given an interval list which are flying and landing time of the flight. How many airplanes are on the sky at most?

Have you met this question in a real interview? Yes
Example
For interval list [[1,10],[2,3],[5,8],[4,7]], return 3

Note
If landing and flying happens at the same time, we consider landing should happen at first.
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
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
     
     class Point {
         int time;
         boolean inAir;

         public Point(int time, boolean inAir) {
            this.time = time;
            this.inAir = inAir;
         }
     }
     
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        if (airplanes == null) {
            return 0;
        }
        
        int count = 0;
        List<Point> pointList = new ArrayList<>(airplanes.size() * 2);
        for (Interval airplane : airplanes) {
            Point newPoint = new Point(airplane.start, true);
            Point secondPoint = new Point(airplane.end, false);
            pointList.add(newPoint);
            pointList.add(secondPoint);
        }

        Collections.sort(pointList, new Comparator<Point>() {
            public int compare(Point a, Point b) {
                if (a.time != b.time) {
                    return a.time - b.time;
                }
                else {
                    if (a.inAir) {
                        return 1;
                    }
                    else if (b.inAir) {
                        return -1;
                    }
                    else {
                        return 0;
                    }
                }
            }
        });
        int result = 0;
        for (Point point : pointList) {
            if (point.inAir) {
                count++;
                result = Math.max(result, count);
            }
            else {
                count--;
            }
        }
        return result;
    }
}
