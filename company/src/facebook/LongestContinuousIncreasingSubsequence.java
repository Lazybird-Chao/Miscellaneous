package facebook;

public class LongestContinuousIncreasingSubsequence {
	public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length ==0)
            return 0;
        int start = 0;
        int end = 1;
        int maxlen = 1;
        while(end < nums.length){
            if(nums[end] <= nums[end-1]){
                maxlen = Math.max(maxlen, end-start);
                start = end;
            }
            end++;
        }
        maxlen = Math.max(maxlen, end-start);
        return maxlen;
    }
}


