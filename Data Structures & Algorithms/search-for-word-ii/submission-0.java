class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    String word = null;
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        List<String> result = new ArrayList<>();
        for(String word : words) {
            TrieNode curr = root;
            for(char c : word.toCharArray()){
                if(!curr.children.containsKey(c))
                    {
                        curr.children.put(c, new TrieNode());
                    }
            curr = curr.children.get(c);
            }
            curr.word = word;
        }

        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board,i,j,root,result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {

         // boundaries
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) 
        {
            return;
        }

        if(!node.children.containsKey(board[i][j])) {
            return;
        }
        char c = board[i][j];
        board[i][j] = '#';

        TrieNode childnode = node.children.get(c);
        if(childnode.word != null) {
            result.add(childnode.word);
            childnode.word = null;
        }

        dfs(board, i-1, j, childnode, result);
        dfs(board, i, j-1, childnode, result);
        dfs(board, i+1, j, childnode, result);
        dfs(board, i, j+1, childnode, result);

    if (childnode.children.isEmpty()) node.children.remove(c);

        board[i][j] = c;

    }
}
