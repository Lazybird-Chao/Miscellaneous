package mylintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ConnectedComponentInUndirectedGraph {
	public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
		if(nodes==null || nodes.size()==0)
			return new ArrayList<List<Integer>>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Set<Integer> visited = new HashSet<Integer>();
		for(UndirectedGraphNode node : nodes) {
			if(!visited.contains(node.label)) {
				res.add(bfs(nodes, visited, node));
			}
		}
		return res;
	}
	
	public List<Integer> bfs(ArrayList<UndirectedGraphNode> nodes, Set<Integer> visited, UndirectedGraphNode start) {
		List<Integer> res = new ArrayList<Integer>();
		Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
		q.offer(start);
		visited.add(start.label);
		res.add(start.label);
		while(!q.isEmpty()) {
			UndirectedGraphNode cur = q.poll();
			for(UndirectedGraphNode neighbor: cur.neighbors) {
				if(visited.contains(neighbor.label)==false) {
					q.offer(neighbor);
					visited.add(neighbor.label);
					res.add(neighbor.label);
				}
			}
		}
		int[] res2 = new int[res.size()];
		for(int i=0; i<res.size(); i++)
			res2[i] = res.get(i);
		Arrays.sort(res2);
		res.clear();
		for(int i=0; i<res2.length; i++)
		    res.add(res2[i]);
		return res;
	}

}
