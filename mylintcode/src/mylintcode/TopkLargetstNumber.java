package mylintcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class TopkLargetstNumber {
	public int[] topk(int[] nums, int k) {
		if(nums==null || nums.length==0 || k>nums.length)
			return new int[0];
		Queue<Integer> minQ = new PriorityQueue<Integer>();
		for(int i=0; i<k; i++)
			minQ.add(nums[i]);
		for(int i=k; i<nums.length; i++){
			if(nums[i]>minQ.peek()) {
				minQ.poll();
				minQ.add(nums[i]);
			}
		}
		int[] res = new int[k];
		for(int i=k-1; i>=0; i--)
			res[i] = minQ.poll();
		return res;
			
	}

}
