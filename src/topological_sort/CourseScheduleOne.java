package topological_sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleOne {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        CourseScheduleOne courseScheduleOne = new CourseScheduleOne();
        boolean canBeFinished = courseScheduleOne.canFinish(numCourses, prerequisites);
        System.out.println("Can be finished: " + canBeFinished);

    }


    public boolean canFinish(int numCourse, int[][] prerequisites) {
        //form a graph first
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourse; i++) {
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[0]).add(prerequisite[1]);
        }
        int[] indegree = new int[numCourse];
        for (int i = 0; i < numCourse; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourse; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.peek();
            queue.remove();
            topo.add(node);

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) queue.add(it);
            }
        }

        if (topo.size() == numCourse) return true;
        return false;


    }

}
