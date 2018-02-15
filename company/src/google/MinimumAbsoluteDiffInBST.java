package google;

public class MinimumAbsoluteDiffInBST {
	int mindiff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root == null)
            return 0;
        helper(root, null);
        return mindiff;
    }
    TreeNode helper(TreeNode root, TreeNode pre){
        if(root==null)
            return pre;
        TreeNode curpre = helper(root.left, pre);
        if(curpre != null)
            mindiff = Math.min(mindiff, Math.abs(curpre.val-root.val));
        TreeNode curlast = helper(root.right, root);
        return curlast;
    }

}
