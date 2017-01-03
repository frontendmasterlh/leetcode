package array.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            return true;
        }
        Set<Integer> white = new HashSet<>();
        Set<Integer> grey = new HashSet<>();
        Set<Integer> black = new HashSet<>();
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            white.add(i);
            adjList.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adjList.get(pre[1]).add(pre[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (white.contains(i)) {
                if (hasCircle(i, white, grey, black, adjList)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasCircle(int vertex, Set<Integer> white, Set<Integer> grey, Set<Integer> black, List<List<Integer>> adjList) {
        white.remove(vertex);
        grey.add(vertex);
        for (int next : adjList.get(vertex)) {
            if (grey.contains(next)) {
                return true;
            } else if (white.contains(next)) {
                if (hasCircle(next, white, grey, black, adjList)) {
                    return true;
                }
            } else if (black.contains(next)){
                continue;
            }
        }
        grey.remove(vertex);
        black.add(vertex);
        return false;
    }
}
