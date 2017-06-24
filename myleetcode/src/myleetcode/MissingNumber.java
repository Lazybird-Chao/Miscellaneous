package myleetcode;

public class MissingNumber {
	public int missingNumber(int[] nums){
		int i=0;
		while(i<nums.length){
			if(nums[i] != i && nums[i]!=nums.length){
				int tmp = nums[nums[i]];
				nums[nums[i]] = nums[i];
				nums[i] = tmp;
			}
			else{
				i++;
			}
		}
		for( i=0; i<nums.length; i++){
			if(nums[i]!=i)
				break;
		}
		return i;
		
	}
	
	public int method2(int[] nums){
		int res=0;
		for(int i=0; i<nums.length; i++){
			res = res^i;
			res = res^nums[i];
		}
		return res^nums.length;
	}
	
	public int method3(int[] nums){
		int sum=(0 + nums.length)*(nums.length+1)/2;
		for(int i=0; i<nums.length; i++){
			sum = sum-nums[i];
		}
		return sum;
	}

}
