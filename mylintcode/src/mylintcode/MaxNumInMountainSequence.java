package mylintcode;

public class MaxNumInMountainSequence {
	public int mountainSequence(int[] nums) {
		if(nums == null || nums.length ==0)
			return -1;
		int start, end;
		start = 0;
		end = nums.length-1;
		while(start+1 < end){
			int mid = start + (end-start)/2;
			if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
				return nums[mid];
			else if(nums[mid] > nums[mid-1] && nums[mid]< nums[mid+1])
				start = mid;
			else if(nums[mid] < nums[mid-1] && nums[mid]> nums[mid+1])
				end = mid;
		}
		if(nums[start]>nums[end])
			return nums[start];
		else
			return nums[end];
	}

}
