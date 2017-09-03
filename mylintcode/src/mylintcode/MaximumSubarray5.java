package mylintcode;

import java.util.LinkedList;
import java.util.List;

public class MaximumSubarray5 {
	public int maxSubarray5(int[] nums, int k1, int k2) {
		if(nums==null || nums.length<k1)
			return 0;
		
		int minPre = 0;
		int minpreIndex = -1;
		int max = Integer.MIN_VALUE;
		int[] sum = new int[nums.length+1];
		sum[0] = 0;
		for(int i=0; i<nums.length; i++) {
			sum[i+1] = sum[i] + nums[i];
			if(i-minpreIndex >= k1 && i-minpreIndex <=k2){
				max = Math.max(max, sum[i+1]-minPre);
				if(minPre > sum[i-k1+1+1]){
				    minPre = sum[i-k1+1+1];
				    minpreIndex = i-k1+1;
				}
			}
			else if(i-minpreIndex > k2) {
				minPre = sum[i-k2+1];
				minpreIndex = i-k2;
				for(int j=i-k2+1; j<=i-k1; j++) {
					if(minPre>sum[j+1]){
					    minPre = sum[j+1];
					    minpreIndex = j;
					}
				}
				max = Math.max(max, sum[i+1]-minPre);	
			}		
		}
		return max;
	}
	
	public int method2(int[] nums, int k1, int k2) {
		if(nums==null || nums.length<k1)
			return 0;
		
		int max = Integer.MIN_VALUE;
		int[] presum = new int[nums.length+1];
		presum[0] = 0;
		LinkedList<Integer> minList = new LinkedList<Integer>();
		
		for(int i=1; i<=nums.length; i++) {
			presum[i] += presum[i-1] + nums[i-1];
			while(!minList.isEmpty() && i-minList.getFirst()>k2)
				minList.removeFirst();
			if(!minList.isEmpty())
				max = Math.max(max, presum[i] - presum[minList.getFirst()]);
			if(i-k1>=0) {
				while(!minList.isEmpty() && presum[i-k1] < minList.getLast()) {	
					minList.removeLast();
				}
			}
			minList.add(i-k1);
			
		}
		return max;
	}

}
