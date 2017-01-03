package array.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/reconstruct-itinerary/
 */
public class ReconstructItinerary {

    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map  = new HashMap<>();
        for (String[] ticket : tickets) {
            PriorityQueue<String> pq = map.get(ticket[0]);
            if (pq == null) {
                pq = new PriorityQueue<>();
                map.put(ticket[0], pq);
            }
            pq.offer(ticket[1]);
        }
        String cur = "JFK";
        List<String> res = new ArrayList<>();
        dfsHelper(cur, map, res);
        Collections.reverse(res);
        return res;
    }

    private void dfsHelper(String cur, Map<String, PriorityQueue<String>> map, List<String> list) {
        while (map.get(cur) != null && !map.get(cur).isEmpty()) {
            dfsHelper(map.get(cur).poll(), map, list);
        }
        list.add(cur);
    }
}
