package amazon;

import common.TreeNode;

public class LCA {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null)
			return null;
		return helper(root, p, q);
	}
	
	TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null)
			return null;
		if(root == p || root == q)
			return root;
		TreeNode left = helper(root.left, p, q);
		if(left != null && left !=p && left != q)
			return left;
		TreeNode right = helper(root.right, p, q);
		if(right != null && right !=p && right != q)
			return right;
		if(left !=null && right != null)
			return root;
		if(left != null)
			return left;
		else 
			return right;
		
	}

}
