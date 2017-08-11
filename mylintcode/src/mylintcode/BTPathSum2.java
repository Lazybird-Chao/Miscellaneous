package mylintcode;

import java.util.ArrayList;
import java.util.List;

public class BTPathSum2 {
	public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
		if(root==null)
			return new ArrayList<List<Integer>>();
		ans = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		helper(root, target, path);
		return ans;
		
	}
	
	List<List<Integer>> ans;
	void helper(TreeNode root, int target, List<Integer> path) {
		if(root==null)
			return;
		int i;
		int sum = 0;
		path.add(root.val);
		for(i=path.size()-1; i>=0; i--) {
			sum += path.get(i);
			if(sum == target) {
				int j =i;
				List<Integer> oneAns = new ArrayList<Integer>();
				while(j<path.size()) {
					oneAns.add(path.get(j));
					j++;
				}
				ans.add(oneAns);
			}
		}
		
		helper(root.left, target, path);
		helper(root.right, target, path);
		path.remove(path.size()-1);
		return;
	}

}
