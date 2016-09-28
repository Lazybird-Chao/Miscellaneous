package myleetcode;

import myleetcode.InvertBtree.TreeNode;

public class SameBtree {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}

	public boolean isSameTree(TreeNode p, TreeNode q){
		boolean res;
		if(p==null && q ==null)
			return res=true;
		else if(p==null || q == null)
			return res = false;
		if(p.val == q.val)
			res = isSameTree(p.left, q.left) &&
					isSameTree(p.right, q.right);
		else
			res = false;
		return res;
	}
}
