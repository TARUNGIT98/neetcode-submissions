class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if(heights == null || heights.length == 0 || heights[0].length == 0)    return res;

        int rows = heights.length;
        int cols = heights[0].length;

        // two visit matrices to keep track of two oceans
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // DFS calls and also the boundaries of the graph 

        for(int i = 0; i < cols; i++) {
            dfs(heights, 0, i, pacific, Integer.MIN_VALUE);
            dfs(heights, rows-1, i, atlantic, Integer.MIN_VALUE);
        };

        for(int j = 0; j < rows; j++){
            dfs(heights, j, 0, pacific, Integer.MIN_VALUE);
            dfs(heights, j, cols-1, atlantic, Integer.MIN_VALUE);
        }

        // adds up to the result
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i,j));
                };
            };
        };
        return res;
    }

    private void dfs(int [][]heights, int r, int c, boolean[][] ocean, int prevHeight)
        {
            if(r < 0 || c < 0 || r > heights.length - 1 || c > heights[0].length - 1  ) return;
            // if prev height is greater it means the flow don't happen or if the cell is already marked a either (P or A).
            if(heights[r][c] < prevHeight || ocean[r][c]) return;
            ocean[r][c] = true;

            dfs(heights, r+1, c, ocean, heights[r][c]);
            dfs(heights, r-1, c, ocean, heights[r][c]);
            dfs(heights, r, c-1, ocean, heights[r][c]);
            dfs(heights, r, c+1, ocean, heights[r][c]);
        }
}
// Loop i: "Walk down the left edge and the right edge together. Every cell on the left edge touches the Pacific — start a sweep there. Every cell on the right edge touches the Atlantic — start a sweep there."

// Loop j: "Walk across the top edge and the bottom edge. Top touches Pacific, bottom touches Atlantic. Same deal."

// Together: pour water into every cell where an ocean meets the land, and let it climb inward.