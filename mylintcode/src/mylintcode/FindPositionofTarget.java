package mylintcode;

public class FindPositionofTarget {
	public int binarySearch(int[] nums, int target) {
		if(nums==null || nums.length==0)
			return -1;
		if(target<nums[0] || target>nums[nums.length-1])
			return -1;
		int left = 0;
		int right = nums.length-1;
		while(left +1 <right) {
			int mid = left+(right-left)/2;
			if(nums[mid]>=target)
				right=mid;
			else
				left = mid;
		}
		if(nums[left]==target)
			return left;
		else if(nums[right]==target)
			return right;
		else
			return -1;
	}

}
