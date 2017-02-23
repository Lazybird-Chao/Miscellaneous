package myleetcode;

import java.util.HashSet;
import java.util.Set;

public class MaxXorInArray {
	public int findMaximumXor(int[] nums){
		if(nums==null || nums.length<2)
			return 0;
		int max = 0;
		for(int i=1; i<nums.length; i++){
			for(int j=0; j<i; j++){
				int tmp = nums[i]^nums[j];
				if(tmp>max)
					max = tmp;
			}
		}
		return max;
	}
	
	 public int method2(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
	 
	 public int method3(int[] nums){
		 // using binary tree to represent all the num
		 
		 
		 return 0;
	 }
}
