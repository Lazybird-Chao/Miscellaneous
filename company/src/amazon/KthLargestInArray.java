package amazon;

import java.util.PriorityQueue;

public class KthLargestInArray {
	public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length < k)
            return 0;
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for(int i=0; i<nums.length; i++){
            if(q.size() < k)
                q.offer(nums[i]);
            else{
                if(nums[i] > q.peek()){
                    q.poll();
                    q.offer(nums[i]);
                }
            }
        }
        return q.peek();
    }

}
