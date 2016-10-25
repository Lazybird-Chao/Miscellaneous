package myleetcode;
import java.util.HashMap;

import myleetcode.InvertBtree.TreeNode;

public class PathSum3 {
	public int pathSum(TreeNode root, int sum){
		int numPaths=0;
		if(root==null)
			return 0;
		numPaths = findSum(root, sum);
		numPaths += pathSum(root.left, sum);
		numPaths += pathSum(root.right, sum);
		
		return numPaths;
	}
	
	private int findSum(TreeNode root, int sum){
		if(root ==null)
			return 0;
		if(root.val == sum)
			return 1 + findSum(root.left, sum-root.val) +
				findSum(root.right, sum-root.val);
		else
		    return findSum(root.left, sum-root.val) +
				    findSum(root.right, sum-root.val);
	}
	
	
	public int method2(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap<Integer, Integer>();
        preSum.put(0,1);
        return helper(root, 0, sum, preSum);
    }
    
    public int helper(TreeNode root, int sum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }
        
        sum += root.val;
        int res = preSum.getOrDefault(sum - target, 0);
        preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        
        res += helper(root.left, sum, target, preSum) + helper(root.right, sum, target, preSum);
        preSum.put(sum, preSum.get(sum) - 1);
        return res;
    }
}
