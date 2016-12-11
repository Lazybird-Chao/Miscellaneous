package myleetcode;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum){
		if(root==null)
			return false;
		else if(root.left==null && root.right==null && root.val == sum)
			return true;
		else if( hasPathSum(root.left, sum - root.val))
			return true;
		else if( hasPathSum(root.right, sum-root.val))
			return true;
		else
			return false;
			
	}
}
