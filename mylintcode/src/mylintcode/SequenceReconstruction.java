package mylintcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SequenceReconstruction {
	public boolean sequenceReconstruction(int[] org, int[][] seqs) {
		if(org==null || seqs==null)
			return false;
		if(seqs.length==0 || seqs[0].length==0)
		    if(org.length==0)
		        return true;
		    else
		        return false;
		boolean[][] graph = new boolean[org.length+1][org.length+1];
		if(buildGraph(seqs, graph)==false)
		    return false;
		
		List<Integer> topoSeq = new ArrayList<Integer>();
		while(true) {
			int nextNode = zeroIndegreeNode(graph);
			if(nextNode==0)
				break;
			topoSeq.add(nextNode);
			deleteNode(graph, nextNode);
		}
	    //System.out.println(topoSeq.size());
		if(org.length != topoSeq.size())
			return false;
		for(int i=0; i<org.length; i++)
			if(org[i]!=topoSeq.get(i))
				return false;
		return true;
	}
	
	public boolean buildGraph(int[][] seqs, boolean[][] graph) {
		for(int i=0; i<seqs.length; i++) {
		    if(seqs[i][0]>graph.length)
		        return false;
			for(int j=1; j<seqs[i].length; j++) {
				int from = seqs[i][j-1];
				int to = seqs[i][j];
				if(from>=graph.length || to>=graph.length)
				    return false;
				graph[from][to] = true;		
			}
		}
		return true;
	}
	
	public void deleteNode(boolean[][] graph, int fromNode) {
		for(int j=1; j<graph[0].length; j++)
			graph[fromNode][j] = false;
		graph[0][fromNode] = true;
	}
	
	public int zeroIndegreeNode(boolean[][] graph) {
		int count = 0;
		int index = 0;
		for(int j=1; j<graph[0].length; j++) {
			boolean noIn = true;
			for(int i=0; i<graph.length; i++) {
				if(graph[i][j]) {
					noIn = false;
					break;
				}
			}
			if(noIn) {
				count++;
				index = j;
			}
			if(count>1)
				break;
		}
		if(count>1)
			return 0;
		else
			 return index;
	
    }
}
