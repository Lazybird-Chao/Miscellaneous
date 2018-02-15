package google;

public class TreeSumSmaller {
	int threeSumSmaller(vector<int>& nums, int target) {
        if(nums.empty())
            return 0;
        sort(nums.begin(), nums.end());
        int count = 0;
        for(int i=0; i<(int)nums.size()-2; i++){
            int t = target - nums[i];
            int j = i+1;
            int k = nums.size()-1;
            while(j<k){
                if(nums[j] + nums[k] < t){
                    count += k - (j+1) +1;
                    j++;
                }
                else if(nums[j] + nums[k] >= t){
                    k--;
                }
            }
        }
        return count;
    }

}
