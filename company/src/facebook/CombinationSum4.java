package facebook;

public class CombinationSum4 {
	public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return 0;
        //return (int)dfs(nums, target);
        return dp(nums, target);
    }
    
    long dfs(int[] nums, int target){
        if(target < 0)
            return 0;
        if(target == 0)
            return 1;
        long count = 0;
        for(int i = 0; i < nums.length; i++)
            count += dfs(nums, target - nums[i]);
        return count;
    }
    
    int dp(int[] nums, int target){
        int[] f = new int[target+1];
        for(int i = 1; i <= target; i++){
            int count = 0;
            for(int j = 0; j<nums.length; j++){
                if(nums[j] == i)
                    count++;
                else if(nums[j] < i)
                    count += f[i-nums[j]];
            }
            f[i] = count;
        }
        return f[target];
    }

}
