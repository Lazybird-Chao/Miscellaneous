package facebook;

public class SubSet2 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        ArrayList<Integer> subset = new ArrayList<Integer>();
        dfs(nums, 0, subset, res);
        return res;
    }
    
    void dfs(int[] nums, int index, ArrayList<Integer> subset, List<List<Integer>> res){
        if(index == nums.length){
            List<Integer> tmp = new ArrayList<Integer>(subset);
            res.add(tmp);
            return;
        }
        int i = index+1;
        while(i < nums.length && nums[i] == nums[index])
            i++;
        for(int j = 0; j <= i-index; j++){
            dfs(nums, i, subset, res);
            subset.add(nums[index]);
        }
        for(int j = 0; j <= i-index; j++)
            subset.remove(subset.size()-1);
        return;
    }
    
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>());
        if(nums.length == 0)    return ret;
        Arrays.sort(nums);
        
        for(int i = 0, j = 0; i < nums.length; i++) {
            int size = ret.size();
            if(i == 0 || nums[i] != nums[i - 1])    j = 0;
            
            for(; j < size; j++) {
                List<Integer> newSub = new ArrayList<>(ret.get(j));
                newSub.add(nums[i]);
                ret.add(newSub);
            }
            
            j = size;
        }
        return ret;
        
    }

}
