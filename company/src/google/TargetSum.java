package google;

public class TargetSum {
	int findTargetSumWays(vector<int>& nums, int S) {
        if(nums.empty())
            return 0;
        int sum = 0;
        for(int i=0; i<nums.size(); i++)
            sum += nums[i];
        if(S > sum || S < -sum)
            return 0;
        cout<<sum<<endl;
        int memo[20][2001];
        for(int i=0; i<nums.size(); i++)
            for(int j=0; j<2*sum+1; j++)
                memo[i][j] = -1;
        return helper(nums, 0, 0, S, memo, sum);
    }
    
    int helper(vector<int>& nums, int index, int sum, int target, int memo[20][2001], int offset){
        if(index >= nums.size()){
            if(sum == target)
                return 1;
            else
                return 0;
        }
        if(memo[index][sum+offset] != -1)
            return memo[index][sum+offset];
        int count = 0;
        count += helper(nums, index+1, sum-nums[index], target, memo, offset);
        count += helper(nums, index+1, sum+nums[index], target, memo, offset);
        memo[index][sum+offset] = count;
        return count;
        
    }

}
