package facebook;

public class MaxSizeSubarrayEqualK {
	public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return 0;
        Map<Integer, Integer> presumrecord = new HashMap<Integer, Integer>();
        int presum = 0;
        presumrecord.put(0,0);
        int maxlen = 0;
        for(int i=0; i<nums.length; i++){
            presum += nums[i];
            if(presumrecord.containsKey(presum-k)){
                int len = i - presumrecord.get(presum-k) +1;
                maxlen = Math.max(maxlen, len);
            }
            if(!presumrecord.containsKey(presum))
                presumrecord.put(presum, i+1);
        }
        return maxlen;
    }

}
