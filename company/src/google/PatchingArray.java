package google;

public class PatchingArray {
	/*
    int minPatches(vector<int>& nums, int n) {
        if(nums.empty())
            return 0;
        int f[n+1];
        memset(f, 0, sizeof(int)*(n+1));
        for(int i=0; i<nums.size(); i++){
            int k = nums[i];
            for(int j = n-k; j>=1; j--){
                if(f[j]!=0)
                    f[j+k] = 1;
            }
            f[k] = 1;
        }
        int count = 0;
        for(int i=1; i<=n; i++){
            if(f[i] == 0){
                count++;
                for(int j = n-i; j>=1; j--){
                    if(f[j] != 0)
                        f[j+i] = 1;
                }
                f[i] = 1;
                //cout<<i<<endl;
            }
         
        }
        return count;
    }
    */
    int minPatches(vector<int>& nums, int n){
        long curmax = 0;
        int i = 0;
        int count = 0;
        while(curmax < n){
            if(i >= nums.size() || curmax+1 < nums[i]){
                curmax = curmax*2 + 1;
                count++;
            }else{
                curmax = nums[i] + curmax;
                i++;
            }
            //cout<<curmax<<endl;
        }
        return count;
    }

}
