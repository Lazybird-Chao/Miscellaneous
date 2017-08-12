package mylintcode;

public class BTMaximumPathSum2 {
	public int maxPathSum2(TreeNode root) {
		if(root==null)
			return 0;
		int maxsum = root.val;
		int lsum = maxPathSum2(root.left);
		maxsum = Math.max(maxsum, lsum+root.val);
		int rsum = maxPathSum2(root.right);
		maxsum = Math.max(maxsum, rsum+root.val);
		return maxsum;
	}

}
