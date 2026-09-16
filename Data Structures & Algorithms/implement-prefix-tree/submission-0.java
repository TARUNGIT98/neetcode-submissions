class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEnd = false; 
}

class PrefixTree {
    TrieNode root;
    public PrefixTree() {
        root = new TrieNode(); // The only thing this constructor does, is to initiate a root node. 
    }

    public void insert(String word) {
        TrieNode curr = root;
        // make sure the child exists and then walk into it.
        for(char c : word.toCharArray()) {
            if(!curr.children.containsKey(c)) {
                curr.children.put(c,new TrieNode()); // new trie during insert.
            }
            curr = curr.children.get(c);
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;

        for(char c : word.toCharArray()) {
            if(!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for(char c : prefix.toCharArray()) {
            if(curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else { return false;}
        }
        return true;
    }
}
