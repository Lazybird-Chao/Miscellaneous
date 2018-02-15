package google;

public class RelativeRank {
	vector<string> findRelativeRanks(vector<int>& nums) {
        if(nums.empty())
            return vector<string>();
        int maxn = INT_MIN;
        int minn = INT_MAX;
        for(int i=0; i<nums.size(); i++){
            maxn = max(maxn, nums[i]);
            minn = min(minn, nums[i]);
        }
        int bucket[maxn-minn+1];
        memset(bucket, 0, sizeof(int)*(maxn-minn+1));
        for(int i=0; i<nums.size(); i++){
            bucket[nums[i]-minn] = i+1;
        }
        vector<string> res(nums.size());
        int k=1;
        for(int i=maxn-minn; i>=0; i--){
            if(bucket[i] != 0){
                //cout<<bucket[i]<<endl;
                if(k==1)
                    res[bucket[i]-1] = "Gold Medal";
                else if(k==2)
                    res[bucket[i]-1] = "Silver Medal";
                else if(k==3)
                    res[bucket[i]-1] = "Bronze Medal";
                else
                    res[bucket[i]-1] = to_string(k);
                k++;
            }
        }
        return res;
        
    }

}
