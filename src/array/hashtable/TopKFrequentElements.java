package array.hashtable;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //Method 1: HashMap O(n) + PriorityQueue(MinHeap) O(nlogk) Space: O(n)
        // List<Integer> res = new ArrayList<>();
        // Map<Integer, Integer> map = new HashMap<>();
        // PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(
        //     new Comparator<Map.Entry<Integer, Integer>>(){
        //         public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        //             if (o1.getValue() == o2.getValue()) {
        //                 return 0;
        //             } else if (o1.getValue() > o2.getValue()) {
        //                 return 1;
        //             } else {
        //                 return -1;
        //             }
        //         }
        //     });
        // for (int num : nums) {
        //     if (map.containsKey(num)) {
        //         map.put(num, map.get(num) + 1);
        //     } else {
        //         map.put(num, 1);
        //     }
        // }

        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //     if (pq.size() < k) {
        //         pq.offer(entry);
        //     } else {
        //         if (pq.peek().getValue() < entry.getValue()) {
        //             pq.poll();
        //             pq.offer(entry);
        //         }
        //     }
        // }

        // for (Map.Entry<Integer, Integer> entry : pq) {
        //     res.add(entry.getKey());
        // }
        // return res;

        // Method 2: TreeMap. Time: O(nLogN) Space: O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> list = treeMap.get(entry.getValue());
            if (list == null) {
                list = new ArrayList<>();
                treeMap.put(entry.getValue(), list);
            }
            list.add(entry.getKey());
        }

        List<Integer> res = new ArrayList<>();
        for (List<Integer> list : treeMap.values()) {
            if (res.size() < k) {
                res.addAll(list);
            } else {
                break;
            }
        }
        return res;

        // Method 3: Bucket Sort. Time: O(n) Space: O(n)
        // List<Integer>[] bucket = new List[nums.length + 1];
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int num : nums) {
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        // }

        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //     if (bucket[entry.getValue()] == null) {
        //         bucket[entry.getValue()] = new ArrayList<>();
        //     }
        //     bucket[entry.getValue()].add(entry.getKey());
        // }

        // List<Integer> res = new ArrayList<>();
        // for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
        //     if (bucket[i] != null) {
        //         res.addAll(bucket[i]);
        //     }
        // }
        // return res;
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
