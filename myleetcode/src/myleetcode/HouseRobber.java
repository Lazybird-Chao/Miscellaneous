package myleetcode;

public class HouseRobber {
	public int rob(int[] nums){
		/// f(0) = max(nums[0] + f(2), f(1))
		
		int ret=0;
		if(nums.length == 0)
			ret =0;
		else if(nums.length == 1)
			ret = nums[0];
		else {
			int[] subnums1 = new int[nums.length -1];
			for(int i=1; i<nums.length; i++)
				subnums1[i-1]= nums[i];
			int ret1 = rob(subnums1);
			
			int[] subnums2 = new int[nums.length-2];
			for(int i=2; i<nums.length; i++)
				subnums2[i-2]= nums[i];
			int ret2 = nums[0] + rob(subnums2);
			
			ret = ret1 >ret2 ? ret1: ret2;
		}
		return ret;
	}
	
	public int method2(int[] nums){
		if(nums.length==0)
			return 0;
		else{
			int[] ret = new int[nums.length+1];
			ret[nums.length] = 0;
			ret[nums.length-1] = nums[nums.length-1];
			for(int i=nums.length-2; i>=0; i--){
				int ret1 = ret[i+1];
				int ret2 = nums[i] + ret[i+2];
				ret[i] = ret1 >ret2? ret1: ret2;
			}
			return ret[0];			
		}
	}
}
