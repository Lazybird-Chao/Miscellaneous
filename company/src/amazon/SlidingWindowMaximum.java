package amazon;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || nums.length == 0)
			return new int[0];
		Deque<Integer> q = new LinkedList<Integer>();
		int maxpos=0;;
        q.addLast(0);
		for(int i=1; i<k; i++){
			if(nums[maxpos] <= nums[i])
				maxpos = i;
            if(nums[i] <= nums[q.getLast()])  // must be <=
				q.addLast(i);
			else {
				while(!q.isEmpty() && nums[q.getLast()]<nums[i]) // can also be <=
					q.removeLast();
				q.addLast(i);
			}          
        }
		int[] res = new int[nums.length-k+1];
		int j = 0;
		res[j++] = nums[maxpos];
		for(int i=k; i<nums.length; i++) {
			if(nums[i] <= nums[q.getLast()])  // must be <=
				q.addLast(i);
			else {
				while(!q.isEmpty() && nums[q.getLast()]<nums[i]) // can also be <=
					q.removeLast();
				q.addLast(i);
			}
			if(i-k == q.getFirst())
				q.removeFirst();
			res[j++] = nums[q.getFirst()];	
		}
		return res;
    }

}
