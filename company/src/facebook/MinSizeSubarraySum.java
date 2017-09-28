package facebook;

public class MinSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length ==0)
            return 0;
        
        int minlen = nums.length+1;
        int start = 0;
        int end = 0;
        int sum = nums[0];
        while(start <= end && end < nums.length){
            if(sum < s){
                end++;
                if(end  < nums.length)
                    sum += nums[end];
            } else{
                minlen = Math.min(minlen, end-start+1);
                sum -= nums[start];
                start++;
            }
        }
        if(minlen == nums.length+1)
            return 0;
        else
            return minlen;
    }

}
