/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
Example
*/


//DFS  will  over time limit
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return node;
        }
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode copyRoot = cloneGraphHelper(node, map);
        return copyRoot;
    }
    
    private UndirectedGraphNode cloneGraphHelper(UndirectedGraphNode pNode, Map<Integer, UndirectedGraphNode> map) {
        UndirectedGraphNode copyNode = new UndirectedGraphNode(pNode.label);
        map.put(pNode.label, copyNode);
        ArrayList<UndirectedGraphNode> neighbors = pNode.neighbors;
        for (UndirectedGraphNode node : neighbors) {
            if (map.containsKey(node.label)) {
                copyNode.neighbors.add(map.get(node.label));
            }
            else {
                UndirectedGraphNode copyNeighborNode = cloneGraphHelper(node, map);
                copyNode.neighbors.add(copyNeighborNode);
            }
        }
        return copyNode;
    }
}


// BFS

public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return node;
        }
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode copyRoot = new UndirectedGraphNode(node.label);
        map.put(node.label, copyRoot);
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode curNode = queue.poll();
            UndirectedGraphNode copyNode = map.get(curNode.label);
            ArrayList<UndirectedGraphNode> neighbors = curNode.neighbors;
            for (UndirectedGraphNode neighborNode : neighbors) {
                UndirectedGraphNode copyNeighbor = null;
                if (map.containsKey(neighborNode.label)) {
                    copyNeighbor = map.get(neighborNode.label);
                }
                else {
                    queue.offer(neighborNode);
                    copyNeighbor = new UndirectedGraphNode(neighborNode.label);
                    map.put(neighborNode.label, copyNeighbor);
                }
                copyNode.neighbors.add(copyNeighbor);

            }
        }
        return copyRoot;
    }
}
