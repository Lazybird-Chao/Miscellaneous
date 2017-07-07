package mylintcode;

public class BalancedBT {
	public boolean isBalanced(TreeNode root) {
		helper(root);
		return balanced;
	}
	
	
	public boolean balanced = true;
	
	public int helper(TreeNode root){
		if(root==null)
			return 0;
		int leftdep = helper(root.left);
		int rightdep = helper(root.right);
		if(Math.abs(leftdep-rightdep)>1)
			balanced = false;
		return Math.max(leftdep+1, rightdep+1);
	}

}
