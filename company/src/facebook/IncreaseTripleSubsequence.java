package facebook;

public class IncreaseTripleSubsequence {
	public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length <3)
            return false;
        int min = nums[0];
        int mid = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] <= min)
                min = nums[i];
            else if(nums[i] <= mid)
                mid = nums[i];
            else
                return true;
        }
        return false;
    }

}
