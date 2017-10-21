package leetcode_C;

import java.util.*;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode (int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	};
}

public class CloneGraph {
	/*The method is to use a hash table to store the key and relevant new nodes,
	 * whereas use queue to store the sequence. */
	// Method 1: BFS
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node==null)
            return null;
//        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode> ();
//        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode> ();
//        //UndirectedGraphNode temp = new UndirectedGraphNode(node.label);
//        q.offer(node);
//        // map.put(node.label, temp);
//        UndirectedGraphNode cur = null;
//        while (!q.isEmpty()){
//            cur = q.poll();
//            if (map.get(cur.label)==null){
//                UndirectedGraphNode temp = new UndirectedGraphNode(cur.label);
//                map.put(cur.label, temp);
//                for (int i=0; i < cur.neighbors.size(); i++){
//                    q.offer(cur.neighbors.get(i));
//                }
//            }
//        }
//
//        q.offer(node);
//        while (!q.isEmpty()){
//            cur = q.poll();
//            UndirectedGraphNode temp = map.get(cur.label);
//            if (temp.neighbors.isEmpty() && !cur.neighbors.isEmpty()){
//                for (int i=0; i < cur.neighbors.size(); i++){
//                    temp.neighbors.add(map.get(cur.neighbors.get(i).label));
//                    q.offer(cur.neighbors.get(i));
//                }
//            }
//        }
//        return map.get(node.label);


        // Method 2: DFS
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        return clone(node, map);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        map.put(node.label, cloneNode);
        for (UndirectedGraphNode child : node.neighbors) {
            cloneNode.neighbors.add(clone(child, map));
        }
        return cloneNode;
    }
}
