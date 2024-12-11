package medium.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * https://leetcode.com/problems/course-schedule-ii/description/
 */
public class CourseScheduleII {
    /*
     * Time Complexity: O(V + E)
     * Space Complexity: O(V + E)
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        // Initialize the graph
        for (int[] pre : prerequisites) {
            int target = pre[0];
            int preCourse = pre[1];
            // Create an edge from preCourse to target
            map.computeIfAbsent(preCourse, k -> new ArrayList<>()).add(target);
            inDegree[target] += 1;
        }

        // Find all courses with no prerequisites
        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order[index++] = node;
            
            if (map.containsKey(node)) {
                for (int target : map.get(node)) {
                    inDegree[target] -= 1;
                    if (inDegree[target] == 0) {
                        queue.offer(target);
                    }
                }
            }
        }

        return index == numCourses ? order : new int[0];
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();
        
        CourseScheduleII courseScheduleII = new CourseScheduleII();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] order = courseScheduleII.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(order));
    }
}
