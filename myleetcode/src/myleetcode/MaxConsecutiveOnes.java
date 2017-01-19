package myleetcode;

public class MaxConsecutiveOnes {
	public int findMaxConsecutiveOnes(int[] nums){
		int maxlength = 0;
		int sum = 0;
		for(int i= 0; i<nums.length; i++){
			if(sum + nums[i] == sum){
				if(maxlength < sum)
					maxlength = sum;
				sum = nums[i];
			}
			else
				sum++;
		}
		return maxlength<sum? sum: maxlength;
	}
}
