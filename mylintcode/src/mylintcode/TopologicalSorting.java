package mylintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class TopologicalSorting {
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
		if(graph==null || graph.size()==0)
			return new ArrayList<DirectedGraphNode>();
		Map<DirectedGraphNode, Integer> inDegree = new HashMap<DirectedGraphNode, Integer>();
		buildIndegree(graph, inDegree);
		Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
		for(DirectedGraphNode node: graph) {
			if(inDegree.get(node)==0) {
				queue.offer(node);
			}
		}
		ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
		while(!queue.isEmpty()) {
			DirectedGraphNode cur = queue.poll();
			res.add(cur);
			for(DirectedGraphNode neighbor: cur.neighbors) {
				int tmp = inDegree.get(neighbor);
				inDegree.put(neighbor, tmp-1);
				if(tmp-1==0) {
					queue.offer(neighbor);
				}
			}
		}
		return res;
		
	}
	
	public void buildIndegree(ArrayList<DirectedGraphNode> graph, Map<DirectedGraphNode, Integer> inDegree) {
		for(DirectedGraphNode node: graph) {
			if(!inDegree.containsKey(node))
				inDegree.put(node, 0);
			for(DirectedGraphNode neighbor: node.neighbors) {
				int tmp = inDegree.getOrDefault(neighbor, 0);
				inDegree.put(neighbor, tmp+1);
			}
		}	
	}

}
