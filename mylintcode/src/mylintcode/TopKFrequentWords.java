package mylintcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
	public String[] topKFrequentWords(String[] words, int k) {
		if(words==null)
			return new String[0];
		PriorityQueue<pair> q = new PriorityQueue<pair>(1, 
				new Comparator<pair>() {
			public int compare(pair a, pair b) {
				if( a.count != b.count)
					return a.count -b.count;
				else 
					return b.s.compareTo(a.s);
			}
		});
		
		Map<String, Integer> records = new HashMap<String, Integer>();
		for(int i=0; i<words.length; i++) {
			String s = words[i];
			int c = 0;
			if(records.containsKey(s)) 
				c = records.get(s)+1;
			else 
				c = 1;
			records.put(s, c);
		}
		int qSize = k;
		for(String s: records.keySet()) {
			int c = records.get(s);
			if(qSize>0) {
				q.offer(new pair(s, c));
				qSize--;
			}
			else {
				q.offer(new pair(s,c));
				q.poll();
			}		
		}
		String[] res = new String[q.size()];
		int i = q.size()-1;
		while(!q.isEmpty()){
			res[i] = q.poll().s;
			i--;
		}
		return res;
		
	}
	
	class pair{
		String s;
		int count;
		public pair(String s, int c) {
			this.s = s;
			count = c;
		}
	}

}
