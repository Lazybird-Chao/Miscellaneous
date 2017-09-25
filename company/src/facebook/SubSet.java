package facebook;

public class SubSet {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return res;
        List<Integer> subset = new ArrayList<Integer>();
        dfs(nums, 0, subset, res);
        return res;
    }
    
    void dfs(int[] nums, int pos, List<Integer> subset, List<List<Integer>> res){
        if(pos == nums.length){
            res.add(new ArrayList<Integer>(subset));
            return;
        }
        dfs(nums, pos+1, subset, res);
        subset.add(nums[pos]);
        dfs(nums, pos+1, subset, res);
        subset.remove(subset.size()-1);
        return;
    }

}
