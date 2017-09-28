package facebook;

public class ContinuousSubarraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return false;
        if(k<0)
            k = -1*k;
        Map<Integer, Integer> presums = new HashMap<Integer, Integer>();
        int presum = 0;
        presums.put(presum, -1);
        for(int i = 0; i < nums.length; i++){
            presum += nums[i];
            if(k == 0 && presums.containsKey(presum) && i- presums.get(presum) >=2)
                return true;
            else if(k > 0 && presums.containsKey(presum % k) && i - presums.get(presum % k)>=2)
                return true;
            if(k > 0 && !presums.containsKey(presum % k))
                presums.put(presum % k, i);
            else if(k==0 && !presums.containsKey(presum))
                presums.put(presum, i);
        }
        return false;
    }

}
