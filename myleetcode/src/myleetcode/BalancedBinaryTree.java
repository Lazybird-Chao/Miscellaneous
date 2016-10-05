package myleetcode;
import myleetcode.InvertBtree.TreeNode;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root){
		return depth(root)>0;
	}
	
	public int depth(TreeNode root){
		if(root == null)
			return 0;
		else{
			int leftdepth = depth(root.left);
			if(leftdepth<0)
				return -1;
			int rightdepth= depth(root.right);
			if(rightdepth<0)
				return -1;
			if((leftdepth - rightdepth > 1) ||
					(leftdepth - rightdepth <-1)){
				return -1;
			}
			else{
				return leftdepth>rightdepth? leftdepth+1: rightdepth +1;
			}
				
		}
	}
}
