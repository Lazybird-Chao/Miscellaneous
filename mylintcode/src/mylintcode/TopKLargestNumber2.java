package mylintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKLargestNumber2 {
	public class Solution {
		
		PriorityQueue<Integer> data = new PriorityQueue<Integer>();
		int sizeQ;
	    public Solution(int k) {
	        // initialize your data structure here.
	    		sizeQ = k;
	    }

	    public void add(int num) {
	        // Write your code here
	    		if(sizeQ>0) {
	    			data.offer(num);
	    			--sizeQ;
	    		}
	    		else {
	    			if(num>data.peek()) {
	    				data.offer(num);
	    				data.poll();
	    			}
	    		}
	    }

	    public List<Integer> topk() {
	        // Write your code here
	    		List<Integer> res = new ArrayList<Integer>();
	    		int[] tmp = new int[data.size()];
	    		int i=0;
	    		while(!data.isEmpty()) {
	    			tmp[i] = data.poll();
	    			++i;
	    		}
	    		--i;
	    		while(i>=0) {
	    			res.add(tmp[i]);
	    			data.offer(tmp[tmp.length-1-i]);
	    			--i;
	    		}
	    		return res;
	    }
	};

}
