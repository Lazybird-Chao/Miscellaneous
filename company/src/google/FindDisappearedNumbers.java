package google;

public class FindDisappearedNumbers {
	vector<int> findDisappearedNumbers(vector<int>& nums) {
        if(nums.empty())
            return vector<int>();
        int i = 0;
        while(i < nums.size()){
            if(nums[i] != i+1){
                int tmp = nums[nums[i]-1];
                if(tmp != nums[i]){
                    nums[nums[i]-1] = nums[i];
                    nums[i] = tmp;
                }else
                    i++;
            }else{
                i++;
            }
        }
        vector<int> res;
        i = 0;
        while(i<nums.size()){
            //cout<<nums[i]<<endl;
            if(nums[i] != i+1)
                res.push_back(i+1);
            i++;
        }
        return res;
    }

}
