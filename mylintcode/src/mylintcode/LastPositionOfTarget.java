package mylintcode;

public class LastPositionOfTarget {
	public int lastPosition(int[] nums, int target) {
		if(nums == null || nums.length ==0)
			return -1;
		int start, end;
		start = 0;
		end = nums.length-1;
		while(start+1 < end){
			int mid = start + (end-start)/2;
			if(nums[mid] < target)
				start = mid;
			else if(nums[mid] > target)
				end = mid;
			else 
				start = mid;
		}
		if(nums[end] == target)
			return end;
		else if(nums[start] == target)
			return start;
		else
			return -1;
	}

}
