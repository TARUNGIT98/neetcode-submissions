/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        // handle null 
        if(node == null) return null;
        return dfs(node);
    }
    private Node dfs(Node node) {
      // a set only tell you if we visited or not , but map helps us look up the neighbours and retrieve.
      if(map.containsKey(node)) {
        return map.get(node);
        }
        Node copy = new Node(node.val);
        map.put(node, copy);

        for(Node neigh : node.neighbors) {
            copy.neighbors.add(dfs(neigh));
        }
        return copy;
    }
}