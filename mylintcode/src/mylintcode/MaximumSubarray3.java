package mylintcode;

public class MaximumSubarray3 {
	public int maxSubArray(int[] nums, int k) {
		if(nums==null || nums.length<k)
			return 0;
		record = new int[k][nums.length];
		for(int i=0; i<k; i++)
			for(int j=0; j<nums.length; j++)
				record[i][j] = Integer.MIN_VALUE;
		return findMax(nums, k, 0);
	}
	
	int[][] record;
	int findMax(int[] nums, int k, int startPos) {
		if(nums.length-startPos < k)
			return Integer.MIN_VALUE;
		if(record[k-1][startPos]!=Integer.MIN_VALUE)
			return record[k-1][startPos];
		
		int res = Integer.MIN_VALUE;
		int sum = 0;
		int maxsum = nums[startPos];
		for(int i=startPos; i<nums.length-(k-1); i++) {
			sum += nums[i];
			maxsum = Math.max(maxsum, sum);
			if(sum<0)
				sum=0;
			res = Math.max(res,  maxsum + findMax(nums, k-1, i+1));	
		}
		record[k][startPos] = res;
		return res;
	}

}
