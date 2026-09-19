class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>(); // ds
    boolean isEnd = false; // flag to mark end of the word.
}
class WordDictionary {
    TrieNode root; // variable of class TrieNode
    public WordDictionary() {
        root = new TrieNode(); // instantiating.
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray())
        {
            if(!curr.children.containsKey(c))
            {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int i) {
        if(i == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(i);

        if(c == '.') {
            for(TrieNode child : node.children.values()) {
                if (dfs(child, word, i+1)) return true;
            }
            return false;
        }
        else 
        {
            if(!node.children.containsKey(c)) return false;
            return dfs(node.children.get(c), word, i+1);
        }
    }
}


    
