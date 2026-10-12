class Solution {
    public boolean validTree(int n, int[][] edges) {
        // base cases
        if(edges.length != n - 1) {
            return false;
        }

        // now I have to check connectivity 
        // adjacency List
        List<List<Integer>> graph = new ArrayList<>();

        // graph refs created.
        for(int i = 0; i < n ; i++) {
            graph.add(new ArrayList<>());
        }

        // building graph I have two lines cause its undirected graph.
        for(int[] edge : edges ) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        // graph built.

        // now dfs or bfs to visit nodes and check connectivity
        boolean[] visited = new boolean[n];
        dfs(0,graph,visited);

        for(boolean b : visited) {
            if(b == false) return false;
        }

        return true;
    }

    private void dfs(int n, List<List<Integer>> graph, boolean[] visited) {

        // Mark
        visited[n] = true;

        // Loop neigbours
        for(int next : graph.get(n)) {
             if(visited[next] == false) {
                dfs( next, graph, visited);
             }
        }

    }
}
