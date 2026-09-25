class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(dfs(board,word,i,j,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,String word, int i, int j, int index) {
        if( index == word.length()) {
            return true;
        }

        // boundaries
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) 
        {
            return false;
        }
        // as we are not using same cell more than once we are going to mark it visited;
        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = dfs(board,word,i-1,j,index+1)
        || dfs(board,word,i,j-1,index+1)
        || dfs(board,word,i+1,j,index+1)
        || dfs(board,word,i,j+1,index+1);

        // now do not forget to restore the cell back cause it can be a part of the other word.

        board[i][j] = temp;
        return found;
        
    }
}
