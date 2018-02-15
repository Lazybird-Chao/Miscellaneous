package google;

public class CombinationsSum4 {
	 /*
    unordered_map<int, int> memo;
    int combinationSum4(vector<int>& nums, int target) {
        if(target < 0)
            return 0;
        else if(target == 0)
            return 1;
        if(memo.find(target) != memo.end())
            return memo[target];
        int count = 0;
        for(int i=0; i<nums.size(); i++){
            count += combinationSum4(nums, target-nums[i]);
        }
        memo[target] = count;
        return count;
    }
    */
    
    int combinationSum4(vector<int>& nums, int target){
        int count[target+1];
        memset(count, 0, sizeof(int)*(target+1));
        count[0] = 1;
        for(int i=1; i<= target; i++){
            for(int j=0; j<nums.size(); j++){
                if(i >= nums[j]){
                    count[i] += count[i-nums[j]];
                }
            }
        }
        return count[target];
    }

}
