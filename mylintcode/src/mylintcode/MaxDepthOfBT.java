package mylintcode;

public class MaxDepthOfBT {
	public int max=0;
	
	public int maxDepth(TreeNode root) {
		helper(root, 0);
		return max;
	}
	
	public void helper(TreeNode root, int depth){
		if(root == null)
			return;
		if(root.left==null && root.right == null){
			max = Math.max(depth+1, max);
			return;
		}
		
		helper(root.left, depth+1);
		helper(root.right, depth+1);	
	}

}
