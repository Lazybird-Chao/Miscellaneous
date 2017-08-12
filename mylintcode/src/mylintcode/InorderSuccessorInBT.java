package mylintcode;

public class InorderSuccessorInBT {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if(root==null || p==null)
			return null;
		TreeNode bigParent = null;
		while(root!=p) {
			if(p.val<=root.val) {
				bigParent = root;
				root = root.left;
			}
			else {
				root = root.right;
			}
		}
		if(p.right!=null) {
			p = p.right;
			while(p.left!=null)
				p=p.left;
			return p;
		}
		else
			return bigParent;
	}

}
