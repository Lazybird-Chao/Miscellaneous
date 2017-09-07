package amazon;

import common.TreeNode;

public class LCAofBST {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null)
			return null;
		if(p.val<root.val && q.val<root.val)
			return lowestCommonAncestor(root.left, p, q);
		else if(p.val>root.val && q.val>root.val)
			return lowestCommonAncestor(root.right, p, q);
		else
			return root;
			
	}

}
