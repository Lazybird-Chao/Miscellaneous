package mylintcode;

public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		if(nums==null || nums.length==0)
			return 0;
		if(nums.length==1)
		    return nums[0];
		    
		long[] f1 = new long[nums.length+1];
		long[] f2 = new long[nums.length+2];
		f1[0] = f2[0] = 0;
		long max = nums[0];
		for(int i=1; i<=nums.length; i++) {
			if(nums[i-1]>=0) {
				if(f1[i-1]==0)
					f1[i]=nums[i-1];
				else
					f1[i] = f1[i-1]*nums[i-1];
				f2[i] = f2[i-1]*nums[i-1];		
			}
			else {
				if(f1[i-1]==0)
					f2[i] = nums[i-1];
				else
					f2[i] = f1[i-1]*nums[i-1];
				f1[i] = f2[i-1]*nums[i-1];
			}
			max = Math.max(max, f1[i]);
		}
		
		
		return (int)max;
		
	}

}
