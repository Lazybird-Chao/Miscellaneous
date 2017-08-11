package mylintcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		if(nums==null || nums.length==0)
			return new ArrayList<List<Integer>>();
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		List<Integer> set = new ArrayList<Integer>();
		helper(nums, 0, ans, set);
		return ans;
		
	}
	
	void helper(int[] nums, int start, List<List<Integer>> ans, List<Integer> cur_set) {
		if(start == nums.length) {
			ans.add(new ArrayList<Integer>(cur_set));
			return;
		}
		helper(nums, start+1, ans, cur_set);
		cur_set.add(nums[start]);
		helper(nums, start+1, ans, cur_set);
		cur_set.remove(cur_set.size()-1);
		
		return;
	}

}
