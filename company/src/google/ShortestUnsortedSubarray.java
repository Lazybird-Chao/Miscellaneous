package google;

public class ShortestUnsortedSubarray {
	int findUnsortedSubarray(vector<int>& nums) {
        if(nums.empty())
            return 0;
        int start=0;
        while(start < nums.size()-1 && nums[start]<=nums[start+1])
            start++;
        if(start == nums.size()-1)
            return 0;
        int end = nums.size()-1;
        while(end > start && nums[end]>=nums[end-1])
            end--;
        int min_n = nums[start];
        int max_n = nums[start];
        for(int i=start; i<=end; i++){
            min_n = min(min_n, nums[i]);
            max_n = max(max_n, nums[i]);
        }
        int i, j;
        i=0;
        while(i<start && nums[i] <= min_n)
            i++;
        j = nums.size()-1;
        while(j>end && nums[j] >= max_n)
            j--;
        return j-i+1;
    }

}
