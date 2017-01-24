package myleetcode;

public class ThirdMaxNumber {
	static public int thirdMax(int[] nums){
		long max1, max2, max3;
		max1 = max2 = max3 = (long)Integer.MIN_VALUE-1;
		for(int i=0; i<nums.length; i++){
			if(nums[i]>max1){
				max3 = max2;
				max2 = max1;
				max1 = nums[i];
			}
			else if(nums[i]>max2 && nums[i]!=max1){
				max3 = max2;
				max2 = nums[i];
			}
			else if(nums[i]>max3 && nums[i]!=max1 && nums[i]!=max2){
				max3 = nums[i];
			}
		}
		long res = max3==(long)Integer.MIN_VALUE-1? max1: max3;
		return (int)res;
	}
	
	static public void main(String args[]){
		thirdMax(new int[]{3,2,1});
	}

}
