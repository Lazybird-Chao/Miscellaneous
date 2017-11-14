package google;

public class KthSmallestInBST {
	public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return 0;
        int[] res = new int[1];
        helper(root, k, res);
        return res[0];
    }
    int helper(TreeNode root, int k, int[] res){
        if(root == null)
            return 0;
        if(k<=0)
            return 0;
        int left = helper(root.left, k, res);
        if(left == k-1)
            res[0] = root.val;  
        int right = helper(root.right, k-left-1, res);
        return left+right + 1;
    }

}
