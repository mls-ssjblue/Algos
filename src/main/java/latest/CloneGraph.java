package latest;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };
    public Node cloneGraph(Node node) {
        Node newnode = new Node(node.val, node.neighbors);
        Queue<Node> q = new LinkedList();
        q.addAll(node.neighbors);
        while(!q.isEmpty()){
            Node a = q.remove();

        }
        return newnode;
    }
}
