package mylintcode;

public class WindowSum {
	public int[] winSum(int[] nums, int k) {
		if(nums==null || nums.length==0 || nums.length<k)
			return new int[0];
		int[] res = new int[nums.length-k+1];
		res[0] = 0;
		for(int i=0; i<k; i++)
			res[0] += nums[i];
		for(int i=k; i<nums.length; i++)
			res[i+1-k] = res[i-k]-nums[i-k] + nums[i];
		return res;
	}

}
