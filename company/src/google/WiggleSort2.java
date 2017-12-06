package google;

public class WiggleSort2 {
	void wiggleSort(vector<int>& nums) {
        if(nums.empty())
            return;
        vector<int> snums(nums);
        sort(snums.begin(), snums.end());
        int startpart1 = 0;
        if(nums.size() % 2 ==0)
            startpart1 = nums.size()/2-1;
        else
            startpart1 = nums.size()/2;
        int startpart2 = nums.size()-1;
        int i = 0;
        while(i < nums.size()/2 * 2){
            nums[i++] = snums[startpart1--];
            nums[i++] = snums[startpart2--];
        }
        if(nums.size() % 2 !=0)
            nums[i] = snums[0];
        return;
        
    }
}
