package myleetcode;

import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement1 {
	public int[] nextGreaterElement(int[] findNums, int[] nums){
		Map<Integer, Integer> nextGreater = new HashMap<Integer, Integer>();
		int i=0;
		while(i<nums.length-1){
			int k=i;
			while(k<nums.length-1 && nums[k]>nums[k+1])
				k++;
			nextGreater.put(nums[k], nums[k+1]);
			int nextstart = k+1;
			int j = k+1;
			k--;
			while(j<nums.length){
				while(k>=i){
					if(nums[j]>nums[k])
						nextGreater.put(nums[k], nums[j]);
					else
						break;
					k--;
				}
				j++;
			}
			if(j==nums.length){
				while(k>=i)
					nextGreater.put(nums[k], -1);
			}
			i = nextstart;
		}
		nextGreater.put(nums[i], -1);
		
		int[] res = new int[findNums.length];
		for(int j=0; j<findNums.length; j++){
			res[j] = nextGreater.get(findNums[j]);
		}
		return res;
	}
}
