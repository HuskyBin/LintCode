/*
Implement a load balancer for web servers. It provide the following functionality:

Add a new server to the cluster => add(server_id).
Remove a bad server from the cluster => remove(server_id).
Pick a server in the cluster randomly with equal probability => pick().
Have you met this question in a real interview? Yes
Example
At beginning, the cluster is empty => {}.

add(1)
add(2)
add(3)
pick()
>> 1         // the return value is random, it can be either 1, 2, or 3.
pick()
>> 2
pick()
>> 1
pick()
>> 3
remove(1)
pick()
>> 2
pick()
>> 3
pick()
>> 3
*/
public class loadBalancer {
    
    private Map<Integer, Integer> map = new HashMap<>();
    private List<Integer> list = new ArrayList<>();
    private int length = 0;
    
    public loadBalancer() {
        // Initialize your data structure here.
    }

    // @param server_id add a new server to the cluster 
    // @return void
    public void add(int server_id) {
        // Write your code here
        if (list.size() > length) {
            list.set(length, server_id);
        }        
        else {
            list.add(server_id);
        }
        map.put(server_id, length);
        length++;
    }

    // @param server_id server_id remove a bad server from the cluster
    // @return void
    public void remove(int server_id) {
        // Write your code here
        int index = map.get(server_id);
        if (length > 1) {
            int lastServerId = list.get(length - 1);
            list.set(index, lastServerId);
            map.put(lastServerId, index);   
        }
        map.remove(server_id);
        length--;
    }

    // @return pick a server in the cluster randomly with equal probability
    public int pick() {
        // Write your code here
        if (length == 0) {
            throw new RuntimeException("No server available!");
        }
        Random r = new Random();
        int index = r.nextInt(length);
        return list.get(index);
    } 
}
