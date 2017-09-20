package facebook;

import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length <3)
            return res;
        Arrays.sort(nums);
        int i = nums.length-1;
        while(i>=0){
            int c = nums[i];
            int j = 0;
            int k = i-1;
            while(j<k){
                int sum = c + nums[j] +nums[k];
                if(sum == 0){
                    List<Integer> item = new ArrayList<Integer>();
                    item.add(nums[j]);
                    item.add(nums[k]);
                    item.add(c);
                    res.add(item);
                    ++j;
                    while(j<k && nums[j]==nums[j-1])
                        ++j;
                    --k;
                    while(j<k && nums[k]==nums[k+1])
                        --k;
                } else if(sum > 0){
                    --k;
                } else{
                    ++j;
                }        
            }
            --i;
            while(i>=0 && nums[i]==nums[i+1])
                --i; 
        }
        return res;
    }
    

}
