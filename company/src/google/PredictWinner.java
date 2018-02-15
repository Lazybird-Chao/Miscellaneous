package google;

public class PredictWinner {
	bool PredictTheWinner(vector<int>& nums) {
        if(nums.empty())
            return true;
        int f[nums.size()][nums.size()];
        int g[nums.size()][nums.size()];
        int presum[nums.size()];
        for(int i=0; i<nums.size(); i++){
            f[i][i] = nums[i];
            g[i][i] = 0;
            if(i>0)
                presum[i] = presum[i-1] + nums[i];
            else
                presum[i] = nums[i];
        }
        for(int i=nums.size()-2; i>=0; i--){
            for(int j=i+1; j<nums.size(); j++){
                int takei = nums[i] + g[i+1][j];
                int takej = nums[j] + g[i][j-1];
                f[i][j] = max(takei, takej);
                int sumij = 0;
                if(i>0)
                    sumij = presum[j]-presum[i-1];
                else
                    sumij = presum[j];
                g[i][j] = sumij - f[i][j];
                //cout<<f[i][j]<<" ";
            }
            //cout<<endl;
        }
        //cout<<f[0][nums.size()-1]<<" "<<presum[nums.size()-1]<<endl;
        return f[0][nums.size()-1] >= presum[nums.size()-1] - f[0][nums.size()-1];
    }

}
