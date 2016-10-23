package array.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

 There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

 4, [[1,0],[2,0],[3,1],[3,2]]
 There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3].
 Another correct ordering is[0,2,1,3].
 */
public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) {
            return new int[0];
        }
        // Set<Integer> white = new HashSet<>();
        // Set<Integer> grey = new HashSet<>();
        // Set<Integer> black = new LinkedHashSet<>();
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegrees = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            // white.add(i);
            adjList.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adjList.get(pre[1]).add(pre[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            for (Integer course : adjList.get(i)) { // Record all the indegrees
                indegrees[course]++;
            }
        }
        for (int i = 0; i < indegrees.length; i++) {  // Push the courses when indegree is 0
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        }

        int[] res = new int[numCourses];
        int count = 0;
        while (!q.isEmpty()) {
            Integer course = q.poll();
            for (int next: adjList.get(course)) {
                indegrees[next]--;
                if (indegrees[next] == 0) {
                    q.offer(next);
                }
            }
            res[count++] = course;
        }

        if (count == numCourses) {
            return res;
        } else {
            return new int[0];
        }

        // for (int i = 0; i < numCourses; i++) {
        //     if (white.contains(i)) {
        //         if (hasCircle(i, white, grey, black, adjList)) {
        //             return new int[0];
        //         }
        //     }
        // }
        // if (black.size() != numCourses) {
        //     return new int[0];
        // } else {
        //     int[] res = new int[numCourses];
        //     Iterator<Integer> it = black.iterator();
        //     for (int i = res.length - 1; i >= 0; i--) {
        //         if (it.hasNext()) {
        //             res[i] = it.next();
        //         }
        //     }
        //     return res;
        // }
    }

    public static void main(String[] args) {
        CourseScheduleII c = new CourseScheduleII();
        int[][] courses = {};
        int[] res = c.findOrder(2, courses);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
