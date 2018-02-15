package google;

public class SubarraySumEqualK {
	int subarraySum(vector<int>& nums, int k) {
        if(nums.empty())
            return 0;
        int presum[nums.size()];
        presum[0] = nums[0];
        for(int i=1; i<nums.size(); i++){
            presum[i] = presum[i-1]+nums[i];
        }
        unordered_map<int, int> m;
        m[0] = 1;
        int count = 0;
        for(int i=0; i<nums.size(); i++){
            if(m.find(presum[i]-k) != m.end())
                count += m[presum[i]-k];
            if(m.find(presum[i])==m.end())
                m[presum[i]] = 1;
            else
                m[presum[i]]++;
        }
        return count;
    }

}
