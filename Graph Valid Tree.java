/*


Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

Have you met this question in a real interview? 

Yes
 




Example 

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Note 

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
Tags  Expand    



*/
public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        // if (n <= 0 || edges == null) {
        //     return false;
        // }
        if (n == 1 && edges.length == 0) {
            return true;
        }
        
        Map<Integer, Set<Integer>> node = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int edgeStartNode = edges[i][0];
            int edgeEndNode = edges[i][1];
            updateNodeMap(node, edgeStartNode, edgeEndNode);
        }
        
        Set<Integer> visitedNode = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        if (edges.length > 0) {
            queue.add(edges[0][0]);    
        }
        
        while (queue.size() > 0) {
            int topNode = queue.poll();
            if (visitedNode.contains(topNode)) {
                return false;
            }
            Set<Integer> linkedNode = node.get(topNode);
            for (int eachNode : linkedNode) {
                Set<Integer> curSet = node.get(eachNode);
                curSet.remove(topNode);
                node.put(eachNode, curSet);
                queue.add(eachNode);
            }
            visitedNode.add(topNode);
        }
        if (visitedNode.size() == n) {
            return true;
        }
        else {
            return false;
        }
    }
    
    private void updateNodeMap(Map<Integer, Set<Integer>> node, int start, int end) {
        if (node.containsKey(start)) {
            Set<Integer> curSet = node.get(start);
            curSet.add(end);
            node.put(start, curSet);
        }
        else {
            Set<Integer> newSet = new HashSet<>();
            newSet.add(end);
            node.put(start, newSet);
        }
        if (node.containsKey(end)) {
             Set<Integer> curSet = node.get(end);
            curSet.add(start);
            node.put(end, curSet);
        }
        else {
            Set<Integer> newSet = new HashSet<>();
            newSet.add(start);
            node.put(end, newSet);
        }
    }
}
