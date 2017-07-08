package mylintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
	class UndirectedGraphNode {
		      int label;
		      ArrayList<UndirectedGraphNode> neighbors;
		      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
		  };
		  
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null)
			return null;
		
		Map<Integer, Boolean> accessed = new HashMap<Integer, Boolean>();
		Queue<UndirectedGraphNode> accList = new LinkedList<UndirectedGraphNode>();
		Map<Integer, UndirectedGraphNode> gCopy = new HashMap<Integer, UndirectedGraphNode>();
		accList.offer(node);
		accessed.put(node.label, true);
		
		while(accList.isEmpty()==false){
			UndirectedGraphNode cur = accList.poll();
			UndirectedGraphNode nodeCopy;
			if(gCopy.containsKey(cur.label))
				nodeCopy = gCopy.get(cur.label);
			else{
				nodeCopy = new UndirectedGraphNode(cur.label);
				gCopy.put(cur.label, nodeCopy);
			}
			for(UndirectedGraphNode n: cur.neighbors){
				if(!accessed.containsKey(n.label)){
					accList.offer(n);
				}
				accessed.put(n.label, true);
				if(gCopy.containsKey(n.label))
					nodeCopy.neighbors.add(gCopy.get(n.label));
				else{
					UndirectedGraphNode tmpn = new UndirectedGraphNode(n.label);
					gCopy.put(n.label, tmpn);
					nodeCopy.neighbors.add(tmpn);
				}
			}
		}
		return gCopy.get(node.label);
	}

}
