package mylintcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets2 {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> curR = new ArrayList<Integer>();
		if(nums==null || nums.length==0){
			result.add(curR);
			return result;
		}
		Arrays.sort(nums);
		helper(nums, 0, result, curR);
		return result;
	}
	
	void helper(int[] nums, int start, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> curR){
		if(start==nums.length){
			ArrayList<Integer> curR_copy = new ArrayList<Integer>();
			curR_copy.addAll(curR);
			result.add(curR_copy);
			return;
		}
		
		int i= start; 
		int j= i+1;
		while(j<nums.length && nums[j]==nums[i])
			j++;
		int k = j-i;
		while(k>=0){
			for(int p=0; p<k; p++)
				curR.add(nums[i]);
			helper(nums, j, result, curR);
			for(int p=0; p<k; p++)
				curR.remove(curR.size()-1);
			k--;
		}
		return;
	}

}
