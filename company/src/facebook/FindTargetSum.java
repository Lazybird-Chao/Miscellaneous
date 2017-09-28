package facebook;

public class FindTargetSum {
	public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0)
            return 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
            sum += nums[i];
        if( S > sum || S < -sum)
            return 0;
        record = new int[nums.length][sum*3+1];
        return dfs(nums, 0, S, sum);
    }
    int[][] record;
    int dfs(int[] nums, int start, int target, int sum){
        if(start == nums.length-1){
            if(nums[start] == 0 && target == 0){
                record[start][target+sum] = 2;
                return 2;
            }
            else if(nums[start] == target || -nums[start] == target){
                record[start][target+sum] = 1;
                return 1;
            }else{
                record[start][target+sum] = 0;
                return 0;
            }
        }
        if(record[start][target+sum] != 0)
            return record[start][target+sum];
        int n1 = dfs(nums, start+1, target-nums[start], sum);
        int n2 = dfs(nums, start+1, target+nums[start], sum);
        record[start][target+sum] = n1 + n2;
        return n1 + n2;
    }

}
