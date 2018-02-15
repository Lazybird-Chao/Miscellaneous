package google;

public class ReversePairs {
	int reversePairs(vector<int>& nums) {
        if(nums.size() < 2)
            return 0;
        int count = helper(nums, 0, nums.size()-1);
        return count;
    }
    int helper(vector<int>& nums, int start, int end){
        if(start==end)
            return 0;
        int count = 0;
        if(start+1 == end){
            if((long)nums[start] > 2*((long)nums[end])){
                count++;   
            }
            if(nums[start] < nums[end]){
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
            }
            return count;
        }
        int mid = start + (end-start)/2;
        count += helper(nums, start, mid);
        count += helper(nums, mid+1, end);
        int m[end-start+1];
        int i=start;
        int j=mid+1;
        while(i<=mid && j<=end){
            if((long)nums[i] > 2*((long)nums[j])){
                count += end-j+1;
                i++;
            }else
                j++;
        }
        i = start;
        j = mid+1;
        int k = 0;
        while(i<=mid && j<=end){
            if(nums[i] >= nums[j]){
                m[k++] = nums[i];
                i++;
            }else{
                m[k++] = nums[j];
                j++;
            }
        }
        while(i<=mid)
            m[k++] = nums[i++];
        while(j<=end)
            m[k++] = nums[j++];
        for(i=0; i<end-start+1; i++)
            nums[start+i] = m[i];
        return count;
    }

}
