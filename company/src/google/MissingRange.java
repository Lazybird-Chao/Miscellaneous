package google;

public class MissingRange {
	vector<string> findMissingRanges(vector<int>& nums, int lower, int upper) {
        if(nums.empty()){
            if(lower == upper)
                return vector<string>({to_string(lower)});
            else
                return vector<string>({to_string(lower)+"->"+to_string(upper)}); 
        }
        vector<string> res;
        if(lower < nums[0]){
            if(nums[0]-1 == lower)
                res.push_back(to_string(lower));
            else
                res.push_back(to_string(lower)+"->"+to_string(nums[0]-1));
        }
        int i= 0;
        while(i < nums.size()-1){
            if(nums[i] == nums[i+1] ||  nums[i+1]-1 == nums[i]){
                i++;
                continue;
            }
            if(nums[i]+1 == nums[i+1]-1)
                res.push_back(to_string(nums[i]+1));
            else
                res.push_back(to_string(nums[i]+1)+"->"+to_string(nums[i+1]-1));
            i++;
        }
        if(upper > nums[i]){
            if(nums[i]+1 == upper)
                res.push_back(to_string(upper));
            else
                res.push_back(to_string(nums[i]+1)+"->"+to_string(upper));
        }
        return res;
        
    }

}
