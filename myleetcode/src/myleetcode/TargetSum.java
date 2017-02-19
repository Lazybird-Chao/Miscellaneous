package myleetcode;

public class TargetSum {
	public int findTargetSumWays(int[] nums, int S){
		int[] posSum = new int[nums.length];
		int[] negSum = new int[nums.length];
		posSum[nums.length] = nums[nums.length];
		negSum[nums.length] = -nums[nums.length];
		for(int i=nums.length-2; i>=0; i--){
			posSum[i] = posSum[i+1] + nums[i];
			negSum[i] = negSum[i+1] - nums[i];
		}
		return searchSum(nums, 0, S, posSum, negSum);
	}
	
	public int searchSum(int[] nums, int index, int residueS, int[] posSum, int[] negSum){
		int ret=0;
		if(residueS > posSum[index] || residueS < negSum[index])
			return 0;
		if(index == nums.length-1){
			if(residueS == nums[index])
				ret++;
			if(residueS == -nums[index])
				ret++;
			return ret;
		}
		
		ret += searchSum(nums, index+1, residueS-nums[index], posSum, negSum);
		ret += searchSum(nums, index+1, residueS+nums[index], posSum, negSum);
		return ret;
	}
	
	public int method2(int[] nums, int S){
		int sum =0;
		for(int i=0; i<nums.length; i++)
			sum += nums[i];
		if((sum+S)%2 !=0)
			return 0;
		int sumP = (sum+S)/2;
		if(sumP>sum)
			return 0;
		int[] dpsum = new int[sumP+1];
		dpsum[0]=1;
		for(int i=1; i<sumP;i++)
			dpsum[i] = 0;
		for(int i=0; i< nums.length; i++){
			for(int j= sumP; j>=nums[i]; j--){
				dpsum[j] = dpsum[j] + dpsum[j-nums[i]];
			}
		}
		return dpsum[sumP];
	}
}
