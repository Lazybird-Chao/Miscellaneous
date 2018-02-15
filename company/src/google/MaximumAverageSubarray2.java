package google;

public class MaximumAverageSubarray2 {
	double findMaxAverage(vector<int>& nums, int k) {
        if(nums.empty())
            return 0;
        double maxavg = nums[0];
        double minavg = nums[0];
        for(int i=0; i<nums.size(); i++){
            maxavg = max(maxavg, (double)nums[i]);
            minavg = min(minavg, (double)nums[i]);
        }
        vector<double> nums_for_check(nums.size());
        while(minavg + (1e-5) < maxavg){
            double avg = minavg + (maxavg-minavg)/2;
            //cout<<avg<<endl;
            for(int i=0; i<nums.size(); i++)
                nums_for_check[i] = nums[i] - avg;
            if(checkAverage(nums_for_check, k) == true)
                minavg = avg;
            else
                maxavg = avg;
        }
        return maxavg;
    }
    
    bool checkAverage(vector<double>& nums, int k){
        double presum1 = 0;
        double presum2 = 0;
        double premin = 0;
        double subsum = 0;
        for(int i=0; i<nums.size(); i++){
            presum1 += nums[i];
            if(i==k-1)
                subsum = presum1;
            else if(i>=k){
                presum2 += nums[i-k];
                premin = min(premin, presum2);
                subsum = max(subsum, presum1-premin);
            }
        }
        if(subsum >=0)
            return true;
        else
            return false;
    }

}
