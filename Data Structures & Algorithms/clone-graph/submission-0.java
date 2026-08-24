

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node,Node> oldToNew = new HashMap<>();
        return dfs(node,oldToNew);
    }

    private Node dfs(Node node, Map<Node, Node>oldToNew){
        if(node==null){
            return null;
        }
        if(oldToNew.containsKey(node)){
            return oldToNew.get(node);
        }
        Node copy = new Node(node.val);
        oldToNew.put(node,copy);

        for(Node nei:node.neighbors){
            copy.neighbors.add(dfs(nei, oldToNew));
        }
        return copy;
    }
}