import java.util.*;

public class Solution133 {
    private static class Node {
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

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> que = new LinkedList<>();
        Queue<Node> que_cp = new LinkedList<>();
        que.offer(node);
        Node cur, cur_cp, node_cp = new Node(node.val);
        que_cp.offer(node_cp);
        map.put(node_cp.val, node_cp);
        Node temp;
        List<Node> list;
        while(!que.isEmpty()){
            cur = que.poll();
            cur_cp = que_cp.poll();
            list = new ArrayList<>(cur.neighbors.size());
            for(Node neigh : cur.neighbors){
                if(!map.containsKey(neigh.val)){
                    temp = new Node(neigh.val);
                    list.add(temp);
                    map.put(temp.val, temp);
                    que.offer(neigh);
                    que_cp.offer(temp);
                }else{
                    list.add(map.get(neigh.val));
                }
            }
            cur_cp.neighbors = list;
        }
        return node_cp;
    }

}
