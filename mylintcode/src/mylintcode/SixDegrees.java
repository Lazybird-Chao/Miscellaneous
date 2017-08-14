package mylintcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class SixDegrees {
	public int sixDegrees(List<UndirectedGraphNode> graph,
            UndirectedGraphNode s,
            UndirectedGraphNode t) {
		if(graph==null || graph.size()==0)
			return -1;
		
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		Set<UndirectedGraphNode> accessed = new HashSet<UndirectedGraphNode>();
		queue.offer(s);
		accessed.add(s);
		int step = 0;
		if(s==t)
			return step;
		while(!queue.isEmpty()) {
			step++;
			int curSize = queue.size();
			for(int i=0; i<curSize; i++) {
				UndirectedGraphNode cur = queue.poll();
				for(UndirectedGraphNode neighbor: cur.neighbors) {
					if(t==neighbor)
						return step;
					if(accessed.add(neighbor))
						queue.offer(neighbor);
				}
			}
		}
		return -1;	
		
	}

}
