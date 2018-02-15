package google;

public class MaxConsecutive2 {
	int findMaxConsecutiveOnes(vector<int>& nums) {
        if(nums.empty())
            return 0;
        int maxcount = 0;
        int precount1 = 0;
        int precount2 = 0;
        for(int i=0; i<nums.size(); i++){
            int tmp1 = 0;
            int tmp2 = 0;
            if(nums[i] == 0){
                 tmp1 = 0;
                 tmp2 = precount1 + 1;
            }else{
                tmp1 = 1+precount1;
                tmp2 = 1+precount2;
            }
            precount1 = tmp1;
            precount2 = tmp2;
            maxcount = max(maxcount, max(tmp1, tmp2));
        }
        return maxcount;
    }

}
