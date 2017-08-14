package mylintcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String start, String end, Set<String> dict){
		if(dict==null || dict.size()==0)
			return 0;
		Queue<String> queue = new LinkedList<String>();
		Set<String> accessed = new HashSet<String>();
		queue.offer(start);
		accessed.add(start);
		dict.add(end);
		int count = 0;
		while(!queue.isEmpty()) {
			count++;
			int size = queue.size();
			for(int i=0; i<size; i++) {
				String cur = queue.poll();
				if(cur==end)
					return count;
				for(String neighbor: buildNeighbor(cur, dict)) {
					if(!accessed.contains(neighbor)) {
						queue.offer(neighbor);
						accessed.add(neighbor);
					}
				}
				
			}
		}
		return 0;
	}
	
	public ArrayList<String> buildNeighbor(String s, Set<String> dict){
		ArrayList<String> res = new ArrayList<String>();
		for(String t: dict)
			if(differ(s, t)==1)
				res.add(t);
		return res;
	}
	
	public int differ(String s1, String s2) {
		if(s1.length() != s2.length())
			return -1;
		int count=0;
		for(int i=0; i<s1.length(); i++)
			if(s1.charAt(i)!=s2.charAt(i))
				count++;
		return count;
	}

}
