package contest;

public class PartitionToKequalSumSubsets_698 {
	public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return false;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % k != 0)
            return false;
        sum = sum / k;
        boolean[] visited = new boolean[nums.length];
        return helper(nums, 0, visited, sum, 0, k);
        
    }
    boolean helper(int[] nums, int index, boolean[] visited, int sum, int curSum, int k){
        if(curSum == sum){
            if(k == 1)
                return true;
            else
                return helper(nums, 0, visited, sum, 0, k-1);
        }
        
        for(int i = index; i < nums.length; i++){
            if(visited[i])
                continue;
            if(curSum + nums[i] <= sum){
                visited[i] = true;
                if(helper(nums, i+1, visited, sum, curSum+nums[i], k))
                    return true;
                visited[i] = false;
            }
        }
        return false;
    }

}
