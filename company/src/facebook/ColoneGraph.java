package facebook;

public class ColoneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
        UndirectedGraphNode newGraph = new UndirectedGraphNode(node.label);
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        q.offer(node);
        map.put(node, newGraph);
        while(!q.isEmpty()){
            UndirectedGraphNode curnode = q.poll();
            UndirectedGraphNode curcopy = map.get(curnode);
            for(UndirectedGraphNode neighbor : curnode.neighbors){
                if(map.containsKey(neighbor)){
                    curcopy.neighbors.add(map.get(neighbor));
                } else{
                    UndirectedGraphNode ncopy = new UndirectedGraphNode(neighbor.label);
                    curcopy.neighbors.add(ncopy);
                    q.offer(neighbor);
                    map.put(neighbor, ncopy);
                }
            }
        }
        return newGraph;
    }

}
