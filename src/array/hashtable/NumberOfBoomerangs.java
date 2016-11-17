package array.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-boomerangs/
 */
public class NumberOfBoomerangs {

    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }
        int totalNum = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Long, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                long distance = getDistance(points[i], points[j]);
                Integer count = map.get(distance);
                if (count != null) {
                    map.put(distance, count + 1);
                } else {
                    map.put(distance, 1);
                }
            }
            for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                Integer num = entry.getValue();
                totalNum += num * (num - 1);
            }
        }
        return totalNum;
    }

    private long getDistance(int[] point1, int[] point2) {
        return (point2[0] - point1[0]) * (point2[0] - point1[0]) +
               (point2[1] - point1[1]) * (point2[1] - point1[1]);
    }
}
