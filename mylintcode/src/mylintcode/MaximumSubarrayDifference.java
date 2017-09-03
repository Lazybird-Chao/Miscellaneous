package mylintcode;

public class MaximumSubarrayDifference {
	public int maxDiffSubArrays(int[] nums) {
		if(nums==null || nums.length==0)
			return 0;
		
		int[] reversnums = new int[nums.length];
		for(int i=0, j=nums.length-1; i<nums.length; i++,j--)
			reversnums[i] = nums[j];
		
		int[] maxarray = maxSub(nums);
		int[] minarray = minSub(nums);
		int[] rmaxarray = maxSub(reversnums);
		int[] rminarray = minSub(reversnums);
		
		int maxdiff = 0;
		for(int i=0; i<nums.length-1; i++) {
			maxdiff = Math.max(maxdiff, Math.abs(maxarray[i]-rminarray[nums.length-1-(i+1)]));
			maxdiff = Math.max(maxdiff, Math.abs(minarray[i]-rmaxarray[nums.length-1-(i+1)]));
		}
		return maxdiff;
		
	}
	
	int[] maxSub(int[] nums) {
		int minPre = 0;
		int max = 0;
		int sum = 0;
		int maxsub[] = new int[nums.length];
		
		max = nums[0];
		for(int i=0; i<nums.length; i++) {
			sum += nums[i];
			max = Math.max(sum-minPre, max);
			maxsub[i] = max;
			minPre = Math.min(minPre, sum);
		}
		return maxsub;
		
	}
	
	int[] minSub(int[] nums) {
		int maxPre = 0;
		int min = 0;
		int sum = 0;
		int minsub[] = new int[nums.length];
		
		min = nums[0];
		for(int i=0; i<nums.length; i++) {
			sum += nums[i];
			min = Math.min(sum-maxPre, min);
			minsub[i] = min;
			maxPre = Math.max(maxPre, sum);
		}
		return minsub;
		
	}

}
