package array.hashtable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //Method: HashMap O(n) + PriorityQueue O(nlogk) Space: O(n)
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                new Comparator<Map.Entry<Integer, Integer>>() {
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        if (o1.getValue() == o2.getValue()) {
                            return 0;
                        } else if (o1.getValue() > o2.getValue()) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                });
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (pq.size() < k) {
                pq.offer(entry);
            } else {
                if (pq.peek().getValue() < entry.getValue()) {
                    pq.poll();
                    pq.offer(entry);
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : pq) {
            res.add(entry.getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] nums = {1,1,1,2,2,3};
        List<Integer> res = topKFrequentElements.topKFrequent(nums, 2);
        for (Integer r : res) {
            System.out.print(r + " ");
        }
    }
}
