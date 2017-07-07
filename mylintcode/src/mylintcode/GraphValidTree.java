package mylintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphValidTree {
	public boolean validTree(int n, int[][] edges) {
		if(edges == null || edges.length != n-1)
			return false;
		if(n==1)
		    return true;
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<n; i++)
			graph.add(new ArrayList<Integer>());
		int[] dim = formGraph(n, edges, graph);
		Queue<Integer> accList = new LinkedList<Integer>();
		for(int i=0; i<n; i++){
			if(dim[i]==1)
				accList.offer(i);
			if(dim[i]==0)
				return false;
		}
		int nodeCount = 0;
		while(accList.isEmpty()==false){
			int cur = accList.poll();
			dim[cur]--;
			nodeCount++;
			for(int neighbor: graph.get(cur)){
				dim[neighbor]--;
				if(dim[neighbor]==1)
					accList.offer(neighbor);
			}
		}
		if(nodeCount==n)
			return true;
		else
			return false;
		
	}
	
	public int[] formGraph(int n, int[][] edges, ArrayList<ArrayList<Integer>> graph){
		int[] dim = new int[n];
		for(int i=0; i<edges.length; i++){
			graph.get(edges[i][0]).add(edges[i][1]);
			graph.get(edges[i][1]).add(edges[i][0]);
			dim[edges[i][0]]++;
			dim[edges[i][1]]++;
		}
		return dim;
	}

}
