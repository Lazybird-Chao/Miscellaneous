package mylintcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RemoveSubstrings {
	public int minLength(String s, Set<String> dict) {
		if(s==null || s=="")
			return 0;
		Queue<String> queue = new LinkedList<String>();
		Set<String> accessed = new HashSet<String>();
		queue.offer(s);
		accessed.add(s);
		int minlen=s.length();
		while(!queue.isEmpty()) {
			String cur = queue.poll();
			boolean find = false;
			for(String item: dict) {
				int start = cur.indexOf(item);
				while(start>=0) {
					find = true;
					String tmp = cur.substring(0, start)+cur.substring(start+item.length(), cur.length());
					if(!accessed.contains(tmp)) {
						queue.offer(tmp);
						accessed.add(tmp);
					}
					start = cur.indexOf(item, start+item.length());
				}
			}
			if(!find)
				minlen = Math.min(cur.length(), minlen);
		}
		return minlen;
		
	}

}
