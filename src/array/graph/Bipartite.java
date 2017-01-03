package array.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created by jli1 on 11/5/16.
 */
public class Bipartite {
    public class GraphNode {
        int val;
        char set;
        List<GraphNode> succesors;
        public GraphNode(int x, char y, List<GraphNode> s) {
            this.val = x;
            this.set = y;
            this.succesors = s;
        }
    }

    public boolean isBipartite(List<GraphNode> graph) {
        Map<GraphNode, Integer> isVisited = new HashMap<>();
        for (GraphNode node : graph) {
            if (!bfs(node, isVisited)) {
                return false;
            }
        }
        return true;
    }

    private boolean bfs(GraphNode node, Map<GraphNode, Integer> isVisited) {
        if (isVisited.containsKey(node)) {
            return true;
        }
        Queue<GraphNode> q = new LinkedList<>();
        q.offer(node);
        isVisited.put(node, 0);

        while (!q.isEmpty()) {
            GraphNode cur = q.poll();
            int neighbourSign = isVisited.get(cur) == 0 ? 1 : 0;
            for (GraphNode neignbour : cur.succesors) {
                if (!isVisited.containsKey(neignbour)) {
                    q.offer(neignbour);
                    isVisited.put(neignbour, neighbourSign);
                } else if (isVisited.get(neignbour) != neighbourSign) {
                    return false;
                }
            }
        }
        return true;
    }
}
