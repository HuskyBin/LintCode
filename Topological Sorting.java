/*
Given an directed graph, a topological order of the graph nodes is defined as follow:

For each directed edge A-->B in graph, A must before B in the order list.
The first node in the order can be any node in the graph with no nodes direct to it.
Find any topological order for the given graph.
Note
You can assume that there is at least one topological order in the graph.
Example
For graph as follow: 



The topological order can be:

[0, 1, 2, 3, 4, 5]

or

[0, 2, 3, 1, 5, 4]

or

....



Challenge
Can you do it in both BFS and DFS?
*/
/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> resultList = new ArrayList<>();
        if (graph == null || graph.size() == 0) {
            return resultList;
        }
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        Map<DirectedGraphNode, Integer> indegreeMap = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            indegreeMap.put(node, 0);
        }
        for (DirectedGraphNode node : graph) {
            ArrayList<DirectedGraphNode> neighbors = node.neighbors;
            for (DirectedGraphNode neighNode : neighbors) {
                indegreeMap.put(neighNode, indegreeMap.get(neighNode) + 1);
            }
        }
        
        topSortHelper(graph, indegreeMap, resultList);
        return resultList;
    }
    
    private void topSortHelper(ArrayList<DirectedGraphNode> graph, Map<DirectedGraphNode, Integer> indegreeMap, ArrayList<DirectedGraphNode> resultList) {
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        Map<DirectedGraphNode, Boolean> visited = new HashMap<>();
        for (Map.Entry<DirectedGraphNode, Integer> entry : indegreeMap.entrySet()) {
            DirectedGraphNode key = entry.getKey();
            int value = entry.getValue();
            if (value == 0) {
                queue.add(key);
            }
        }
        
        while (queue.size() > 0) {
            DirectedGraphNode topNode = queue.poll();
            resultList.add(topNode);
            visited.put(topNode, true);
            for (DirectedGraphNode neighborNode : topNode.neighbors) {
                if (visited.containsKey(neighborNode)) {
                    break;
                }
                indegreeMap.put(neighborNode, indegreeMap.get(neighborNode) - 1);
                if (indegreeMap.get(neighborNode) == 0) {
                    queue.add(neighborNode);
                }
            }
        }
        return;
    }
}
