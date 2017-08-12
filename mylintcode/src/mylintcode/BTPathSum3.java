package mylintcode;

import java.util.ArrayList;
import java.util.List;

public class BTPathSum3 {
	public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
		if(root==null)
			return new ArrayList<List<Integer>>();
		ans = new ArrayList<List<Integer>>();
		helper2(root, target);
		return ans;
	}
	
	List<List<Integer>> ans;
	
	void helper2(ParentTreeNode root, int target) {
		if(root==null)
			return;
		List<Integer> path = new ArrayList<Integer>();
		helper(root, target, null, path);
		
		helper2(root.left, target);
		helper2(root.right, target);
		return;
	}
	
	void helper(ParentTreeNode root, int target, ParentTreeNode father, List<Integer> path) {
		if(root==null)
			return;
		if(root.val==target) {
			List<Integer> tmp = new ArrayList<Integer>(path);
			tmp.add(root.val);
			ans.add(tmp);
		}
		
		if(root.parent!=null && root.parent!=father) {
			path.add(root.val);
			helper(root.parent, target-root.val, root, path);
			path.remove(path.size()-1);
		}
		
		if(root.left!=null && root.left!=father) {
			path.add(root.val);
			helper(root.left, target-root.val, root, path);
			path.remove(path.size()-1);
		}
		
		if(root.right!=null && root.right!=father) {
			path.add(root.val);
			helper(root.right, target-root.val, root, path);
			path.remove(path.size()-1);
		}
		return;
		
	}

}
