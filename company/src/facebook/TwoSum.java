package facebook;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length ==0)
            return new int[0];
        Map<Integer, Integer> s = new HashMap<Integer, Integer>();
        for(int i= 0; i < nums.length; i++){
            if(s.containsKey(nums[i])){
                int[] res = {i, s.get(nums[i])};
                return res;
            }
            s.put(target-nums[i], i);
        }
        return new int[0];
    }

}
