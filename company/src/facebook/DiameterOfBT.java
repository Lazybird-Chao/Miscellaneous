package facebook;

public class DiameterOfBT {
	public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        maxDiameter = 0;
        helper(root);
        return maxDiameter;
    }
    int maxDiameter;
    int helper(TreeNode root){
        if(root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        return Math.max(left+1, right+1);
    }

}
