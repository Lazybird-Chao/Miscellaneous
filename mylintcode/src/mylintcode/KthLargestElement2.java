package mylintcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement2 {
	public int kthLargestElement2(int[] nums, int k) {
		if(nums == null || nums.length ==0 || k>nums.length)
			return -1;
		Queue<Integer> minQ = new PriorityQueue<Integer>();
		for(int i=0; i<k; i++)
			minQ.add(nums[i]);
		for(int i=k; i<nums.length; i++) {
			if(nums[i] > minQ.peek()) {
				minQ.poll();
				minQ.add(nums[i]);
			}
		}
		return minQ.peek();
	}

}
