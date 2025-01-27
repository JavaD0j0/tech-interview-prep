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
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Initialize the graph
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int preReq = pre[1];
            // Create an edge from preReq to course
            graph.computeIfAbsent(preReq, k -> new ArrayList<>()).add(course);
            inDegree[course]++;
        }

        // Find all courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Perform topological sort (BFS)
        int index = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[index++] = course;
            
            if (graph.containsKey(course)) {
                for (int target : graph.get(course)) {
                    inDegree[target]--;
                    if (inDegree[target] == 0) {
                        queue.offer(target);
                    }
                }
            }
        }

        return index == numCourses ? order : new int[0];
    }
}
