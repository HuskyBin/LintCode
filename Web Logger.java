/*
Implement a web logger, which provide two methods:

hit(timestamp), record a hit at given timestamp.
get_hit_count_in_last_5_minutes(timestamp), get hit count in last 5 minutes.
the two methods will be called with non-descending timestamp (in sec).

Have you met this question in a real interview? Yes
Example
hit(1);
hit(2);
get_hit_count_in_last_5_minutes(3);
>> 2
hit(300);
get_hit_count_in_last_5_minutes(300);
>> 3
get_hit_count_in_last_5_minutes(301);
>> 2
*/
public class WebLogger {
    private List<Integer> list = new ArrayList<>();

    public WebLogger() {
        // initialize your data structure here.
    }

    /**
     * @param timestamp an integer
     * @return void
     */
    public void hit(int timestamp) {
        // Write your code here
        if (timestamp <= 300) {
            list.add(timestamp);
            return;
        }
        int lessThanIndex = findLessThanIndexWithBinarySearch(timestamp - 300);
        if (lessThanIndex + 1 > list.size() - 1) {
            list = new ArrayList<>();
        }
        else {
            list = list.subList(lessThanIndex + 1, list.size());    
        }
        
        list.add(timestamp);
        
    }
    
    private int findLessThanIndexWithBinarySearch(int value) {
        if (list.size() == 0) {
            return 0;
        }
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int middle = (start + (end - start) / 2);
            if (list.get(middle) == value && ((middle < list.size() - 1 && list.get(middle + 1) > value) || (middle == list.size() - 1))) {
                return middle;
            }
            else if (list.get(middle) < value) {
                start = middle + 1;
            }
            else if (list.get(middle) > value){
                end = middle - 1;
            }
            else {
                start++;
            }
        }
        return end;
    }

    /**
     * @param timestamp an integer
     * @return an integer
     */
    public int get_hit_count_in_last_5_minutes(int timestamp) {
        // Write your code here
        if (list.size() == 0) {
            return 0;
        }
        return list.size() - 1 - findLessThanIndexWithBinarySearch(timestamp - 300);
    }
}
