package mylintcode;

public class ClassicalBinarySearch {
	public int findPosition(int[] nums, int target) {
		if(nums==null || nums.length ==0)
			return -1;
		int left = 0; 
		int right = nums.length-1;
		while(left+1<right) {
			int mid = left+(right-left)/2;
			if(target==nums[mid])
				return mid;
			else if(target>nums[mid])
				left = mid;
			else
				right = mid;
		}
		if(nums[left]==target)
			return left;
		else if(nums[right]==target)
			return right;
		else
			return -1;
	}

}
