package mylintcode;

public class TwoSumSortedArray {
	public int[] twoSum(int[] nums, int target) {
		if(nums == null || nums.length == 0)
			return new int[0];
		int i, j;
		i=0;
		j=nums.length-1;
		int[] res = new int[2];
		while(i<j){
			int sum = nums[i] + nums[j];
			if(sum == target){
				res[0] = i+1;
				res[1] = j+1;
				break;
			}
			else if(sum > target){
				j--;
			}
			else{
				i++;
			}
		}
		return res;
	}

}
