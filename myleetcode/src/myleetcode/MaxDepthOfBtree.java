package myleetcode;


public class MaxDepthOfBtree {
	
	public int maxDepth(TreeNode root){
		int depth = 0;
		if(root == null)
			return depth;
		int ldepth = maxDepth(root.left);
		int rdepth = maxDepth(root.right);
		depth = ldepth > rdepth ? 1+ldepth : 1+rdepth;
		return depth;
	}
}
