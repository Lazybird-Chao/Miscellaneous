package google;

public class NextGreaterElement2 {
	vector<int> nextGreaterElements(vector<int>& nums) {
        if(nums.empty())
            return vector<int>();
        vector<int> nextIdx(nums.size());
        nextIdx[nums.size()-1] = -1;
        int i =  nums.size()-2;
        while(i>=0){
            int j = i+1;
            while(j != -1 && nums[i] >= nums[j])
                j = nextIdx[j];
            nextIdx[i] = j;
            i--;
        }
        
        i = nums.size()-1;
        while(i>=0){
            if(nextIdx[i] != -1){
                i--;
                continue;
            }
            int j = (i+1)%nums.size();
            while(j != -1 && nums[i] >= nums[j])
                j = nextIdx[j];
            nextIdx[i] = j;
            i--;
        }
        vector<int> res;
        i = 0;
        while(i<nums.size()){
            if(nextIdx[i] != -1)
                res.push_back(nums[nextIdx[i]]);
            else
                res.push_back(-1);
            i++;
        }
        return res;
        
    }

}
