class Solution {
    public String foreignDictionary(String[] words) {
      // Adjacency maps to implement a Graph
      Map<Character, List<Character>> graph = new HashMap<>();

      Map<Character, Integer> inDegree = new HashMap<>(); // to check degree of each node

      StringBuilder result = new StringBuilder();

    for(String word : words) {
        for(char c : word.toCharArray()) {
    
        if(!graph.containsKey(c)){
            graph.put(c, new ArrayList<>()); // empty list for each char
            inDegree.put(c,0); // zero degree as we are initializing nodes }
        }
    }
    }

    // The edge building loop over adjacent pairs.
    for(int i = 0; i < words.length - 1; i++) {
        String w1 = words[i]; // first pair
        String w2 = words[i+1]; // second pair
        boolean found = false; // flag
        for(int j = 0; j < Math.min(w1.length(), w2.length()); j++) { 
            char from = w1.charAt(j);
            char to = w2.charAt(j);
            if(from != to) {
                graph.get(from).add(to); // attaching nodes
                inDegree.put(to, inDegree.get(to) + 1); // increase teh degree
                found = true; // found the edge
                break;
            }
        }
        if(!found && w1.length() > w2.length()) {
                return "";
            }
    }

    // kahn's algo
    

    Queue<Character> queue = new LinkedList<>();
    
    for(char c : inDegree.keySet()) {
        if(inDegree.get(c) == 0) queue.offer(c);
    }

    // built the nodes above.
    
    while(!queue.isEmpty()) {
        char current = queue.poll();

        for(char next : graph.get(current)) {
            inDegree.put(next, inDegree.getOrDefault(next, 0) - 1);
            if(inDegree.get(next) == 0) queue.offer(next);
        }
        result.append(current);
    }
    if(result.length() == inDegree.size()) {
        return result.toString();
    }
    return("");
}
}