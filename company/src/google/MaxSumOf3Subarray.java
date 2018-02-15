package google;

public class MaxSumOf3Subarray {
	vector<int> maxSumOfThreeSubarrays(vector<int>& nums, int k) {
        if(nums.size() < 3*k)
            return vector<int>();
        vector<int> sumk(nums.size());
        int sum = 0;
        for(int i=nums.size()-1; i>=0; i--){
            if(i>nums.size()-k){
                sum += nums[i];
                sumk[i] = 0;
            }else{
                sum += nums[i];
                sumk[i] = sum;
                sum -= nums[i+k-1];
            }
        }
        vector<int> maxsub[nums.size()][4];
        maxsub[nums.size()-k][1] = vector<int>({nums.size()-k, sumk[nums.size()-k]});
        for(int i=nums.size()-k-1; i>=0; i--){
            if(sumk[i] >= maxsub[i+1][1][1])
                maxsub[i][1] = vector<int>({i, sumk[i]});
            else
                maxsub[i][1] = maxsub[i+1][1];
        }
        maxsub[nums.size()-2*k][2] = vector<int>({nums.size()-2*k, nums.size()-k, sumk[nums.size()-2*k]+sumk[nums.size()-k]});
        for(int i=nums.size()-2*k-1; i>=0; i--){
            int cur_max = sumk[i];
            cur_max += maxsub[i+k][1][1];
            if(cur_max >= maxsub[i+1][2][2])
                maxsub[i][2] = vector<int>({i, maxsub[i+k][1][0], cur_max});
            else
                maxsub[i][2] = maxsub[i+1][2];
        }
        maxsub[nums.size()-3*k][3] = vector<int>({nums.size()-3*k, nums.size()-2*k, nums.size()-k, 
                                                  sumk[nums.size()-3*k]+sumk[nums.size()-2*k]+sumk[nums.size()-k]});
        for(int i=nums.size()-3*k-1; i>=0; i--){
            int cur_max = sumk[i];
            cur_max += maxsub[i+k][2][2];
            if(cur_max >= maxsub[i+1][3][3])
                maxsub[i][3] = vector<int>({i, maxsub[i+k][2][0], maxsub[i+k][2][1], cur_max});
            else
                maxsub[i][3] = maxsub[i+1][3];
        }    
        vector<int> res = {maxsub[0][3][0], maxsub[0][3][1], maxsub[0][3][2]};
        return res;
    }

}
