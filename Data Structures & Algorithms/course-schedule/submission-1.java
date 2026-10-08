class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // base case
        if(prerequisites == null) return true;
        // Adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        int[] degree = new int[numCourses];

        for(int i = 0; i < numCourses ;i++) {
            graph.add(new ArrayList<>());
        }
        
        // Graph that tracks the completion of pre reqs
        for(int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            degree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++)
            if(degree[i] == 0)
            // all courses with no dependency nodes / courses are added to the  queue first.
                queue.offer(i);
        // implement bfs

        int count = 0;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            count++;

            for(int next : graph.get(current)) {
                degree[next]--;
                if(degree[next] == 0) queue.offer(next);
            }
        }
        return count == numCourses;
    }

}
