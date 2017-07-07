package mylintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SearchGraphNodes {
	public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
            Map<UndirectedGraphNode, Integer> values,
            UndirectedGraphNode node,
            int target) {
		if(graph==null || graph.isEmpty())
			return null;
		Map<UndirectedGraphNode, Boolean> accessed = new HashMap<UndirectedGraphNode, Boolean>();
		for(UndirectedGraphNode n: graph)
			accessed.put(n, false);
		Queue<UndirectedGraphNode> accList = new LinkedList<UndirectedGraphNode>();
		accList.offer(node);
		accessed.replace(node, true);
		while(accList.isEmpty()==false){
			UndirectedGraphNode cur = accList.poll();
			if(values.get(cur)== target)
				return cur;
			else{
				for(UndirectedGraphNode neighbor: cur.neighbors){
					if(accessed.get(neighbor)==false){
						accessed.replace(neighbor, true);
						accList.offer(neighbor);
					}
				}
			}
		}
		return null;
		
	}

}
