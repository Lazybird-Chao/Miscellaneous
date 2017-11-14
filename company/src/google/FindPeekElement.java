package google;

public class FindPeekElement {
	 public int findPeakElement(int[] nums) {
	        if(nums == null || nums.length ==0)
	            return -1;
	        int left = 0;
	        int right = nums.length-1;
	        while(left + 1 < right){
	            int mid = left + (right-left)/2;
	            if(nums[mid] > nums[mid+1])
	                right = mid;
	            else
	                left = mid;
	        }
	        if(nums[left] > nums[right])
	            return left;
	        else
	            return right;
	 }

}
