package array.queueandstack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/the-skyline-problem/
 */
public class TheSkylineProblem {

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return res;
        }
        List<int[]> height = new ArrayList<>();
        for (int[] building : buildings) {
            height.add(new int[]{building[0], -building[2]}); // "-" Mark it as the start point
            height.add(new int[]{building[1], building[2]});  //
        }
        Collections.sort(height, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // Put 0 as the baseline
        pq.offer(0);
        int pre = 0;
        for (int[] h : height) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if (pre != cur) {
                res.add(new int[]{h[0], cur});
                pre = cur;
            }
        }
        return res;
    }
}
