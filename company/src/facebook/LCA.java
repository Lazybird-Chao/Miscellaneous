package facebook;

public class LCA {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || p == null || q == null)
            return null;
        return helper(root, p, q);
    }
    
    TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return null;
        if(root == p || root == q)
            return root;
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);
        if(left == null)
            return right;
        else if(right == null)
            return left;
        else
            return root;
    }

}
