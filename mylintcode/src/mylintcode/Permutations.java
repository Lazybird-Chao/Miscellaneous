package mylintcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums ==null || nums.length ==0){
			result.add(new ArrayList<Integer>());
			return result;
		}
		List<Integer> curR = new ArrayList<Integer>();
		helper(nums, 0, result, curR);
		return result;
	}
	
	public void helper(int[] nums, int start, List<List<Integer>> result, List<Integer> curR){
		if(start>= nums.length){
			List<Integer> cur_copy = new ArrayList<Integer>();
			cur_copy.addAll(curR);
			result.add(cur_copy);
			return;
		}
		
		for(int i=start; i< nums.length; i++){
			curR.add(nums[i]);
			int tmp = nums[i];
			nums[i] = nums[start];
			nums[start] = tmp;
			helper(nums, start+1, result, curR);
			curR.remove(curR.size()-1);
			nums[start] = nums[i];
			nums[i] = tmp;
		}
		return;
	}

}
