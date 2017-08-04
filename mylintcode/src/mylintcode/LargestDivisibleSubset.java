package mylintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		if(nums==null || nums.length==0)
			return new ArrayList<Integer>();
		Arrays.sort(nums);
		int[] maxCount = new int[nums.length];
		int[] preIndex = new int[nums.length];
		for(int i=0; i<nums.length; i++) {
			maxCount[i]=1;
			preIndex[i] = i;
		}
		for(int i=1; i<nums.length; i++) {
			for(int j=0; j<i; j++) {
				if(nums[i] % nums[j]==0 && maxCount[j]+1 >= maxCount[i]) {
					maxCount[i] = maxCount[j]+1;
					preIndex[i] = j;
				}
			}
		}
		int max = maxCount[0];
		int index = 0;
		for(int i=1; i<nums.length; i++) {
			if(max < maxCount[i]) {
				max = maxCount[i];
				index = i;
			}
		}
		List<Integer> res = new ArrayList<Integer>();
		while(preIndex[index] != index) {
			res.add(nums[index]);
			index = preIndex[index];
		}
		res.add(nums[index]);
		return res;
	}

}
