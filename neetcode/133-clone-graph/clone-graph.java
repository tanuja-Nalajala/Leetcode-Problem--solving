/*
// Definition for a Node.
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
    HashMap<Node, Node> mp= new HashMap<>();
    Node createClone(Node node){
        if(mp.containsKey(node)){
            return mp.get(node);
        }
        Node clone = new Node(node.val);
        mp.put(node,clone);

        for(Node n : node.neighbors){
            clone.neighbors.add(createClone(n));
            
        }
        return clone;

    }
    public Node cloneGraph(Node node) {
        //connected graph 
        if(node == null) return null;
        return createClone(node);

    }
}