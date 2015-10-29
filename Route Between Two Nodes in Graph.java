/*
Given a directed graph, design an algorithm to find out whether there is a route between two nodes.

Have you met this question in a real interview? Yes
Example
Given graph:

A----->B----->C
 \     |
  \    |
   \   |
    \  v
     ->D----->E
for s = B and t = E, return true

for s = D and t = C, return false
*/

//dfs
public class Solution {
   /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
                            DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        Set<DirectedGraphNode> visited = new HashSet<>();
        visited.add(s);
        return hasRouteCore(s, t, visited);
    }
    
    private boolean hasRouteCore(DirectedGraphNode s, DirectedGraphNode t, Set<DirectedGraphNode> visited) {
        if (s == t) {
            return true; 
        }
        
        List<DirectedGraphNode> neighbors = s.neighbors;
        for (DirectedGraphNode node : neighbors) {
            if (visited.contains(node)) continue;
            visited.add(node);
            if (hasRouteCore(node, t, visited)) return true;
        }
        return false;
    }
}


// bfs
public class Solution {
   /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
                            DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        Set<DirectedGraphNode> visited = new HashSet<>();
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        visited.add(s);
        queue.offer(s);
        while (queue.size() > 0) {
            DirectedGraphNode node = queue.poll();
            if (node == t) return true;
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                }
            }
        }
        return false;
    }
    
   
}
