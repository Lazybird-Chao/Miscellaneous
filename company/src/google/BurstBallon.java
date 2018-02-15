package google;

public class BurstBallon {
	int maxCoins(vector<int>& nums) {
        if(nums.empty())
            return 0;
        int f[nums.size()][nums.size()];
        memset(f, 0, sizeof(int)*nums.size()*nums.size());
        for(int i=0; i<nums.size(); i++){
            f[i][i] = nums[i];
            if(i-1>=0)
                f[i][i] *= nums[i-1];
            if(i+1<=nums.size()-1)
                f[i][i] *= nums[i+1];
            //cout<<f[i][i]<<" ";
        }
        //cout<<endl;
        for(int len = 2; len <= nums.size(); len++){
            for(int i=0; i<=nums.size()-len; i++){
                f[i][i+len-1] = 0;
                int sum1=0, sum2=0, sum3=0;
                for(int j=i; j<=i+len-1; j++){
                    sum2 = nums[j];
                    sum1 = sum3 = 0;
                    if(i-1>=0)
                        sum2 *= nums[i-1];
                    if(i+len < nums.size())
                        sum2 *= nums[i+len];
                    if(j-1>=i){
                        sum1 = f[i][j-1];
                    }
                    if(j+1<=i+len-1){
                        sum3 = f[j+1][i+len-1];
                    }
                    f[i][i+len-1] = max(f[i][i+len-1], sum1+sum2+sum3);
                }
                //cout<<f[i][i+len-1]<<" ";
            }
            //cout<<endl;
        }
        return f[0][nums.size()-1];
    }

}
