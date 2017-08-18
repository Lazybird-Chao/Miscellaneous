package mylintcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
	public List<Integer> mergekSortedArrays(int[][] arrays) {
		if(arrays==null)
			return new ArrayList<Integer>();
		PriorityQueue<pair> q = new PriorityQueue<pair>(1,
				new Comparator<pair>(){
				public int compare(pair a, pair b) {
					return a.value-b.value;
				}
		});
		int[] index = new int[arrays.length];
		for(int i=0; i<index.length; i++) {
			index[i] = 0;
			if(index[i] < arrays[i].length)
				q.offer(new pair(i,arrays[i][0]));
		}
		List<Integer> res = new ArrayList<Integer>();
		while(!q.isEmpty()) {
			pair tmp = q.poll();
			res.add(tmp.value);
			if(index[tmp.id]<arrays[tmp.id].length-1) {
				index[tmp.id]++;
				q.offer(new pair(tmp.id, arrays[tmp.id][index[tmp.id]]));
			}
		}
		return res;
	}
	
	class pair{
		int id;
		int value;
		public pair(int i, int v) {
			id = i;
			value = v;
		}
	}

}
