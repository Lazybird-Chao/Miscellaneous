package facebook;

public class SumOfLeftLeaves {
	public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        return helper(root.left, true)+helper(root.right, false);
        
    }
    int helper(TreeNode root, boolean inLeft){
        if(root == null)
            return 0;
        if(root.left == null && root.right ==null){
            return inLeft ? root.val: 0;
        }
        int sum = 0;
        if(root.left != null)
            sum += helper(root.left, true);
        if(root.right != null)
            sum += helper(root.right, false);
        return sum;   
    }

}
