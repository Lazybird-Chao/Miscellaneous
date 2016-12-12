package myleetcode;

public class MinimumDepthBTree {
	public int minDepth(TreeNode root){
		if(root == null)
			return 0;
		else
			return findMinDepth(root,1, Integer.MAX_VALUE);
	}
	
	public int findMinDepth(TreeNode root, int currentDepth, int minDepth){
		if(currentDepth >= minDepth)
			return minDepth;
		if(root.left == null && root.right == null){
			return currentDepth;
		}
		else{
			if(root.left!=null){
				int lmin = findMinDepth(root.left, currentDepth+1, minDepth);
				minDepth = minDepth>lmin? lmin: minDepth;
			}
			if(root.right!=null){
				int rmin = findMinDepth(root.right, currentDepth+1, minDepth);
				minDepth = minDepth>rmin? rmin: minDepth;
			}
			return minDepth;
		}
	}
}
