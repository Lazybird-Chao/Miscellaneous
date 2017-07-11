package mylintcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations2 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums==null || nums.length==0){
			result.add(new ArrayList<Integer>());
			return result;
		}
		List<Integer> curR = new ArrayList<Integer>();
		helper(nums, 0, result, curR);
		return result;
	}
	
	public void helper(int[] nums, int start, List<List<Integer>> result, List<Integer> curR){
		if(start >= nums.length){
			List<Integer> curR_copy = new ArrayList<Integer>();
			curR_copy.addAll(curR);
			result.add(curR_copy);
			return;
		}
		Set<Integer> checkUse =new HashSet<Integer>();
		for(int i= start; i< nums.length; i++){
			if(checkUse.contains(nums[i])==false){
				curR.add(nums[i]);
				checkUse.add(nums[i]);
				int tmp = nums[i];
				nums[i] = nums[start];
				nums[start] = tmp;
				helper(nums, start+1, result, curR);
				curR.remove(curR.size()-1);
				nums[start] = nums[i];
				nums[i] = tmp;		
			}
		}
		return;
	}

}
