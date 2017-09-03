package mylintcode;

public class MinimunDepthofBT {
	public int minDepth(TreeNode root) {
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
			return 1;
		int lmin = Integer.MAX_VALUE;
		int rmin = Integer.MAX_VALUE;
		if(root.left!=null)
			lmin = minDepth(root.left);
		if(root.right!=null)
			rmin = minDepth(root.right);
		return Math.min(lmin, rmin)+1;
	}
	

}
