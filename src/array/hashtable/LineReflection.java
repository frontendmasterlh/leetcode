package array.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given set of points.

 Example 1:
 Given points = [[1,1],[-1,1]], return true.

 Example 2:
 Given points = [[1,1],[-1,-1]], return false.

 Follow up:
 Could you do better than O(n2)?

 Hint:

 Find the smallest and largest x-value for all points.
 If there is a line then it should be at y = (minX + maxX) / 2.
 For each point, make sure that it has a reflected point in the opposite side.
 */
public class LineReflection {
    public boolean isReflected(int[][] points) {
        if (points == null || points.length < 2) {
            return true;
        }
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int[] point : points) {
            max = Math.max(max, point[0]);
            min = Math.min(min, point[0]);
            HashSet<Integer> set = map.get(point[0]);
            if (set == null) {
                set = new HashSet<>();
                map.put(point[0], set);
            }
            set.add(point[1]);
        }
        int y = max + min;
        for (int[] point : points) {
            int left = point[0];
            int right = y - left;
            if (!map.containsKey(right) || !map.get(right).contains(point[1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LineReflection l = new LineReflection();
        int[][] points = {
                {1, 1},
                {-1, 1}
        };
        System.out.println(l.isReflected(points));
    }
}
