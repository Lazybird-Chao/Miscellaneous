package google;

public class MaxConsecutiveOne {
	int findMaxConsecutiveOnes(vector<int>& nums) {
        if(nums.empty())
            return 0;
        int maxcount = 0;
        int curcount = 0;
        int pre = 0;
        int i=0;
        while(i<nums.size()){
            if(nums[i] == pre){
                if(pre==1)
                    curcount++;
            }else{
                if(pre == 1)
                    maxcount = max(maxcount, curcount);
                pre = nums[i];
                curcount = pre==1 ? 1:0;
            }
            i++;
        }
        maxcount = max(maxcount, curcount);
        return maxcount;
    }

}
